/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar SiddhiQLGrammar;

executionPlan
    :(definitionStream|definitionTable|query)
        (';'  (definitionStream|definitionTable|query))* ';'? EOF
    ;

definitionStreamFinal
    : definitionStream ';'? EOF
    ;

definitionStream
    : anotation * 'define' 'stream' source '(' attributeName type (',' attributeName type )* ')'
    ;

definitionTableFinal
    :definitionTable ';'? EOF
    ;

definitionTable
    : anotation * 'define' 'table' source '(' attributeName type (',' attributeName type )* ')'
    ;

anotation
    : '@' name ('(' parameterName '=' parameterValue (',' parameterName '=' parameterValue )* ')' )?
    ;

partition
    :'with' 'partition' '('partitionStream (','partitionStream)*')' 'do' query+ 'done'
    ;

partitionStream
    :partitionAttribute ('and' partitionAttribute)* 'of'source
    ;

partitionAttribute
    :attributeName | conditionRange
    |'('partitionAttribute')'
    ;

conditionRange
    :(condition 'as' stringVal) ('or' condition 'as' stringVal)*
    ;

definitionQueryFinal
    : query ';'? EOF
    ;

query
    : anotation * queryInput queryProjection? outputRate? queryOutput
    ;

queryInput
    :'from' (windowedStream|joinStream|patternStream|sequenceStream)
    ;

windowedStream
    : source (filter | streamFunction)* window? (filter | streamFunction)*
    ;

joinStream
    :leftSource join rightSource 'unidirectional' ('on' condition)? withinTime?
    |leftSource join rightSource ('on' condition)? withinTime?
    |leftSource 'unidirectional' join rightSource ('on' condition)? withinTime?
    ;

leftSource
    :joinSource ('as' source)?
    ;

rightSource
    :joinSource ('as' source)?
    ;

joinSource
    :source (filter | streamFunction)* window?
    ;

patternStream
    :patternSourceChain
    ;

patternSourceChain
    : firstPatternSource  '->' followingPatternSourceChain
    | 'every'? '('patternSourceChain ')' withinTime? 
    ;

followingPatternSourceChain
    : followingPatternSource  '->' followingPatternSourceChain 
    | lastPatternSource
    | 'every'? '('followingPatternSourceChain ')' withinTime? 
    ;

firstPatternSource
    :logicalStatefulSource
    |collectionPatternSource
    |'every' (logicalStatefulSource|collectionPatternSource)
    ;

followingPatternSource
    :logicalStatefulSource withinTime?
    |collectionPatternSource  withinTime?
    |'every' (logicalStatefulSource|collectionPatternSource)
    ;

lastPatternSource
    :logicalStatefulSource withinTime?
    |collectionPatternSource withinTime?
    ;

logicalStatefulSource
    :'('logicalStatefulSource')'
    |logicalStatefulSource 'and' logicalStatefulSource
    |logicalStatefulSource 'or' logicalStatefulSource
    |standardStatefulSource
    ;

collectionPatternSource
    :standardStatefulSource '<' collect '>'
    |'('collectionPatternSource')'
    ;

standardStatefulSource
    : event '=' basicStatefulSource
    ;

basicStatefulSource
    : source (filter | streamFunction)*
    ;

sequenceStream
    :'every'? sequenceSourceChain
    ;

sequenceSourceChain
    :firstSequenceSource ',' followingSequenceSourceChain
    |'('sequenceSourceChain ')' withinTime? 
    ;

followingSequenceSourceChain
    : followingSequenceSource  (',' followingSequenceSourceChain)? 
    | '('followingSequenceSourceChain ')' withinTime? 
    ;

firstSequenceSource
    :logicalStatefulSource
    |collectionSequenceSource
    ;

followingSequenceSource
    :logicalStatefulSource withinTime?
    |collectionSequenceSource withinTime?
    ;

collectionSequenceSource
    :standardStatefulSource ('<' collect '>'|'*'|'?'|'+') 
    |'('collectionSequenceSource')'
    ;

filter
    :'#'?'['condition']'
    ;

streamFunction
    :'#' functionOperation
    ;

window
    :'#' 'window.' functionOperation
    ;

queryProjection
    :('select' ('*'| (outputAttribute (',' outputAttribute)* )))
    ;

queryOutput
    :'insert' isRaw='raw'? outputEventType 'into' target
    |'delete' target 'for' outputEventType ('on' condition)?
    |'update' target 'for' outputEventType ('on' condition)?
    |'return'
    ;

outputEventType
    :'expired-events' | 'current-events' | 'all-events' |
    ;

outputRate
    : 'output' outputType? 'every' ( time | NUMBER 'events' )
    | 'output' 'snapshot' 'every' time
    ;

outputType
    : 'all'
    | 'last'
    | 'first'
    ;

withinTime
    :'within' time
    ;

outputAttribute
    :attribute 'as' attributeName 
    |attributeReference
    ;

attribute
    :mathOperation
    ;

condition
    :mathOperation
    ;

mathOperation
    :'('mathOperation')'
    |'not' mathOperation
    |mathOperation ('*'|'/'|'%') mathOperation
    |mathOperation ('+'|'-') mathOperation
    |mathOperation ('>='|'<='|'>'|'<') mathOperation
    |mathOperation ('=='|'!=') mathOperation
    |mathOperation 'and' mathOperation
    |mathOperation 'or' mathOperation  
    |functionOperation
    |attributeReference
    |attributeValue
    ;

