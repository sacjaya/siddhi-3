/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar SiddhiQL;

parse
    : execution_plan EOF
    ;

error
 : UNEXPECTED_CHAR 
   { 
     throw new RuntimeException("UNEXPECTED_CHAR=" + $UNEXPECTED_CHAR.text); 
   }
 ;

execution_plan
    :(definition_stream|definition_table|query|partition|error)
        (';'  (definition_stream|definition_table|query|partition|error))* ';'? 
    ;

definition_stream_final
    : definition_stream ';'? EOF
    ;

definition_stream
    : anotation * K_DEFINE K_STREAM source '(' attribute_name type (',' attribute_name type )* ')'
    ;

definition_table_final
    :definition_table ';'? EOF
    ;

definition_table
    : anotation * K_DEFINE K_TABLE source '(' attribute_name type (',' attribute_name type )* ')'
    ;

anotation
    : '@' name ('(' property_name '=' property_value (',' property_name '=' property_value )* ')' )?
    ;

partition
    : K_PARTITION K_WITH '('partition_with_stream (','partition_with_stream)* ')' K_BEGIN (query|error) (';' (query|error))* ';'? K_END 
    ;

partition_final
    : partition ';'? EOF
    ;

partition_with_stream
    :attribute K_OF stream_id
    |condition_ranges K_OF stream_id 
    ;

condition_ranges
    :condition_range (K_OR condition_range)*
    ;

condition_range
    :condition K_AS string_value
    ;

definition_query_final
    : query ';'? EOF
    ;

query
    : anotation * query_input query_section? output_rate? query_output
    ;

query_input
    :K_FROM (standard_stream|join_stream|pattern_stream|sequence_stream)
    ;

standard_stream
    : source (filter | stream_function)* window? (filter | stream_function)*
    ;

join_stream
    :left_source=join_source join right_source=join_source K_UNIDIRECTIONAL (K_ON condition)? within_time?
    |left_source=join_source join right_source=join_source (K_ON condition)? within_time?
    |left_source=join_source K_UNIDIRECTIONAL join right_source=join_source (K_ON condition)? within_time?
    ;

join_source
    :source (filter | stream_function)* window? (K_AS stream_alias)?
    ;

pattern_stream
    :every_pattern_source_chain 
    ;

every_pattern_source_chain
    : '('every_pattern_source_chain')' within_time? 
    | K_EVERY '('pattern_source_chain ')' within_time?   
    | every_pattern_source_chain  '->' every_pattern_source_chain
    | pattern_source_chain
    | K_EVERY pattern_source within_time? 
    ;

pattern_source_chain
    : '('pattern_source_chain')' within_time? 
    | pattern_source_chain  '->' pattern_source_chain
    | pattern_source within_time? 
    ;

pattern_source
    :logical_stateful_source|pattern_collection_stateful_source|standard_stateful_source
    ;

logical_stateful_source
    :K_NOT standard_stateful_source (K_AND standard_stateful_source) ?
    |standard_stateful_source K_AND standard_stateful_source
    |standard_stateful_source K_OR standard_stateful_source
    ;

pattern_collection_stateful_source
    :standard_stateful_source '<' collect '>'
    ;

standard_stateful_source
    : (event '=')? basic_source
    ;

basic_source
    : source (filter | stream_function)*
    ;

sequence_stream
    :K_EVERY? sequence_source_chain ',' sequence_source_chain
    ;

sequence_source_chain
    :'('sequence_source_chain ')' within_time? 
    | sequence_source_chain ',' sequence_source_chain
    | sequence_source  within_time? 
    ;

sequence_source
    :logical_stateful_source|sequence_collection_stateful_source|standard_stateful_source
    ;

sequence_collection_stateful_source
    :standard_stateful_source ('<' collect '>'|'*'|'?'|'+') 
    ;

filter
    :'#'? '['condition']'
    ;

stream_function
    :'#' function_operation
    ;

window
    :'#' K_WINDOW '.' function_operation
    ;

query_section
    :(K_SELECT ('*'| (output_attribute (',' output_attribute)* )))
    ;

query_output
    :K_INSERT output_event_type? K_INTO target
    |K_DELETE target (K_FOR output_event_type)? (K_ON condition)?
    |K_UPDATE target (K_FOR output_event_type)? (K_ON condition)?
    |K_RETURN
    ;

output_event_type
    : K_ALL K_EVENTS | K_ALL K_RAW K_EVENTS | K_EXPIRED K_EVENTS | K_EXPIRED K_RAW K_EVENTS | K_CURRENT? K_EVENTS   
    ;