attributeList
    :attribute (','attribute)*
    ;

functionOperation
    :functionId '('attributeList?')'
    ;

attributeReference
    :(streamId '.')? attributeName
    ;

attributeValue
    :constant
    ;

functionId
    :id
    ;

streamId
    :id
    ;

paopertyName
    :PROPERTY_NAME_QUOTES | PROPERTY_NAME_NO_QUOTES |ID_QUOTES |ID_NO_QUOTES
    ;

attributeName
    :id
    ;

source
    :'#'?id
    ;

target
    :id
    ;

event
    :id
    ;

parameterName
    :paopertyName
    ;

name
    :id
    ;

parameterValue
    :stringVal
    ;

collect
    : NUMBER ':' NUMBER
    | NUMBER ':'
    | ':' NUMBER
    | NUMBER
    ;

type
    :STRING     #StringType
    |INT        #IntType
    |LONG       #LongType
    |FLOAT      #FloatType
    |DOUBLE     #DoubleType
    |BOOL       #BoolType
    |OBJECT     #ObjectType
    ;

join
    : 'left''outer' 'join'
    | 'right' 'outer' 'join'
    | 'full''outer' 'join'
    | 'outer' 'join'
    | 'inner' 'join'
    | 'join'
    ;


constant
    :boolVal
    |doubleVal
    |floatVal
    |longVal
    |intVal
    |time
    |stringVal
    ;

id: ID_QUOTES|ID_NO_QUOTES ;

time
    :  yearValue  ( monthValue)? ( weekValue)? ( dayValue)? ( hourValue)? ( minuteValue)? ( secondValue)?  ( milliSecondValue)?
    |  monthValue ( weekValue)? ( dayValue)? ( hourValue)? ( minuteValue)? ( secondValue)?  ( milliSecondValue)?
    |  weekValue ( dayValue)? ( hourValue)? ( minuteValue)? ( secondValue)?  ( milliSecondValue)?
    |  dayValue ( hourValue)? ( minuteValue)? ( secondValue)?  ( milliSecondValue)?
    |  hourValue ( minuteValue)? ( secondValue)?  ( milliSecondValue)?       
    |  minuteValue ( secondValue)?  ( milliSecondValue)?
    |  secondValue ( milliSecondValue)?
    |  milliSecondValue
    ;

yearValue 
    : NUMBER ( 'years' | 'year' )
    ;

monthValue
    : NUMBER ( 'months' | 'month' )
    ;

weekValue
    : NUMBER ( 'weeks' | 'week' )
    ;

dayValue
    : NUMBER ( 'days' | 'day' )
    ;

hourValue
    : NUMBER ( 'hours' | 'hour' )
    ;

minuteValue
    : NUMBER ( 'minutes' |  'min'  | 'minute' )
    ;

secondValue
    : NUMBER ( 'seconds' | 'second' | 'sec' )
    ;

milliSecondValue
    : NUMBER ( 'milliseconds' |  'millisecond' | 'millisec' )
    ;

doubleVal: negative='-'? POSITIVE_DOUBLE_VAL;
longVal: negative='-'? POSITIVE_LONG_VAL;
floatVal: negative='-'? POSITIVE_FLOAT_VAL;
intVal: negative='-'? (POSITIVE_INT_VAL|NUMBER);
boolVal: 'true'|'false';
stringVal: STRING_VAL;

STRING: 'string';

INT:'int';

LONG:'long';

FLOAT:'float';

DOUBLE:'double';

BOOL:'bool';

OBJECT:'object';

NUMBER : NUM;

POSITIVE_INT_VAL:   NUM('I'|'i')?;

POSITIVE_LONG_VAL:   NUM ('L'|'l');

POSITIVE_FLOAT_VAL: NUM ('.' NUM)? NUM_SCI? ('F'|'f');

POSITIVE_DOUBLE_VAL :  NUM ('.' NUM NUM_SCI? ('D'|'d')?| NUM_SCI? ('D'|'d'));

fragment NUM_SCI: ('e'|'E') '-'? NUM;

fragment NUM: '0'..'9'+;

PROPERTY_NAME_QUOTES : '`'ID_NO_QUOTES ('.'ID_NO_QUOTES ) ('.'ID_NO_QUOTES )*'`' {setText(getText().substring(1, getText().length()-1));};

PROPERTY_NAME_NO_QUOTES : ID_NO_QUOTES ('.'ID_NO_QUOTES ) ('.'ID_NO_QUOTES )* ;

ID_QUOTES : '`'('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*'`' {setText(getText().substring(1, getText().length()-1));};

ID_NO_QUOTES : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

STRING_VAL
    :('\'' ( ~('\u0000'..'\u001f' | '\\' | '\''| '\"' ) )* '\'' 
    |'"' ( ~('\u0000'..'\u001f' | '\\'  |'\"') )* '"' )         {setText(getText().substring(1, getText().length()-1));}
    ;

//Hidden channels

WS  : (' '|'\r'|'\t'|'\u000C'|'\n')   ->  channel(HIDDEN)
    ;
COMMENT
    : '/*' .*? '*/'  ->  channel(HIDDEN)
    ;
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' ->  channel(HIDDEN)
    ;