output_rate
    : K_OUTPUT output_rate_type? K_EVERY ( time_value | NUMBER K_EVENTS )
    | K_OUTPUT K_SNAPSHOT K_EVERY time_value
    ;

output_rate_type
    : K_ALL
    | K_LAST
    | K_FIRST
    ;

within_time
    :K_WITHIN time_value
    ;

output_attribute
    :attribute K_AS attribute_name
    |attribute_reference
    ;

attribute
    :math_operation
    ;

condition
    :math_operation
    ;

math_operation
    :'('math_operation')'
    |K_NOT math_operation
    |math_operation ('*'|'/'|'%') math_operation
    |math_operation ('+'|'-') math_operation
    |math_operation ('>='|'<='|'>'|'<') math_operation
    |math_operation ('=='|'!=') math_operation
    |math_operation K_AND math_operation
    |math_operation K_OR math_operation  
    |function_operation
    |null_check
    |attribute_reference
    |constant_value
    ;

attribute_list
    :attribute (','attribute)*
    ;

function_operation
    : (function_namespace ':')? function_id '('attribute_list?')'
    ;

null_check
    :(id | attribute_reference) K_IS K_NULL
    ;

attribute_reference
    :'#'? id ('['attribute_index']')? ('#'id ('['attribute_index']')?)? '.'  attribute_name
    | attribute_name
    ;

attribute_index
    : NUMBER| K_LAST ('-' NUMBER)?| K_PREVIOUS ('-' NUMBER)?
    ;

function_id
    :id
    ;

function_namespace
    :id
    ;

stream_id
    :id
    ;

stream_alias
    :id
    ;

property_name
    : id ('.'id )*
    ;

attribute_name
    :id
    ;

property_value
    :string_value
    ;

source
    :'#'? stream_id
    ;

target
    :source
    ;

event
    :id
    ;

name
    :id
    ;

collect
    : NUMBER ':' NUMBER
    | NUMBER ':'
    | ':' NUMBER
    | NUMBER
    ;

type
    :K_STRING     #StringType
    |K_INT        #IntType
    |K_LONG       #LongType
    |K_FLOAT      #FloatType
    |K_DOUBLE     #DoubleType
    |K_BOOL       #BoolType
    |K_OBJECT     #ObjectType
    ;

join
    : K_LEFT K_OUTER K_JOIN
    | K_RIGHT K_OUTER K_JOIN
    | K_FULL K_OUTER K_JOIN
    | K_OUTER K_JOIN
    | K_INNER? K_JOIN
    ;


constant_value
    :bool_value
    |signed_double_value
    |signed_float_value
    |signed_long_value
    |signed_int_value
    |time_value
    |string_value
    ;

id: IDENTIFIER ;

time_value
    :  year_value  ( month_value)? ( week_value)? ( day_value)? ( hour_value)? ( minute_value)? ( second_value)?  ( millisecond_value)?
    |  month_value ( week_value)? ( day_value)? ( hour_value)? ( minute_value)? ( second_value)?  ( millisecond_value)?
    |  week_value ( day_value)? ( hour_value)? ( minute_value)? ( second_value)?  ( millisecond_value)?
    |  day_value ( hour_value)? ( minute_value)? ( second_value)?  ( millisecond_value)?
    |  hour_value ( minute_value)? ( second_value)?  ( millisecond_value)?       
    |  minute_value ( second_value)?  ( millisecond_value)?
    |  second_value ( millisecond_value)?
    |  millisecond_value
    ;

year_value 
    : NUMBER K_YEAR
    ;

month_value
    : NUMBER K_MONTH
    ;

week_value
    : NUMBER K_WEEK
    ;

day_value
    : NUMBER K_DAY
    ;

hour_value
    : NUMBER K_HOUR
    ;

minute_value
    : NUMBER K_MINUTE
    ;

second_value
    : NUMBER K_SECOND
    ;

millisecond_value
    : NUMBER K_MILLISECOND
    ;

signed_double_value: (negative='-' |'+')? DOUBLE_LITERAL;
signed_long_value: (negative='-' |'+')? LONG_LITERAL;
signed_float_value: (negative='-' |'+')? FLOAT_LITERAL;
signed_int_value: (negative='-' |'+')? (INT_LITERAL|NUMBER);
bool_value: K_TRUE|K_FALSE;
string_value: STRING_LITERAL;

NUMBER : DIGIT+;

INT_LITERAL
    : DIGIT+ I?
    ;

LONG_LITERAL
    : DIGIT+ L
    ; 

FLOAT_LITERAL
    : DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )? F
    | (DIGIT+)? '.' DIGIT+ ( E [-+]? DIGIT+ )? F
    ; 

DOUBLE_LITERAL
    : DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )? D
    | DIGIT+ ( '.' DIGIT* )?  E [-+]? DIGIT+  D?
    | (DIGIT+)? '.' DIGIT+ ( E [-+]? DIGIT+ )? D?
    ; 

/*
ID_QUOTES : '`'('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*'`' {setText(getText().substring(1, getText().length()-1));};

ID_NO_QUOTES : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;


STRING_VAL
    :('\'' ( ~('\u0000'..'\u001f' | '\\' | '\''| '\"' ) )* '\'' 
    |'"' ( ~('\u0000'..'\u001f' | '\\'  |'\"') )* '"' )         {setText(getText().substring(1, getText().length()-1));}
    ;

*/

COL : ':';
SCOL : ';';
DOT : '.';
OPEN_PAR : '(';
CLOSE_PAR : ')';
OPEN_SQARE_BRACKETS : '[';
CLOASE_SQARE_BRACKETS : ']';
COMMA : ',';
ASSIGN : '=';
STAR : '*';
PLUS : '+';
QUESTION: '?';
MINUS : '-';
DIV : '/';
MOD : '%';
LT : '<';
LT_EQ : '<=';
GT : '>';
GT_EQ : '>=';
EQ : '==';
NOT_EQ : '!=';
AT: '@';
FOLLOWED_BY:'->';
HASH:'#';

K_STREAM:   S T R E A M;
K_DEFINE:   D E F I N E;
K_TABLE:    T A B L E;
K_FROM:     F R O M;
K_PARTITION:    P A R T I T I O N; 
K_WINDOW:   W I N D O W;
K_SELECT:   S E L E C T;
K_INSERT:   I N S E R T;
K_DELETE:   D E L E T E;
K_UPDATE:   U P D A T E;
K_RETURN:   R E T U R N;
K_EVENTS:   E V E N T S;
K_INTO:     I N T O;
K_OUTPUT:   O U T P U T;
K_EXPIRED:  E X P I R E D;
K_CURRENT:  C U R R E N T;
K_SNAPSHOT: S N A P S H O T;
K_FOR:      F O R;
K_RAW:      R A W;
K_OF:       O F;
K_AS:       A S;
K_OR:       O R;
K_AND:      A N D;
K_ON:       O N;
K_IS:       I S;
K_NOT:      N O T;
K_WITHIN:   W I T H I N;
K_WITH:     W I T H; 
K_BEGIN:    B E G I N;
K_END:      E N D;
K_NULL:     N U L L;
K_EVERY:    E V E R Y;
K_LAST:     L A S T;
K_ALL:      A L L;
K_FIRST:    F I R S T;
K_PREVIOUS: P R E V (I O U S)?;
K_JOIN:     J O I N;
K_INNER:    I N N E R;
K_OUTER:    O U T E R;
K_RIGHT:    R I G H T;
K_LEFT:     L E F T;
K_FULL:     F U L L;
K_UNIDIRECTIONAL: U N I D I R E C T I O N A L;
K_YEAR:     Y E A R S?;
K_MONTH:    M O N T H S?;
K_WEEK:     W E E K S?;
K_DAY:      D A Y S?;
K_HOUR:     H O U R S?;
K_MINUTE:   M I N (U T E S?)?;
K_SECOND:  S E C (O N D S?)?;
K_MILLISECOND: M I L L I S E C (O N D S?)?;
K_FALSE:    F A L S E;
K_TRUE:     T R U E;
K_STRING:   S T R I N G;
K_INT:  I N T;
K_LONG:     L O N G;
K_FLOAT:    F L O A T;
K_DOUBLE:   D O U B L E;
K_BOOL:     B O O L;
K_OBJECT:   O B J E C T;

IDENTIFIER
 : ID_QUOTES|ID
 ;

ID_QUOTES : '`'[a-zA-Z_] [a-zA-Z_0-9]*'`' {setText(getText().substring(1, getText().length()-1));};

ID : [a-zA-Z_] [a-zA-Z_0-9]* ;

STRING_LITERAL
    :(
        '\'' ( ~('\u0000'..'\u001f' | '\''| '\"' ) )* '\'' 
        |'"' ( ~('\u0000'..'\u001f'  |'\"') )* '"' 
     )  {setText(getText().substring(1, getText().length()-1));}         
    ;	

//Hidden channels
SINGLE_LINE_COMMENT
 : '--' ~[\r\n]* -> channel(HIDDEN)
 ;

MULTILINE_COMMENT
 : '/*' .*? ( '*/' | EOF ) -> channel(HIDDEN)
 ;

SPACES
 : [ \u000B\t\r\n] -> channel(HIDDEN)
 ;

UNEXPECTED_CHAR
 : .
 ;

fragment DIGIT : [0-9];

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

