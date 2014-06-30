// $ANTLR 3.4 org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g 2014-06-30 09:22:22

	package org.wso2.siddhi.query.compiler;

    import org.wso2.siddhi.query.api.ExecutionPlan;
    import org.wso2.siddhi.query.api.QueryFactory;
    import org.wso2.siddhi.query.api.condition.Condition;
    import org.wso2.siddhi.query.api.condition.ConditionExtension;
    import org.wso2.siddhi.query.api.condition.FunctionCondition;
    import org.wso2.siddhi.query.api.definition.Attribute;
    import org.wso2.siddhi.query.api.definition.StreamDefinition;
    import org.wso2.siddhi.query.api.definition.TableDefinition;
    import org.wso2.siddhi.query.api.definition.partition.PartitionDefinition;
    import org.wso2.siddhi.query.api.definition.partition.PartitionType;
    import org.wso2.siddhi.query.api.definition.partition.RangePartitionType;
    import org.wso2.siddhi.query.api.definition.partition.VariablePartitionType;
    import org.wso2.siddhi.query.api.expression.Expression;
    import org.wso2.siddhi.query.api.expression.ExpressionExtension;
    import org.wso2.siddhi.query.api.expression.FunctionExpression;
    import org.wso2.siddhi.query.api.expression.Time;
    import org.wso2.siddhi.query.api.expression.Variable;
    import org.wso2.siddhi.query.api.expression.constant.Constant;
    import org.wso2.siddhi.query.api.extension.Extension;
    import org.wso2.siddhi.query.api.query.Query;
    import org.wso2.siddhi.query.api.query.input.BasicStream;
    import org.wso2.siddhi.query.api.query.input.JoinStream;
    import org.wso2.siddhi.query.api.query.input.SingleStream;
    import org.wso2.siddhi.query.api.query.input.Stream;
    import org.wso2.siddhi.query.api.query.input.handler.Filter;
    import org.wso2.siddhi.query.api.query.input.handler.TransformExtension;
    import org.wso2.siddhi.query.api.query.input.handler.Transformer;
    import org.wso2.siddhi.query.api.query.input.handler.Window;
    import org.wso2.siddhi.query.api.query.input.handler.WindowExtension;
    import org.wso2.siddhi.query.api.query.input.pattern.Pattern;
    import org.wso2.siddhi.query.api.query.input.pattern.PatternStream;
    import org.wso2.siddhi.query.api.query.input.pattern.element.LogicalElement;
    import org.wso2.siddhi.query.api.query.input.pattern.element.PatternElement;
    import org.wso2.siddhi.query.api.query.input.sequence.Sequence;
    import org.wso2.siddhi.query.api.query.input.sequence.SequenceStream;
    import org.wso2.siddhi.query.api.query.input.sequence.element.SequenceElement;
    import org.wso2.siddhi.query.api.query.output.EventOutputRate;
    import org.wso2.siddhi.query.api.query.output.Output;
    import org.wso2.siddhi.query.api.query.output.OutputRate;
    import org.wso2.siddhi.query.api.query.output.SnapshotOutputRate;
    import org.wso2.siddhi.query.api.query.output.TimeOutputRate;
    import org.wso2.siddhi.query.api.query.output.stream.DeleteStream;
    import org.wso2.siddhi.query.api.query.output.stream.InsertIntoStream;
    import org.wso2.siddhi.query.api.query.output.stream.OutStream;
    import org.wso2.siddhi.query.api.query.output.stream.UpdateStream;
    import org.wso2.siddhi.query.api.query.selection.Selector;
    import org.wso2.siddhi.query.api.query.selection.attribute.ComplexAttribute;
    import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttribute;
    import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttributeExtension;
    import org.wso2.siddhi.query.api.query.selection.attribute.SimpleAttribute;
    import org.wso2.siddhi.query.api.utils.SiddhiConstants;



import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SiddhiQLGrammarWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ANONYMOUS", "ATTRIBUTE", "BOOL_VAL", "COLLECT", "COMMENT", "CONDITION", "CONDITION_FUNCTION", "CONSTANT", "DAY", "DELETE_STREAM", "EXTENSION", "EXTENSION_FUNCTION", "FILTER", "FOLLOWED_BY", "FUNCTION", "HANDLERS", "HOUR", "ID", "ID_QUOTES", "INSERT_INTO_STREAM", "IN_ATTRIBUTE", "JOIN", "LAST", "LINE_COMMENT", "MILLI_SEC", "MIN", "MONTH", "NUM", "NUM_SCI", "OUTPUT", "OUT_ATTRIBUTE", "OUT_ATTRIBUTES", "OUT_STREAM", "PARAMETERS", "PARTITION", "PARTITION_DEFINITION", "PARTITION_TYPE", "PATTERN", "PATTERN_FULL", "POSITIVE_DOUBLE_VAL", "POSITIVE_FLOAT_VAL", "POSITIVE_INT_VAL", "POSITIVE_LONG_VAL", "QUERY", "REGEX", "RETURN_QUERY", "SEC", "SEQUENCE", "SEQUENCE_FULL", "SIGNED_VAL", "SNAPSHOT", "STREAM", "STREAM_DEFINITION", "STRING_VAL", "TABLE", "TABLE_DEFINITION", "TABLE_PARAMETER", "TIME_EXP", "TRANSFORM", "UPDATE_STREAM", "WEEK", "WINDOW", "WS", "YEAR", "'!='", "'#'", "'%'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'?'", "'['", "']'", "'all'", "'all-events'", "'and'", "'as'", "'bool'", "'by'", "'contains'", "'current-events'", "'define'", "'delete'", "'double'", "'events'", "'every'", "'expired-events'", "'first'", "'float'", "'for'", "'from'", "'full'", "'group'", "'having'", "'in'", "'inner'", "'insert'", "'instanceof'", "'int'", "'into'", "'join'", "'last'", "'left'", "'long'", "'not'", "'on'", "'or'", "'outer'", "'output'", "'partition'", "'range'", "'return'", "'right'", "'select'", "'snapshot'", "'stream'", "'string'", "'table'", "'transform'", "'unidirectional'", "'update'", "'window'", "'within'"
    };

    public static final int EOF=-1;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__110=110;
    public static final int T__111=111;
    public static final int T__112=112;
    public static final int T__113=113;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__120=120;
    public static final int T__121=121;
    public static final int T__122=122;
    public static final int T__123=123;
    public static final int T__124=124;
    public static final int T__125=125;
    public static final int T__126=126;
    public static final int T__127=127;
    public static final int T__128=128;
    public static final int T__129=129;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__134=134;
    public static final int T__135=135;
    public static final int T__136=136;
    public static final int T__137=137;
    public static final int T__138=138;
    public static final int T__139=139;
    public static final int ANONYMOUS=4;
    public static final int ATTRIBUTE=5;
    public static final int BOOL_VAL=6;
    public static final int COLLECT=7;
    public static final int COMMENT=8;
    public static final int CONDITION=9;
    public static final int CONDITION_FUNCTION=10;
    public static final int CONSTANT=11;
    public static final int DAY=12;
    public static final int DELETE_STREAM=13;
    public static final int EXTENSION=14;
    public static final int EXTENSION_FUNCTION=15;
    public static final int FILTER=16;
    public static final int FOLLOWED_BY=17;
    public static final int FUNCTION=18;
    public static final int HANDLERS=19;
    public static final int HOUR=20;
    public static final int ID=21;
    public static final int ID_QUOTES=22;
    public static final int INSERT_INTO_STREAM=23;
    public static final int IN_ATTRIBUTE=24;
    public static final int JOIN=25;
    public static final int LAST=26;
    public static final int LINE_COMMENT=27;
    public static final int MILLI_SEC=28;
    public static final int MIN=29;
    public static final int MONTH=30;
    public static final int NUM=31;
    public static final int NUM_SCI=32;
    public static final int OUTPUT=33;
    public static final int OUT_ATTRIBUTE=34;
    public static final int OUT_ATTRIBUTES=35;
    public static final int OUT_STREAM=36;
    public static final int PARAMETERS=37;
    public static final int PARTITION=38;
    public static final int PARTITION_DEFINITION=39;
    public static final int PARTITION_TYPE=40;
    public static final int PATTERN=41;
    public static final int PATTERN_FULL=42;
    public static final int POSITIVE_DOUBLE_VAL=43;
    public static final int POSITIVE_FLOAT_VAL=44;
    public static final int POSITIVE_INT_VAL=45;
    public static final int POSITIVE_LONG_VAL=46;
    public static final int QUERY=47;
    public static final int REGEX=48;
    public static final int RETURN_QUERY=49;
    public static final int SEC=50;
    public static final int SEQUENCE=51;
    public static final int SEQUENCE_FULL=52;
    public static final int SIGNED_VAL=53;
    public static final int SNAPSHOT=54;
    public static final int STREAM=55;
    public static final int STREAM_DEFINITION=56;
    public static final int STRING_VAL=57;
    public static final int TABLE=58;
    public static final int TABLE_DEFINITION=59;
    public static final int TABLE_PARAMETER=60;
    public static final int TIME_EXP=61;
    public static final int TRANSFORM=62;
    public static final int UPDATE_STREAM=63;
    public static final int WEEK=64;
    public static final int WINDOW=65;
    public static final int WS=66;
    public static final int YEAR=67;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public SiddhiQLGrammarWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public SiddhiQLGrammarWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SiddhiQLGrammarWalker.tokenNames; }
    public String getGrammarFileName() { return "org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g"; }



    // $ANTLR start "executionPlan"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:66:1: executionPlan returns [List<ExecutionPlan> executionPlanList] : ( ^( PARTITION_DEFINITION definitionPartition ) )* ( ^( STREAM_DEFINITION definitionStream ) )* ( ^( TABLE_DEFINITION definitionTable ) )* ( query )* ;
    public final List<ExecutionPlan> executionPlan() throws RecognitionException {
        List<ExecutionPlan> executionPlanList = null;


        PartitionDefinition definitionPartition1 =null;

        StreamDefinition definitionStream2 =null;

        TableDefinition definitionTable3 =null;

        Query query4 =null;



                executionPlanList =new ArrayList<ExecutionPlan>();
            
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:70:2: ( ( ^( PARTITION_DEFINITION definitionPartition ) )* ( ^( STREAM_DEFINITION definitionStream ) )* ( ^( TABLE_DEFINITION definitionTable ) )* ( query )* )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:70:4: ( ^( PARTITION_DEFINITION definitionPartition ) )* ( ^( STREAM_DEFINITION definitionStream ) )* ( ^( TABLE_DEFINITION definitionTable ) )* ( query )*
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:70:4: ( ^( PARTITION_DEFINITION definitionPartition ) )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case PARTITION_DEFINITION:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:70:5: ^( PARTITION_DEFINITION definitionPartition )
            	    {
            	    match(input,PARTITION_DEFINITION,FOLLOW_PARTITION_DEFINITION_in_executionPlan67); if (state.failed) return executionPlanList;

            	    match(input, Token.DOWN, null); if (state.failed) return executionPlanList;
            	    pushFollow(FOLLOW_definitionPartition_in_executionPlan69);
            	    definitionPartition1=definitionPartition();

            	    state._fsp--;
            	    if (state.failed) return executionPlanList;

            	    if ( state.backtracking==0 ) {executionPlanList.add(definitionPartition1);}

            	    match(input, Token.UP, null); if (state.failed) return executionPlanList;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:71:4: ( ^( STREAM_DEFINITION definitionStream ) )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case STREAM_DEFINITION:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:71:5: ^( STREAM_DEFINITION definitionStream )
            	    {
            	    match(input,STREAM_DEFINITION,FOLLOW_STREAM_DEFINITION_in_executionPlan81); if (state.failed) return executionPlanList;

            	    match(input, Token.DOWN, null); if (state.failed) return executionPlanList;
            	    pushFollow(FOLLOW_definitionStream_in_executionPlan83);
            	    definitionStream2=definitionStream();

            	    state._fsp--;
            	    if (state.failed) return executionPlanList;

            	    if ( state.backtracking==0 ) {executionPlanList.add(definitionStream2);}

            	    match(input, Token.UP, null); if (state.failed) return executionPlanList;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:72:4: ( ^( TABLE_DEFINITION definitionTable ) )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case TABLE_DEFINITION:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:72:5: ^( TABLE_DEFINITION definitionTable )
            	    {
            	    match(input,TABLE_DEFINITION,FOLLOW_TABLE_DEFINITION_in_executionPlan95); if (state.failed) return executionPlanList;

            	    match(input, Token.DOWN, null); if (state.failed) return executionPlanList;
            	    pushFollow(FOLLOW_definitionTable_in_executionPlan97);
            	    definitionTable3=definitionTable();

            	    state._fsp--;
            	    if (state.failed) return executionPlanList;

            	    if ( state.backtracking==0 ) {executionPlanList.add(definitionTable3);}

            	    match(input, Token.UP, null); if (state.failed) return executionPlanList;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:73:4: ( query )*
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case QUERY:
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:73:5: query
            	    {
            	    pushFollow(FOLLOW_query_in_executionPlan108);
            	    query4=query();

            	    state._fsp--;
            	    if (state.failed) return executionPlanList;

            	    if ( state.backtracking==0 ) {executionPlanList.add(query4);}

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return executionPlanList;
    }
    // $ANTLR end "executionPlan"



    // $ANTLR start "definitionStreamFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:76:1: definitionStreamFinal returns [StreamDefinition definitionStreamFinal ] : definitionStream ;
    public final StreamDefinition definitionStreamFinal() throws RecognitionException {
        StreamDefinition definitionStreamFinal = null;


        StreamDefinition definitionStream5 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:77:5: ( definitionStream )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:77:7: definitionStream
            {
            pushFollow(FOLLOW_definitionStream_in_definitionStreamFinal131);
            definitionStream5=definitionStream();

            state._fsp--;
            if (state.failed) return definitionStreamFinal;

            if ( state.backtracking==0 ) {definitionStreamFinal =definitionStream5;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return definitionStreamFinal;
    }
    // $ANTLR end "definitionStreamFinal"



    // $ANTLR start "definitionStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:80:1: definitionStream returns [StreamDefinition streamDefinition] : ^( streamId ( ^( IN_ATTRIBUTE attributeName type ) )+ ) ;
    public final StreamDefinition definitionStream() throws RecognitionException {
        StreamDefinition streamDefinition = null;


        String streamId6 =null;

        String attributeName7 =null;

        Attribute.Type type8 =null;



                streamDefinition = QueryFactory.createStreamDefinition();
            
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:84:2: ( ^( streamId ( ^( IN_ATTRIBUTE attributeName type ) )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:84:5: ^( streamId ( ^( IN_ATTRIBUTE attributeName type ) )+ )
            {
            pushFollow(FOLLOW_streamId_in_definitionStream159);
            streamId6=streamId();

            state._fsp--;
            if (state.failed) return streamDefinition;

            if ( state.backtracking==0 ) {streamDefinition.name(streamId6);}

            match(input, Token.DOWN, null); if (state.failed) return streamDefinition;
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:84:59: ( ^( IN_ATTRIBUTE attributeName type ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case IN_ATTRIBUTE:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:84:60: ^( IN_ATTRIBUTE attributeName type )
            	    {
            	    match(input,IN_ATTRIBUTE,FOLLOW_IN_ATTRIBUTE_in_definitionStream165); if (state.failed) return streamDefinition;

            	    match(input, Token.DOWN, null); if (state.failed) return streamDefinition;
            	    pushFollow(FOLLOW_attributeName_in_definitionStream167);
            	    attributeName7=attributeName();

            	    state._fsp--;
            	    if (state.failed) return streamDefinition;

            	    pushFollow(FOLLOW_type_in_definitionStream169);
            	    type8=type();

            	    state._fsp--;
            	    if (state.failed) return streamDefinition;

            	    if ( state.backtracking==0 ) {streamDefinition.attribute(attributeName7, type8);}

            	    match(input, Token.UP, null); if (state.failed) return streamDefinition;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return streamDefinition;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return streamDefinition;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return streamDefinition;
    }
    // $ANTLR end "definitionStream"



    // $ANTLR start "definitionPartitionFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:88:1: definitionPartitionFinal returns [PartitionDefinition partitionDefinitionFinal] : definitionPartition ;
    public final PartitionDefinition definitionPartitionFinal() throws RecognitionException {
        PartitionDefinition partitionDefinitionFinal = null;


        PartitionDefinition definitionPartition9 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:89:2: ( definitionPartition )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:89:4: definitionPartition
            {
            pushFollow(FOLLOW_definitionPartition_in_definitionPartitionFinal191);
            definitionPartition9=definitionPartition();

            state._fsp--;
            if (state.failed) return partitionDefinitionFinal;

            if ( state.backtracking==0 ) {partitionDefinitionFinal =definitionPartition9;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return partitionDefinitionFinal;
    }
    // $ANTLR end "definitionPartitionFinal"



    // $ANTLR start "definitionPartition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:92:1: definitionPartition returns [PartitionDefinition partitionDefinition] : ^( partitionId ( ^( PARTITION_TYPE partitionType ) )+ ) ;
    public final PartitionDefinition definitionPartition() throws RecognitionException {
        PartitionDefinition partitionDefinition = null;


        String partitionId10 =null;

        PartitionType partitionType11 =null;



        		partitionDefinition = QueryFactory.createPartitionDefinition();
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:96:2: ( ^( partitionId ( ^( PARTITION_TYPE partitionType ) )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:96:4: ^( partitionId ( ^( PARTITION_TYPE partitionType ) )+ )
            {
            pushFollow(FOLLOW_partitionId_in_definitionPartition214);
            partitionId10=partitionId();

            state._fsp--;
            if (state.failed) return partitionDefinition;

            if ( state.backtracking==0 ) {partitionDefinition.name(partitionId10);}

            match(input, Token.DOWN, null); if (state.failed) return partitionDefinition;
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:96:67: ( ^( PARTITION_TYPE partitionType ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case PARTITION_TYPE:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:96:68: ^( PARTITION_TYPE partitionType )
            	    {
            	    match(input,PARTITION_TYPE,FOLLOW_PARTITION_TYPE_in_definitionPartition220); if (state.failed) return partitionDefinition;

            	    match(input, Token.DOWN, null); if (state.failed) return partitionDefinition;
            	    pushFollow(FOLLOW_partitionType_in_definitionPartition222);
            	    partitionType11=partitionType();

            	    state._fsp--;
            	    if (state.failed) return partitionDefinition;

            	    if ( state.backtracking==0 ) {partitionDefinition.addPartitionType(partitionType11);}

            	    match(input, Token.UP, null); if (state.failed) return partitionDefinition;


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return partitionDefinition;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return partitionDefinition;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return partitionDefinition;
    }
    // $ANTLR end "definitionPartition"



    // $ANTLR start "partitionType"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:99:1: partitionType returns [PartitionType partitionType] : ( streamAttributeName | attributeName | condition stringVal );
    public final PartitionType partitionType() throws RecognitionException {
        PartitionType partitionType = null;


        SiddhiQLGrammarWalker.streamAttributeName_return streamAttributeName12 =null;

        String attributeName13 =null;

        Condition condition14 =null;

        String stringVal15 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:100:5: ( streamAttributeName | attributeName | condition stringVal )
            int alt7=3;
            switch ( input.LA(1) ) {
            case ATTRIBUTE:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case ID:
                        {
                        switch ( input.LA(4) ) {
                        case ID:
                        case ID_QUOTES:
                            {
                            alt7=1;
                            }
                            break;
                        case UP:
                            {
                            alt7=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return partitionType;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 4, input);

                            throw nvae;

                        }

                        }
                        break;
                    case ID_QUOTES:
                        {
                        switch ( input.LA(4) ) {
                        case ID:
                        case ID_QUOTES:
                            {
                            alt7=1;
                            }
                            break;
                        case UP:
                            {
                            alt7=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return partitionType;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 5, input);

                            throw nvae;

                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return partitionType;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return partitionType;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }

                }
                break;
            case CONDITION:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return partitionType;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:100:7: streamAttributeName
                    {
                    pushFollow(FOLLOW_streamAttributeName_in_partitionType247);
                    streamAttributeName12=streamAttributeName();

                    state._fsp--;
                    if (state.failed) return partitionType;

                    if ( state.backtracking==0 ) {partitionType =new VariablePartitionType(Expression.variable((streamAttributeName12!=null?streamAttributeName12.stream:null),(streamAttributeName12!=null?streamAttributeName12.attribute:null)));}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:101:7: attributeName
                    {
                    pushFollow(FOLLOW_attributeName_in_partitionType257);
                    attributeName13=attributeName();

                    state._fsp--;
                    if (state.failed) return partitionType;

                    if ( state.backtracking==0 ) {partitionType =new VariablePartitionType(Expression.variable(attributeName13));}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:102:7: condition stringVal
                    {
                    pushFollow(FOLLOW_condition_in_partitionType267);
                    condition14=condition();

                    state._fsp--;
                    if (state.failed) return partitionType;

                    pushFollow(FOLLOW_stringVal_in_partitionType269);
                    stringVal15=stringVal();

                    state._fsp--;
                    if (state.failed) return partitionType;

                    if ( state.backtracking==0 ) {partitionType =new RangePartitionType(condition14,stringVal15);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return partitionType;
    }
    // $ANTLR end "partitionType"



    // $ANTLR start "definitionTableFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:105:1: definitionTableFinal returns [TableDefinition tableDefinitionFinal] : definitionTable ;
    public final TableDefinition definitionTableFinal() throws RecognitionException {
        TableDefinition tableDefinitionFinal = null;


        TableDefinition definitionTable16 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:106:5: ( definitionTable )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:106:7: definitionTable
            {
            pushFollow(FOLLOW_definitionTable_in_definitionTableFinal292);
            definitionTable16=definitionTable();

            state._fsp--;
            if (state.failed) return tableDefinitionFinal;

            if ( state.backtracking==0 ) {tableDefinitionFinal =definitionTable16;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return tableDefinitionFinal;
    }
    // $ANTLR end "definitionTableFinal"



    // $ANTLR start "definitionTable"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:109:1: definitionTable returns [TableDefinition tableDefinition] : ^( id ( ^( IN_ATTRIBUTE attributeName type ) )+ ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )? ) ;
    public final TableDefinition definitionTable() throws RecognitionException {
        TableDefinition tableDefinition = null;


        String id17 =null;

        String attributeName18 =null;

        Attribute.Type type19 =null;

        String tableParamName20 =null;

        String tableParamValue21 =null;



                tableDefinition = QueryFactory.createTableDefinition();
            
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:2: ( ^( id ( ^( IN_ATTRIBUTE attributeName type ) )+ ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:5: ^( id ( ^( IN_ATTRIBUTE attributeName type ) )+ ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )? )
            {
            pushFollow(FOLLOW_id_in_definitionTable322);
            id17=id();

            state._fsp--;
            if (state.failed) return tableDefinition;

            if ( state.backtracking==0 ) {tableDefinition.name(id17);}

            match(input, Token.DOWN, null); if (state.failed) return tableDefinition;
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:47: ( ^( IN_ATTRIBUTE attributeName type ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case IN_ATTRIBUTE:
                    {
                    alt8=1;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:48: ^( IN_ATTRIBUTE attributeName type )
            	    {
            	    match(input,IN_ATTRIBUTE,FOLLOW_IN_ATTRIBUTE_in_definitionTable329); if (state.failed) return tableDefinition;

            	    match(input, Token.DOWN, null); if (state.failed) return tableDefinition;
            	    pushFollow(FOLLOW_attributeName_in_definitionTable331);
            	    attributeName18=attributeName();

            	    state._fsp--;
            	    if (state.failed) return tableDefinition;

            	    pushFollow(FOLLOW_type_in_definitionTable333);
            	    type19=type();

            	    state._fsp--;
            	    if (state.failed) return tableDefinition;

            	    if ( state.backtracking==0 ) {tableDefinition.attribute(attributeName18, type19);}

            	    match(input, Token.UP, null); if (state.failed) return tableDefinition;


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return tableDefinition;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:150: ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )?
            int alt10=2;
            switch ( input.LA(1) ) {
                case TABLE:
                    {
                    alt10=1;
                    }
                    break;
            }

            switch (alt10) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:151: ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ )
                    {
                    match(input,TABLE,FOLLOW_TABLE_in_definitionTable343); if (state.failed) return tableDefinition;

                    match(input, Token.DOWN, null); if (state.failed) return tableDefinition;
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:160: ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        switch ( input.LA(1) ) {
                        case TABLE_PARAMETER:
                            {
                            alt9=1;
                            }
                            break;

                        }

                        switch (alt9) {
                    	case 1 :
                    	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:113:161: ^( TABLE_PARAMETER tableParamName tableParamValue )
                    	    {
                    	    match(input,TABLE_PARAMETER,FOLLOW_TABLE_PARAMETER_in_definitionTable348); if (state.failed) return tableDefinition;

                    	    match(input, Token.DOWN, null); if (state.failed) return tableDefinition;
                    	    pushFollow(FOLLOW_tableParamName_in_definitionTable350);
                    	    tableParamName20=tableParamName();

                    	    state._fsp--;
                    	    if (state.failed) return tableDefinition;

                    	    pushFollow(FOLLOW_tableParamValue_in_definitionTable352);
                    	    tableParamValue21=tableParamValue();

                    	    state._fsp--;
                    	    if (state.failed) return tableDefinition;

                    	    if ( state.backtracking==0 ) {tableDefinition.from(tableParamName20, tableParamValue21);}

                    	    match(input, Token.UP, null); if (state.failed) return tableDefinition;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return tableDefinition;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return tableDefinition;


                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return tableDefinition;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return tableDefinition;
    }
    // $ANTLR end "definitionTable"



    // $ANTLR start "queryFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:116:1: queryFinal returns [Query queryFinal] : query ;
    public final Query queryFinal() throws RecognitionException {
        Query queryFinal = null;


        Query query22 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:117:5: ( query )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:117:7: query
            {
            pushFollow(FOLLOW_query_in_queryFinal380);
            query22=query();

            state._fsp--;
            if (state.failed) return queryFinal;

            if ( state.backtracking==0 ) {queryFinal =query22;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return queryFinal;
    }
    // $ANTLR end "queryFinal"



    // $ANTLR start "query"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:120:1: query returns [Query query] : ( ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? ) | ^( QUERY inputStream outputSelection ( output )? ( partition )? ) );
    public final Query query() throws RecognitionException {
        Query query = null;


        OutStream outputStream23 =null;

        Selector outputSelection24 =null;

        Stream inputStream25 =null;

        OutputRate output26 =null;

        String partition27 =null;

        Stream inputStream28 =null;

        Selector outputSelection29 =null;

        OutputRate output30 =null;

        String partition31 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:121:2: ( ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? ) | ^( QUERY inputStream outputSelection ( output )? ( partition )? ) )
            int alt15=2;
            switch ( input.LA(1) ) {
            case QUERY:
                {
                int LA15_1 = input.LA(2);

                if ( (synpred14_SiddhiQLGrammarWalker()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return query;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return query;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:121:4: ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? )
                    {
                    match(input,QUERY,FOLLOW_QUERY_in_query401); if (state.failed) return query;

                    match(input, Token.DOWN, null); if (state.failed) return query;
                    pushFollow(FOLLOW_inputStream_in_query403);
                    inputStream25=inputStream();

                    state._fsp--;
                    if (state.failed) return query;

                    pushFollow(FOLLOW_outputSelection_in_query405);
                    outputSelection24=outputSelection();

                    state._fsp--;
                    if (state.failed) return query;

                    pushFollow(FOLLOW_outputStream_in_query407);
                    outputStream23=outputStream();

                    state._fsp--;
                    if (state.failed) return query;

                    if ( state.backtracking==0 ) {query = QueryFactory.createQuery().outStream(outputStream23).select(outputSelection24).from(inputStream25);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:10: ( output )?
                    int alt11=2;
                    switch ( input.LA(1) ) {
                        case OUTPUT:
                            {
                            alt11=1;
                            }
                            break;
                    }

                    switch (alt11) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:11: output
                            {
                            pushFollow(FOLLOW_output_in_query422);
                            output26=output();

                            state._fsp--;
                            if (state.failed) return query;

                            if ( state.backtracking==0 ) {query.output(output26);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:57: ( partition )?
                    int alt12=2;
                    switch ( input.LA(1) ) {
                        case PARTITION:
                            {
                            alt12=1;
                            }
                            break;
                    }

                    switch (alt12) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:58: partition
                            {
                            pushFollow(FOLLOW_partition_in_query429);
                            partition27=partition();

                            state._fsp--;
                            if (state.failed) return query;

                            if ( state.backtracking==0 ) {query.partitionBy(partition27);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return query;


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:123:4: ^( QUERY inputStream outputSelection ( output )? ( partition )? )
                    {
                    match(input,QUERY,FOLLOW_QUERY_in_query440); if (state.failed) return query;

                    match(input, Token.DOWN, null); if (state.failed) return query;
                    pushFollow(FOLLOW_inputStream_in_query442);
                    inputStream28=inputStream();

                    state._fsp--;
                    if (state.failed) return query;

                    pushFollow(FOLLOW_outputSelection_in_query444);
                    outputSelection29=outputSelection();

                    state._fsp--;
                    if (state.failed) return query;

                    if ( state.backtracking==0 ) {query = QueryFactory.createQuery().from(inputStream28).select(outputSelection29);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:124:10: ( output )?
                    int alt13=2;
                    switch ( input.LA(1) ) {
                        case OUTPUT:
                            {
                            alt13=1;
                            }
                            break;
                    }

                    switch (alt13) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:124:11: output
                            {
                            pushFollow(FOLLOW_output_in_query458);
                            output30=output();

                            state._fsp--;
                            if (state.failed) return query;

                            if ( state.backtracking==0 ) {query.output(output30);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:124:57: ( partition )?
                    int alt14=2;
                    switch ( input.LA(1) ) {
                        case PARTITION:
                            {
                            alt14=1;
                            }
                            break;
                    }

                    switch (alt14) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:124:58: partition
                            {
                            pushFollow(FOLLOW_partition_in_query465);
                            partition31=partition();

                            state._fsp--;
                            if (state.failed) return query;

                            if ( state.backtracking==0 ) {query.partitionBy(partition31);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return query;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return query;
    }
    // $ANTLR end "query"



    // $ANTLR start "outputStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:127:1: outputStream returns [OutStream value] : ( ^( INSERT_INTO_STREAM streamId ( outputTypeCondition )? ) | ^( DELETE_STREAM streamId ( outputTypeCondition )? ( condition )? ) | ^( UPDATE_STREAM streamId ( outputTypeCondition )? ( condition )? ) );
    public final OutStream outputStream() throws RecognitionException {
        OutStream value = null;


        String streamId32 =null;

        OutStream.OutputEventsFor outputTypeCondition33 =null;

        String streamId34 =null;

        OutStream.OutputEventsFor outputTypeCondition35 =null;

        Condition condition36 =null;

        String streamId37 =null;

        OutStream.OutputEventsFor outputTypeCondition38 =null;

        Condition condition39 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:128:2: ( ^( INSERT_INTO_STREAM streamId ( outputTypeCondition )? ) | ^( DELETE_STREAM streamId ( outputTypeCondition )? ( condition )? ) | ^( UPDATE_STREAM streamId ( outputTypeCondition )? ( condition )? ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case INSERT_INTO_STREAM:
                {
                alt21=1;
                }
                break;
            case DELETE_STREAM:
                {
                alt21=2;
                }
                break;
            case UPDATE_STREAM:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:128:5: ^( INSERT_INTO_STREAM streamId ( outputTypeCondition )? )
                    {
                    match(input,INSERT_INTO_STREAM,FOLLOW_INSERT_INTO_STREAM_in_outputStream487); if (state.failed) return value;

                    match(input, Token.DOWN, null); if (state.failed) return value;
                    pushFollow(FOLLOW_streamId_in_outputStream489);
                    streamId32=streamId();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =new InsertIntoStream(streamId32);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:128:83: ( outputTypeCondition )?
                    int alt16=2;
                    switch ( input.LA(1) ) {
                        case 91:
                        case 97:
                        case 103:
                            {
                            alt16=1;
                            }
                            break;
                    }

                    switch (alt16) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:128:84: outputTypeCondition
                            {
                            pushFollow(FOLLOW_outputTypeCondition_in_outputStream494);
                            outputTypeCondition33=outputTypeCondition();

                            state._fsp--;
                            if (state.failed) return value;

                            if ( state.backtracking==0 ) {value =new InsertIntoStream(streamId32,outputTypeCondition33);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return value;


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:129:5: ^( DELETE_STREAM streamId ( outputTypeCondition )? ( condition )? )
                    {
                    match(input,DELETE_STREAM,FOLLOW_DELETE_STREAM_in_outputStream506); if (state.failed) return value;

                    match(input, Token.DOWN, null); if (state.failed) return value;
                    pushFollow(FOLLOW_streamId_in_outputStream508);
                    streamId34=streamId();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =new DeleteStream(streamId34,null);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:129:79: ( outputTypeCondition )?
                    int alt17=2;
                    switch ( input.LA(1) ) {
                        case 91:
                        case 97:
                        case 103:
                            {
                            alt17=1;
                            }
                            break;
                    }

                    switch (alt17) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:129:80: outputTypeCondition
                            {
                            pushFollow(FOLLOW_outputTypeCondition_in_outputStream513);
                            outputTypeCondition35=outputTypeCondition();

                            state._fsp--;
                            if (state.failed) return value;

                            if ( state.backtracking==0 ) {value =new DeleteStream(streamId34,outputTypeCondition35,null);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:129:192: ( condition )?
                    int alt18=2;
                    switch ( input.LA(1) ) {
                        case CONDITION:
                            {
                            alt18=1;
                            }
                            break;
                    }

                    switch (alt18) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:129:193: condition
                            {
                            pushFollow(FOLLOW_condition_in_outputStream520);
                            condition36=condition();

                            state._fsp--;
                            if (state.failed) return value;

                            if ( state.backtracking==0 ) {((DeleteStream)value).setCondition(condition36);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return value;


                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:130:5: ^( UPDATE_STREAM streamId ( outputTypeCondition )? ( condition )? )
                    {
                    match(input,UPDATE_STREAM,FOLLOW_UPDATE_STREAM_in_outputStream532); if (state.failed) return value;

                    match(input, Token.DOWN, null); if (state.failed) return value;
                    pushFollow(FOLLOW_streamId_in_outputStream534);
                    streamId37=streamId();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =new UpdateStream(streamId37,null);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:130:79: ( outputTypeCondition )?
                    int alt19=2;
                    switch ( input.LA(1) ) {
                        case 91:
                        case 97:
                        case 103:
                            {
                            alt19=1;
                            }
                            break;
                    }

                    switch (alt19) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:130:80: outputTypeCondition
                            {
                            pushFollow(FOLLOW_outputTypeCondition_in_outputStream539);
                            outputTypeCondition38=outputTypeCondition();

                            state._fsp--;
                            if (state.failed) return value;

                            if ( state.backtracking==0 ) {value =new UpdateStream(streamId37,outputTypeCondition38,null);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:130:192: ( condition )?
                    int alt20=2;
                    switch ( input.LA(1) ) {
                        case CONDITION:
                            {
                            alt20=1;
                            }
                            break;
                    }

                    switch (alt20) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:130:193: condition
                            {
                            pushFollow(FOLLOW_condition_in_outputStream546);
                            condition39=condition();

                            state._fsp--;
                            if (state.failed) return value;

                            if ( state.backtracking==0 ) {((UpdateStream)value).setCondition(condition39);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return value;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "outputStream"



    // $ANTLR start "outputTypeCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:133:1: outputTypeCondition returns [OutStream.OutputEventsFor outputTypeCondition] : ( 'expired-events' | 'current-events' | 'all-events' );
    public final OutStream.OutputEventsFor outputTypeCondition() throws RecognitionException {
        OutStream.OutputEventsFor outputTypeCondition = null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:134:2: ( 'expired-events' | 'current-events' | 'all-events' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt22=1;
                }
                break;
            case 97:
                {
                alt22=2;
                }
                break;
            case 91:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return outputTypeCondition;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:134:4: 'expired-events'
                    {
                    match(input,103,FOLLOW_103_in_outputTypeCondition566); if (state.failed) return outputTypeCondition;

                    if ( state.backtracking==0 ) {outputTypeCondition =OutStream.OutputEventsFor.EXPIRED_EVENTS;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:135:4: 'current-events'
                    {
                    match(input,97,FOLLOW_97_in_outputTypeCondition573); if (state.failed) return outputTypeCondition;

                    if ( state.backtracking==0 ) {outputTypeCondition =OutStream.OutputEventsFor.CURRENT_EVENTS;}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:136:4: 'all-events'
                    {
                    match(input,91,FOLLOW_91_in_outputTypeCondition580); if (state.failed) return outputTypeCondition;

                    if ( state.backtracking==0 ) {outputTypeCondition =OutStream.OutputEventsFor.ALL_EVENTS;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return outputTypeCondition;
    }
    // $ANTLR end "outputTypeCondition"



    // $ANTLR start "inputStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:139:1: inputStream returns [Stream inStream] : ( ^( SEQUENCE_FULL sequenceFullStream ) | ^( PATTERN_FULL patternFullStream ) | ^( JOIN joinStream ) | windowStream | basicStream );
    public final Stream inputStream() throws RecognitionException {
        Stream inStream = null;


        SequenceStream sequenceFullStream40 =null;

        PatternStream patternFullStream41 =null;

        Stream joinStream42 =null;

        SingleStream windowStream43 =null;

        BasicStream basicStream44 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:140:2: ( ^( SEQUENCE_FULL sequenceFullStream ) | ^( PATTERN_FULL patternFullStream ) | ^( JOIN joinStream ) | windowStream | basicStream )
            int alt23=5;
            switch ( input.LA(1) ) {
            case SEQUENCE_FULL:
                {
                alt23=1;
                }
                break;
            case PATTERN_FULL:
                {
                alt23=2;
                }
                break;
            case JOIN:
                {
                alt23=3;
                }
                break;
            case STREAM:
                {
                int LA23_4 = input.LA(2);

                if ( (synpred29_SiddhiQLGrammarWalker()) ) {
                    alt23=4;
                }
                else if ( (true) ) {
                    alt23=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return inStream;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return inStream;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:140:4: ^( SEQUENCE_FULL sequenceFullStream )
                    {
                    match(input,SEQUENCE_FULL,FOLLOW_SEQUENCE_FULL_in_inputStream602); if (state.failed) return inStream;

                    match(input, Token.DOWN, null); if (state.failed) return inStream;
                    pushFollow(FOLLOW_sequenceFullStream_in_inputStream604);
                    sequenceFullStream40=sequenceFullStream();

                    state._fsp--;
                    if (state.failed) return inStream;

                    match(input, Token.UP, null); if (state.failed) return inStream;


                    if ( state.backtracking==0 ) {inStream =sequenceFullStream40;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:141:4: ^( PATTERN_FULL patternFullStream )
                    {
                    match(input,PATTERN_FULL,FOLLOW_PATTERN_FULL_in_inputStream613); if (state.failed) return inStream;

                    match(input, Token.DOWN, null); if (state.failed) return inStream;
                    pushFollow(FOLLOW_patternFullStream_in_inputStream616);
                    patternFullStream41=patternFullStream();

                    state._fsp--;
                    if (state.failed) return inStream;

                    match(input, Token.UP, null); if (state.failed) return inStream;


                    if ( state.backtracking==0 ) {inStream =patternFullStream41;}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:142:4: ^( JOIN joinStream )
                    {
                    match(input,JOIN,FOLLOW_JOIN_in_inputStream626); if (state.failed) return inStream;

                    match(input, Token.DOWN, null); if (state.failed) return inStream;
                    pushFollow(FOLLOW_joinStream_in_inputStream628);
                    joinStream42=joinStream();

                    state._fsp--;
                    if (state.failed) return inStream;

                    match(input, Token.UP, null); if (state.failed) return inStream;


                    if ( state.backtracking==0 ) {inStream =joinStream42;}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:143:4: windowStream
                    {
                    pushFollow(FOLLOW_windowStream_in_inputStream637);
                    windowStream43=windowStream();

                    state._fsp--;
                    if (state.failed) return inStream;

                    if ( state.backtracking==0 ) {inStream =windowStream43;}

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:144:4: basicStream
                    {
                    pushFollow(FOLLOW_basicStream_in_inputStream653);
                    basicStream44=basicStream();

                    state._fsp--;
                    if (state.failed) return inStream;

                    if ( state.backtracking==0 ) {inStream =basicStream44;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inStream;
    }
    // $ANTLR end "inputStream"



    // $ANTLR start "output"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:147:2: output returns [OutputRate outputRate] : ( ^( OUTPUT timeExpr ( SNAPSHOT | ( outputType )? ) ) | ^( OUTPUT POSITIVE_INT_VAL ( outputType )? ) );
    public final OutputRate output() throws RecognitionException {
        OutputRate outputRate = null;


        CommonTree POSITIVE_INT_VAL47=null;
        long timeExpr45 =0;

        Output.Type outputType46 =null;

        Output.Type outputType48 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:148:3: ( ^( OUTPUT timeExpr ( SNAPSHOT | ( outputType )? ) ) | ^( OUTPUT POSITIVE_INT_VAL ( outputType )? ) )
            int alt27=2;
            switch ( input.LA(1) ) {
            case OUTPUT:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case POSITIVE_INT_VAL:
                        {
                        alt27=2;
                        }
                        break;
                    case TIME_EXP:
                        {
                        alt27=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return outputRate;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 2, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return outputRate;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return outputRate;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:148:5: ^( OUTPUT timeExpr ( SNAPSHOT | ( outputType )? ) )
                    {
                    match(input,OUTPUT,FOLLOW_OUTPUT_in_output685); if (state.failed) return outputRate;

                    match(input, Token.DOWN, null); if (state.failed) return outputRate;
                    pushFollow(FOLLOW_timeExpr_in_output687);
                    timeExpr45=timeExpr();

                    state._fsp--;
                    if (state.failed) return outputRate;

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:148:24: ( SNAPSHOT | ( outputType )? )
                    int alt25=2;
                    switch ( input.LA(1) ) {
                    case SNAPSHOT:
                        {
                        alt25=1;
                        }
                        break;
                    case UP:
                    case 90:
                    case 104:
                    case 118:
                        {
                        alt25=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return outputRate;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;

                    }

                    switch (alt25) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:148:25: SNAPSHOT
                            {
                            match(input,SNAPSHOT,FOLLOW_SNAPSHOT_in_output691); if (state.failed) return outputRate;

                            if ( state.backtracking==0 ) { outputRate = new SnapshotOutputRate(timeExpr45);}

                            }
                            break;
                        case 2 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:148:92: ( outputType )?
                            {
                            if ( state.backtracking==0 ) { outputRate = new TimeOutputRate(timeExpr45);}

                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:148:145: ( outputType )?
                            int alt24=2;
                            switch ( input.LA(1) ) {
                                case 90:
                                case 104:
                                case 118:
                                    {
                                    alt24=1;
                                    }
                                    break;
                            }

                            switch (alt24) {
                                case 1 :
                                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:148:146: outputType
                                    {
                                    pushFollow(FOLLOW_outputType_in_output699);
                                    outputType46=outputType();

                                    state._fsp--;
                                    if (state.failed) return outputRate;

                                    if ( state.backtracking==0 ) {((TimeOutputRate)outputRate).output(outputType46);}

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return outputRate;


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:149:5: ^( OUTPUT POSITIVE_INT_VAL ( outputType )? )
                    {
                    match(input,OUTPUT,FOLLOW_OUTPUT_in_output712); if (state.failed) return outputRate;

                    match(input, Token.DOWN, null); if (state.failed) return outputRate;
                    POSITIVE_INT_VAL47=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_output714); if (state.failed) return outputRate;

                    if ( state.backtracking==0 ) {outputRate = new EventOutputRate(Integer.parseInt((POSITIVE_INT_VAL47!=null?POSITIVE_INT_VAL47.getText():null)));}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:149:110: ( outputType )?
                    int alt26=2;
                    switch ( input.LA(1) ) {
                        case 90:
                        case 104:
                        case 118:
                            {
                            alt26=1;
                            }
                            break;
                    }

                    switch (alt26) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:149:111: outputType
                            {
                            pushFollow(FOLLOW_outputType_in_output720);
                            outputType48=outputType();

                            state._fsp--;
                            if (state.failed) return outputRate;

                            if ( state.backtracking==0 ) {((EventOutputRate)outputRate).output(outputType48);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return outputRate;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return outputRate;
    }
    // $ANTLR end "output"



    // $ANTLR start "outputType"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:152:2: outputType returns [Output.Type value] : ( 'all' | 'last' | 'first' );
    public final Output.Type outputType() throws RecognitionException {
        Output.Type value = null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:153:3: ( 'all' | 'last' | 'first' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt28=1;
                }
                break;
            case 118:
                {
                alt28=2;
                }
                break;
            case 104:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:153:5: 'all'
                    {
                    match(input,90,FOLLOW_90_in_outputType744); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =Output.Type.ALL;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:154:5: 'last'
                    {
                    match(input,118,FOLLOW_118_in_outputType752); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =Output.Type.LAST;}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:155:5: 'first'
                    {
                    match(input,104,FOLLOW_104_in_outputType760); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =Output.Type.FIRST;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "outputType"



    // $ANTLR start "partition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:158:1: partition returns [String value] : ^( PARTITION partitionId ) ;
    public final String partition() throws RecognitionException {
        String value = null;


        String partitionId49 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:159:2: ( ^( PARTITION partitionId ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:159:3: ^( PARTITION partitionId )
            {
            match(input,PARTITION,FOLLOW_PARTITION_in_partition778); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            pushFollow(FOLLOW_partitionId_in_partition780);
            partitionId49=partitionId();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =partitionId49;}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "partition"



    // $ANTLR start "basicStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:162:1: basicStream returns [BasicStream basicStream] : ^( STREAM rawStream ( transformHandler )? ( id )? ) ;
    public final BasicStream basicStream() throws RecognitionException {
        BasicStream basicStream = null;


        BasicStream rawStream50 =null;

        Transformer transformHandler51 =null;

        String id52 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:163:2: ( ^( STREAM rawStream ( transformHandler )? ( id )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:163:4: ^( STREAM rawStream ( transformHandler )? ( id )? )
            {
            match(input,STREAM,FOLLOW_STREAM_in_basicStream800); if (state.failed) return basicStream;

            match(input, Token.DOWN, null); if (state.failed) return basicStream;
            pushFollow(FOLLOW_rawStream_in_basicStream802);
            rawStream50=rawStream();

            state._fsp--;
            if (state.failed) return basicStream;

            if ( state.backtracking==0 ) {basicStream =rawStream50;}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:163:60: ( transformHandler )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case TRANSFORM:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:163:61: transformHandler
                    {
                    pushFollow(FOLLOW_transformHandler_in_basicStream807);
                    transformHandler51=transformHandler();

                    state._fsp--;
                    if (state.failed) return basicStream;

                    if ( state.backtracking==0 ) {basicStream.setTransformer(transformHandler51);}

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:163:142: ( id )?
            int alt30=2;
            switch ( input.LA(1) ) {
                case ID:
                case ID_QUOTES:
                    {
                    alt30=1;
                    }
                    break;
            }

            switch (alt30) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:163:143: id
                    {
                    pushFollow(FOLLOW_id_in_basicStream814);
                    id52=id();

                    state._fsp--;
                    if (state.failed) return basicStream;

                    if ( state.backtracking==0 ) {basicStream.setStreamReferenceId(id52);}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return basicStream;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return basicStream;
    }
    // $ANTLR end "basicStream"



    // $ANTLR start "windowStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:166:1: windowStream returns [SingleStream singleStream] : ( ^( STREAM ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) | ^( STREAM ^( streamId ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) );
    public final SingleStream windowStream() throws RecognitionException {
        SingleStream singleStream = null;


        BasicStream returnQuery53 =null;

        Filter filterHandler54 =null;

        Transformer transformHandler55 =null;

        Window windowHandler56 =null;

        String id57 =null;

        String streamId58 =null;

        Filter filterHandler59 =null;

        Transformer transformHandler60 =null;

        Window windowHandler61 =null;

        String id62 =null;



        		BasicStream rawStream=null;
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:2: ( ^( STREAM ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) | ^( STREAM ^( streamId ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) )
            int alt37=2;
            switch ( input.LA(1) ) {
            case STREAM:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case ANONYMOUS:
                        {
                        alt37=1;
                        }
                        break;
                    case ID:
                    case ID_QUOTES:
                        {
                        alt37=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return singleStream;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 2, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return singleStream;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return singleStream;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:4: ^( STREAM ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? )
                    {
                    match(input,STREAM,FOLLOW_STREAM_in_windowStream843); if (state.failed) return singleStream;

                    match(input, Token.DOWN, null); if (state.failed) return singleStream;
                    match(input,ANONYMOUS,FOLLOW_ANONYMOUS_in_windowStream847); if (state.failed) return singleStream;

                    match(input, Token.DOWN, null); if (state.failed) return singleStream;
                    pushFollow(FOLLOW_returnQuery_in_windowStream849);
                    returnQuery53=returnQuery();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {rawStream=returnQuery53;}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:71: ( filterHandler )?
                    int alt31=2;
                    switch ( input.LA(1) ) {
                        case FILTER:
                            {
                            alt31=1;
                            }
                            break;
                    }

                    switch (alt31) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:72: filterHandler
                            {
                            pushFollow(FOLLOW_filterHandler_in_windowStream854);
                            filterHandler54=filterHandler();

                            state._fsp--;
                            if (state.failed) return singleStream;

                            if ( state.backtracking==0 ) {rawStream.setFilter(filterHandler54);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:134: ( transformHandler )?
                    int alt32=2;
                    switch ( input.LA(1) ) {
                        case TRANSFORM:
                            {
                            alt32=1;
                            }
                            break;
                    }

                    switch (alt32) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:135: transformHandler
                            {
                            pushFollow(FOLLOW_transformHandler_in_windowStream861);
                            transformHandler55=transformHandler();

                            state._fsp--;
                            if (state.failed) return singleStream;

                            if ( state.backtracking==0 ) {rawStream.setTransformer(transformHandler55);}

                            }
                            break;

                    }


                    pushFollow(FOLLOW_windowHandler_in_windowStream868);
                    windowHandler56=windowHandler();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {singleStream =rawStream.window(windowHandler56);}

                    match(input, Token.UP, null); if (state.failed) return singleStream;


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:287: ( id )?
                    int alt33=2;
                    switch ( input.LA(1) ) {
                        case ID:
                        case ID_QUOTES:
                            {
                            alt33=1;
                            }
                            break;
                    }

                    switch (alt33) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:170:288: id
                            {
                            pushFollow(FOLLOW_id_in_windowStream875);
                            id57=id();

                            state._fsp--;
                            if (state.failed) return singleStream;

                            if ( state.backtracking==0 ) {singleStream.setStreamReferenceId(id57);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return singleStream;


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:171:4: ^( STREAM ^( streamId ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? )
                    {
                    match(input,STREAM,FOLLOW_STREAM_in_windowStream886); if (state.failed) return singleStream;

                    match(input, Token.DOWN, null); if (state.failed) return singleStream;
                    pushFollow(FOLLOW_streamId_in_windowStream890);
                    streamId58=streamId();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {rawStream=QueryFactory.inputStream(streamId58);}

                    match(input, Token.DOWN, null); if (state.failed) return singleStream;
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:171:80: ( filterHandler )?
                    int alt34=2;
                    switch ( input.LA(1) ) {
                        case FILTER:
                            {
                            alt34=1;
                            }
                            break;
                    }

                    switch (alt34) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:171:81: filterHandler
                            {
                            pushFollow(FOLLOW_filterHandler_in_windowStream895);
                            filterHandler59=filterHandler();

                            state._fsp--;
                            if (state.failed) return singleStream;

                            if ( state.backtracking==0 ) {rawStream.setFilter(filterHandler59);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:171:143: ( transformHandler )?
                    int alt35=2;
                    switch ( input.LA(1) ) {
                        case TRANSFORM:
                            {
                            alt35=1;
                            }
                            break;
                    }

                    switch (alt35) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:171:144: transformHandler
                            {
                            pushFollow(FOLLOW_transformHandler_in_windowStream902);
                            transformHandler60=transformHandler();

                            state._fsp--;
                            if (state.failed) return singleStream;

                            if ( state.backtracking==0 ) {rawStream.setTransformer(transformHandler60);}

                            }
                            break;

                    }


                    pushFollow(FOLLOW_windowHandler_in_windowStream909);
                    windowHandler61=windowHandler();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {singleStream =rawStream.window(windowHandler61);}

                    match(input, Token.UP, null); if (state.failed) return singleStream;


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:171:296: ( id )?
                    int alt36=2;
                    switch ( input.LA(1) ) {
                        case ID:
                        case ID_QUOTES:
                            {
                            alt36=1;
                            }
                            break;
                    }

                    switch (alt36) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:171:297: id
                            {
                            pushFollow(FOLLOW_id_in_windowStream916);
                            id62=id();

                            state._fsp--;
                            if (state.failed) return singleStream;

                            if ( state.backtracking==0 ) {singleStream.setStreamReferenceId(id62);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return singleStream;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return singleStream;
    }
    // $ANTLR end "windowStream"



    // $ANTLR start "rawStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:174:1: rawStream returns [BasicStream rawStream] : ( ^( ANONYMOUS returnQuery ( filterHandler )? ) | ^( streamId ( filterHandler )? ) );
    public final BasicStream rawStream() throws RecognitionException {
        BasicStream rawStream = null;


        BasicStream returnQuery63 =null;

        Filter filterHandler64 =null;

        String streamId65 =null;

        Filter filterHandler66 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:175:2: ( ^( ANONYMOUS returnQuery ( filterHandler )? ) | ^( streamId ( filterHandler )? ) )
            int alt40=2;
            switch ( input.LA(1) ) {
            case ANONYMOUS:
                {
                alt40=1;
                }
                break;
            case ID:
            case ID_QUOTES:
                {
                alt40=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return rawStream;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:175:4: ^( ANONYMOUS returnQuery ( filterHandler )? )
                    {
                    match(input,ANONYMOUS,FOLLOW_ANONYMOUS_in_rawStream938); if (state.failed) return rawStream;

                    match(input, Token.DOWN, null); if (state.failed) return rawStream;
                    pushFollow(FOLLOW_returnQuery_in_rawStream940);
                    returnQuery63=returnQuery();

                    state._fsp--;
                    if (state.failed) return rawStream;

                    if ( state.backtracking==0 ) {rawStream =returnQuery63;}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:175:63: ( filterHandler )?
                    int alt38=2;
                    switch ( input.LA(1) ) {
                        case FILTER:
                            {
                            alt38=1;
                            }
                            break;
                    }

                    switch (alt38) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:175:64: filterHandler
                            {
                            pushFollow(FOLLOW_filterHandler_in_rawStream945);
                            filterHandler64=filterHandler();

                            state._fsp--;
                            if (state.failed) return rawStream;

                            if ( state.backtracking==0 ) {rawStream.setFilter(filterHandler64);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return rawStream;


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:176:4: ^( streamId ( filterHandler )? )
                    {
                    pushFollow(FOLLOW_streamId_in_rawStream958);
                    streamId65=streamId();

                    state._fsp--;
                    if (state.failed) return rawStream;

                    if ( state.backtracking==0 ) {rawStream =QueryFactory.inputStream(streamId65);}

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return rawStream;
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:176:71: ( filterHandler )?
                        int alt39=2;
                        switch ( input.LA(1) ) {
                            case FILTER:
                                {
                                alt39=1;
                                }
                                break;
                        }

                        switch (alt39) {
                            case 1 :
                                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:176:72: filterHandler
                                {
                                pushFollow(FOLLOW_filterHandler_in_rawStream963);
                                filterHandler66=filterHandler();

                                state._fsp--;
                                if (state.failed) return rawStream;

                                if ( state.backtracking==0 ) {rawStream.setFilter(filterHandler66);}

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return rawStream;
                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return rawStream;
    }
    // $ANTLR end "rawStream"


    protected static class joinStream_scope {
        Condition onCondition;
        Expression within;
    }
    protected Stack joinStream_stack = new Stack();



    // $ANTLR start "joinStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:179:1: joinStream returns [Stream stream] : ( leftStream join rightStream 'unidirectional' ( condition )? ( time )? | leftStream join rightStream ( condition )? ( time )? | leftStream 'unidirectional' join rightStream ( condition )? ( time )? );
    public final Stream joinStream() throws RecognitionException {
        joinStream_stack.push(new joinStream_scope());
        Stream stream = null;


        Condition condition67 =null;

        Expression time68 =null;

        SingleStream leftStream69 =null;

        JoinStream.Type join70 =null;

        SingleStream rightStream71 =null;

        Condition condition72 =null;

        Expression time73 =null;

        SingleStream leftStream74 =null;

        JoinStream.Type join75 =null;

        SingleStream rightStream76 =null;

        Condition condition77 =null;

        Expression time78 =null;

        SingleStream leftStream79 =null;

        JoinStream.Type join80 =null;

        SingleStream rightStream81 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:2: ( leftStream join rightStream 'unidirectional' ( condition )? ( time )? | leftStream join rightStream ( condition )? ( time )? | leftStream 'unidirectional' join rightStream ( condition )? ( time )? )
            int alt47=3;
            switch ( input.LA(1) ) {
            case STREAM:
                {
                int LA47_1 = input.LA(2);

                if ( (synpred50_SiddhiQLGrammarWalker()) ) {
                    alt47=1;
                }
                else if ( (synpred53_SiddhiQLGrammarWalker()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return stream;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return stream;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:4: leftStream join rightStream 'unidirectional' ( condition )? ( time )?
                    {
                    pushFollow(FOLLOW_leftStream_in_joinStream989);
                    leftStream69=leftStream();

                    state._fsp--;
                    if (state.failed) return stream;

                    pushFollow(FOLLOW_join_in_joinStream992);
                    join70=join();

                    state._fsp--;
                    if (state.failed) return stream;

                    pushFollow(FOLLOW_rightStream_in_joinStream994);
                    rightStream71=rightStream();

                    state._fsp--;
                    if (state.failed) return stream;

                    match(input,136,FOLLOW_136_in_joinStream996); if (state.failed) return stream;

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:50: ( condition )?
                    int alt41=2;
                    switch ( input.LA(1) ) {
                        case CONDITION:
                            {
                            alt41=1;
                            }
                            break;
                    }

                    switch (alt41) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:51: condition
                            {
                            pushFollow(FOLLOW_condition_in_joinStream999);
                            condition67=condition();

                            state._fsp--;
                            if (state.failed) return stream;

                            if ( state.backtracking==0 ) {((joinStream_scope)joinStream_stack.peek()).onCondition =condition67;}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:112: ( time )?
                    int alt42=2;
                    switch ( input.LA(1) ) {
                        case CONSTANT:
                            {
                            alt42=1;
                            }
                            break;
                    }

                    switch (alt42) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:113: time
                            {
                            pushFollow(FOLLOW_time_in_joinStream1006);
                            time68=time();

                            state._fsp--;
                            if (state.failed) return stream;

                            if ( state.backtracking==0 ) {((joinStream_scope)joinStream_stack.peek()).within =time68;}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { stream=QueryFactory.joinStream(leftStream69,join70,rightStream71,((joinStream_scope)joinStream_stack.peek()).onCondition,(Constant)((joinStream_scope)joinStream_stack.peek()).within,JoinStream.EventTrigger.RIGHT);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:4: leftStream join rightStream ( condition )? ( time )?
                    {
                    pushFollow(FOLLOW_leftStream_in_joinStream1017);
                    leftStream74=leftStream();

                    state._fsp--;
                    if (state.failed) return stream;

                    pushFollow(FOLLOW_join_in_joinStream1019);
                    join75=join();

                    state._fsp--;
                    if (state.failed) return stream;

                    pushFollow(FOLLOW_rightStream_in_joinStream1021);
                    rightStream76=rightStream();

                    state._fsp--;
                    if (state.failed) return stream;

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:32: ( condition )?
                    int alt43=2;
                    switch ( input.LA(1) ) {
                        case CONDITION:
                            {
                            alt43=1;
                            }
                            break;
                    }

                    switch (alt43) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:33: condition
                            {
                            pushFollow(FOLLOW_condition_in_joinStream1024);
                            condition72=condition();

                            state._fsp--;
                            if (state.failed) return stream;

                            if ( state.backtracking==0 ) {((joinStream_scope)joinStream_stack.peek()).onCondition =condition72;}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:94: ( time )?
                    int alt44=2;
                    switch ( input.LA(1) ) {
                        case CONSTANT:
                            {
                            alt44=1;
                            }
                            break;
                    }

                    switch (alt44) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:95: time
                            {
                            pushFollow(FOLLOW_time_in_joinStream1031);
                            time73=time();

                            state._fsp--;
                            if (state.failed) return stream;

                            if ( state.backtracking==0 ) {((joinStream_scope)joinStream_stack.peek()).within =time73;}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { stream=QueryFactory.joinStream(leftStream74,join75,rightStream76,((joinStream_scope)joinStream_stack.peek()).onCondition,(Constant)((joinStream_scope)joinStream_stack.peek()).within);}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:186:4: leftStream 'unidirectional' join rightStream ( condition )? ( time )?
                    {
                    pushFollow(FOLLOW_leftStream_in_joinStream1048);
                    leftStream79=leftStream();

                    state._fsp--;
                    if (state.failed) return stream;

                    match(input,136,FOLLOW_136_in_joinStream1050); if (state.failed) return stream;

                    pushFollow(FOLLOW_join_in_joinStream1053);
                    join80=join();

                    state._fsp--;
                    if (state.failed) return stream;

                    pushFollow(FOLLOW_rightStream_in_joinStream1055);
                    rightStream81=rightStream();

                    state._fsp--;
                    if (state.failed) return stream;

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:186:50: ( condition )?
                    int alt45=2;
                    switch ( input.LA(1) ) {
                        case CONDITION:
                            {
                            alt45=1;
                            }
                            break;
                    }

                    switch (alt45) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:186:51: condition
                            {
                            pushFollow(FOLLOW_condition_in_joinStream1058);
                            condition77=condition();

                            state._fsp--;
                            if (state.failed) return stream;

                            if ( state.backtracking==0 ) {((joinStream_scope)joinStream_stack.peek()).onCondition =condition77;}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:186:112: ( time )?
                    int alt46=2;
                    switch ( input.LA(1) ) {
                        case CONSTANT:
                            {
                            alt46=1;
                            }
                            break;
                    }

                    switch (alt46) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:186:113: time
                            {
                            pushFollow(FOLLOW_time_in_joinStream1065);
                            time78=time();

                            state._fsp--;
                            if (state.failed) return stream;

                            if ( state.backtracking==0 ) {((joinStream_scope)joinStream_stack.peek()).within =time78;}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { stream=QueryFactory.joinStream(leftStream79,join80,rightStream81,((joinStream_scope)joinStream_stack.peek()).onCondition,(Constant)((joinStream_scope)joinStream_stack.peek()).within,JoinStream.EventTrigger.LEFT);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            joinStream_stack.pop();
        }
        return stream;
    }
    // $ANTLR end "joinStream"



    // $ANTLR start "leftStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:189:1: leftStream returns [SingleStream singleStream] : ( windowStream | basicStream );
    public final SingleStream leftStream() throws RecognitionException {
        SingleStream singleStream = null;


        SingleStream windowStream82 =null;

        BasicStream basicStream83 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:190:5: ( windowStream | basicStream )
            int alt48=2;
            switch ( input.LA(1) ) {
            case STREAM:
                {
                int LA48_1 = input.LA(2);

                if ( (synpred56_SiddhiQLGrammarWalker()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return singleStream;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return singleStream;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:190:8: windowStream
                    {
                    pushFollow(FOLLOW_windowStream_in_leftStream1090);
                    windowStream82=windowStream();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {singleStream =windowStream82;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:191:8: basicStream
                    {
                    pushFollow(FOLLOW_basicStream_in_leftStream1101);
                    basicStream83=basicStream();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {singleStream =basicStream83;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return singleStream;
    }
    // $ANTLR end "leftStream"



    // $ANTLR start "rightStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:194:1: rightStream returns [SingleStream singleStream] : ( windowStream | basicStream );
    public final SingleStream rightStream() throws RecognitionException {
        SingleStream singleStream = null;


        SingleStream windowStream84 =null;

        BasicStream basicStream85 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:195:5: ( windowStream | basicStream )
            int alt49=2;
            switch ( input.LA(1) ) {
            case STREAM:
                {
                int LA49_1 = input.LA(2);

                if ( (synpred57_SiddhiQLGrammarWalker()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return singleStream;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return singleStream;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:195:8: windowStream
                    {
                    pushFollow(FOLLOW_windowStream_in_rightStream1126);
                    windowStream84=windowStream();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {singleStream =windowStream84;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:196:8: basicStream
                    {
                    pushFollow(FOLLOW_basicStream_in_rightStream1137);
                    basicStream85=basicStream();

                    state._fsp--;
                    if (state.failed) return singleStream;

                    if ( state.backtracking==0 ) {singleStream =basicStream85;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return singleStream;
    }
    // $ANTLR end "rightStream"



    // $ANTLR start "returnQuery"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:199:1: returnQuery returns [BasicStream stream] : ^( RETURN_QUERY inputStream outputSelection ) ;
    public final BasicStream returnQuery() throws RecognitionException {
        BasicStream stream = null;


        Stream inputStream86 =null;

        Selector outputSelection87 =null;



        		System.err.println("Return Query not yet supported!");
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:203:2: ( ^( RETURN_QUERY inputStream outputSelection ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:203:4: ^( RETURN_QUERY inputStream outputSelection )
            {
            match(input,RETURN_QUERY,FOLLOW_RETURN_QUERY_in_returnQuery1164); if (state.failed) return stream;

            match(input, Token.DOWN, null); if (state.failed) return stream;
            pushFollow(FOLLOW_inputStream_in_returnQuery1167);
            inputStream86=inputStream();

            state._fsp--;
            if (state.failed) return stream;

            pushFollow(FOLLOW_outputSelection_in_returnQuery1169);
            outputSelection87=outputSelection();

            state._fsp--;
            if (state.failed) return stream;

            match(input, Token.UP, null); if (state.failed) return stream;


            if ( state.backtracking==0 ) {stream=QueryFactory.createQuery().from(inputStream86).select(outputSelection87).returnStream();}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return stream;
    }
    // $ANTLR end "returnQuery"



    // $ANTLR start "patternFullStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:206:1: patternFullStream returns [PatternStream stream] : ^( PATTERN patternStream ( time )? ) ;
    public final PatternStream patternFullStream() throws RecognitionException {
        PatternStream stream = null;


        PatternElement patternStream88 =null;

        Expression time89 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:207:2: ( ^( PATTERN patternStream ( time )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:207:4: ^( PATTERN patternStream ( time )? )
            {
            match(input,PATTERN,FOLLOW_PATTERN_in_patternFullStream1188); if (state.failed) return stream;

            match(input, Token.DOWN, null); if (state.failed) return stream;
            pushFollow(FOLLOW_patternStream_in_patternFullStream1191);
            patternStream88=patternStream();

            state._fsp--;
            if (state.failed) return stream;

            if ( state.backtracking==0 ) {stream= QueryFactory.patternStream(patternStream88);}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:207:91: ( time )?
            int alt50=2;
            switch ( input.LA(1) ) {
                case CONSTANT:
                    {
                    alt50=1;
                    }
                    break;
            }

            switch (alt50) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:207:92: time
                    {
                    pushFollow(FOLLOW_time_in_patternFullStream1196);
                    time89=time();

                    state._fsp--;
                    if (state.failed) return stream;

                    if ( state.backtracking==0 ) {stream= QueryFactory.patternStream(patternStream88,(Constant)time89);}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return stream;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return stream;
    }
    // $ANTLR end "patternFullStream"



    // $ANTLR start "patternStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:210:1: patternStream returns [PatternElement element] : ( ^( 'every' patternItem ) (p= patternStream )? | ^( 'every' nonEveryPatternStream ) (p= patternStream )? | patternItem (p= patternStream )? );
    public final PatternElement patternStream() throws RecognitionException {
        PatternElement element = null;


        PatternElement p =null;

        PatternElement patternItem90 =null;

        PatternElement nonEveryPatternStream91 =null;

        PatternElement patternItem92 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:2: ( ^( 'every' patternItem ) (p= patternStream )? | ^( 'every' nonEveryPatternStream ) (p= patternStream )? | patternItem (p= patternStream )? )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 102:
                {
                int LA54_1 = input.LA(2);

                if ( (synpred60_SiddhiQLGrammarWalker()) ) {
                    alt54=1;
                }
                else if ( (synpred62_SiddhiQLGrammarWalker()) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;

                }
                }
                break;
            case COLLECT:
            case STREAM:
            case 92:
            case 123:
                {
                alt54=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:4: ^( 'every' patternItem ) (p= patternStream )?
                    {
                    match(input,102,FOLLOW_102_in_patternStream1219); if (state.failed) return element;

                    match(input, Token.DOWN, null); if (state.failed) return element;
                    pushFollow(FOLLOW_patternItem_in_patternStream1222);
                    patternItem90=patternItem();

                    state._fsp--;
                    if (state.failed) return element;

                    match(input, Token.UP, null); if (state.failed) return element;


                    if ( state.backtracking==0 ) {element =Pattern.every(patternItem90);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:76: (p= patternStream )?
                    int alt51=2;
                    switch ( input.LA(1) ) {
                        case COLLECT:
                        case STREAM:
                        case 92:
                        case 102:
                        case 123:
                            {
                            alt51=1;
                            }
                            break;
                    }

                    switch (alt51) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:77: p= patternStream
                            {
                            pushFollow(FOLLOW_patternStream_in_patternStream1230);
                            p=patternStream();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {element =Pattern.followedBy(element,p);}

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:212:4: ^( 'every' nonEveryPatternStream ) (p= patternStream )?
                    {
                    match(input,102,FOLLOW_102_in_patternStream1240); if (state.failed) return element;

                    match(input, Token.DOWN, null); if (state.failed) return element;
                    pushFollow(FOLLOW_nonEveryPatternStream_in_patternStream1242);
                    nonEveryPatternStream91=nonEveryPatternStream();

                    state._fsp--;
                    if (state.failed) return element;

                    match(input, Token.UP, null); if (state.failed) return element;


                    if ( state.backtracking==0 ) {element =Pattern.every(nonEveryPatternStream91);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:212:98: (p= patternStream )?
                    int alt52=2;
                    switch ( input.LA(1) ) {
                        case COLLECT:
                        case STREAM:
                        case 92:
                        case 102:
                        case 123:
                            {
                            alt52=1;
                            }
                            break;
                    }

                    switch (alt52) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:212:99: p= patternStream
                            {
                            pushFollow(FOLLOW_patternStream_in_patternStream1253);
                            p=patternStream();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {element =Pattern.followedBy(element,p);}

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:213:4: patternItem (p= patternStream )?
                    {
                    pushFollow(FOLLOW_patternItem_in_patternStream1262);
                    patternItem92=patternItem();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {element =patternItem92;}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:213:49: (p= patternStream )?
                    int alt53=2;
                    switch ( input.LA(1) ) {
                        case COLLECT:
                        case STREAM:
                        case 92:
                        case 102:
                        case 123:
                            {
                            alt53=1;
                            }
                            break;
                    }

                    switch (alt53) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:213:50: p= patternStream
                            {
                            pushFollow(FOLLOW_patternStream_in_patternStream1269);
                            p=patternStream();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {element =Pattern.followedBy(element,p);}

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return element;
    }
    // $ANTLR end "patternStream"



    // $ANTLR start "nonEveryPatternStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:216:1: nonEveryPatternStream returns [PatternElement element] : patternItem (p= nonEveryPatternStream )? ;
    public final PatternElement nonEveryPatternStream() throws RecognitionException {
        PatternElement element = null;


        PatternElement p =null;

        PatternElement patternItem93 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:217:2: ( patternItem (p= nonEveryPatternStream )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:217:4: patternItem (p= nonEveryPatternStream )?
            {
            pushFollow(FOLLOW_patternItem_in_nonEveryPatternStream1292);
            patternItem93=patternItem();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {element =patternItem93;}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:217:49: (p= nonEveryPatternStream )?
            int alt55=2;
            switch ( input.LA(1) ) {
                case COLLECT:
                case STREAM:
                case 92:
                case 123:
                    {
                    alt55=1;
                    }
                    break;
            }

            switch (alt55) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:217:50: p= nonEveryPatternStream
                    {
                    pushFollow(FOLLOW_nonEveryPatternStream_in_nonEveryPatternStream1299);
                    p=nonEveryPatternStream();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {element =Pattern.followedBy(element,p);}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return element;
    }
    // $ANTLR end "nonEveryPatternStream"



    // $ANTLR start "sequenceFullStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:220:1: sequenceFullStream returns [SequenceStream stream] : ^( SEQUENCE sequenceStream ( time )? ) ;
    public final SequenceStream sequenceFullStream() throws RecognitionException {
        SequenceStream stream = null;


        SequenceElement sequenceStream94 =null;

        Expression time95 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:221:2: ( ^( SEQUENCE sequenceStream ( time )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:221:4: ^( SEQUENCE sequenceStream ( time )? )
            {
            match(input,SEQUENCE,FOLLOW_SEQUENCE_in_sequenceFullStream1319); if (state.failed) return stream;

            match(input, Token.DOWN, null); if (state.failed) return stream;
            pushFollow(FOLLOW_sequenceStream_in_sequenceFullStream1322);
            sequenceStream94=sequenceStream();

            state._fsp--;
            if (state.failed) return stream;

            if ( state.backtracking==0 ) {stream= QueryFactory.sequenceStream(sequenceStream94);}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:221:95: ( time )?
            int alt56=2;
            switch ( input.LA(1) ) {
                case CONSTANT:
                    {
                    alt56=1;
                    }
                    break;
            }

            switch (alt56) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:221:96: time
                    {
                    pushFollow(FOLLOW_time_in_sequenceFullStream1327);
                    time95=time();

                    state._fsp--;
                    if (state.failed) return stream;

                    if ( state.backtracking==0 ) {stream= QueryFactory.sequenceStream(sequenceStream94,(Constant)time95);}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return stream;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return stream;
    }
    // $ANTLR end "sequenceFullStream"



    // $ANTLR start "sequenceStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:224:1: sequenceStream returns [SequenceElement element] : ( sequenceItem )+ ;
    public final SequenceElement sequenceStream() throws RecognitionException {
        SequenceElement element = null;


        SequenceElement sequenceItem96 =null;



        		List<SequenceElement> elementList=new ArrayList<SequenceElement>();
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:234:2: ( ( sequenceItem )+ )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:234:5: ( sequenceItem )+
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:234:5: ( sequenceItem )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                switch ( input.LA(1) ) {
                case REGEX:
                case STREAM:
                case 123:
                    {
                    alt57=1;
                    }
                    break;

                }

                switch (alt57) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:234:6: sequenceItem
            	    {
            	    pushFollow(FOLLOW_sequenceItem_in_sequenceStream1361);
            	    sequenceItem96=sequenceItem();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {elementList.add(sequenceItem96);}

            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
            		element =elementList.get(elementList.size()-1);
            		for(int i=elementList.size()-2;i>=0;i--){
            			element =Sequence.next(elementList.get(i),element);
            		}
            	}
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return element;
    }
    // $ANTLR end "sequenceStream"



    // $ANTLR start "patternItem"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:237:1: patternItem returns [PatternElement element] : ( ^( 'and' i1= itemStream i2= itemStream ) | ^( 'or' i1= itemStream i2= itemStream ) | ^( COLLECT itemStream collect ) | itemStream );
    public final PatternElement patternItem() throws RecognitionException {
        PatternElement element = null;


        BasicStream i1 =null;

        BasicStream i2 =null;

        BasicStream itemStream97 =null;

        SiddhiQLGrammarWalker.collect_return collect98 =null;

        BasicStream itemStream99 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:238:2: ( ^( 'and' i1= itemStream i2= itemStream ) | ^( 'or' i1= itemStream i2= itemStream ) | ^( COLLECT itemStream collect ) | itemStream )
            int alt58=4;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt58=1;
                }
                break;
            case 123:
                {
                alt58=2;
                }
                break;
            case COLLECT:
                {
                alt58=3;
                }
                break;
            case STREAM:
                {
                alt58=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }

            switch (alt58) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:238:4: ^( 'and' i1= itemStream i2= itemStream )
                    {
                    match(input,92,FOLLOW_92_in_patternItem1383); if (state.failed) return element;

                    match(input, Token.DOWN, null); if (state.failed) return element;
                    pushFollow(FOLLOW_itemStream_in_patternItem1387);
                    i1=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    pushFollow(FOLLOW_itemStream_in_patternItem1391);
                    i2=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    match(input, Token.UP, null); if (state.failed) return element;


                    if ( state.backtracking==0 ) {element=Pattern.logical(i1,LogicalElement.Type.AND,i2);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:239:4: ^( 'or' i1= itemStream i2= itemStream )
                    {
                    match(input,123,FOLLOW_123_in_patternItem1401); if (state.failed) return element;

                    match(input, Token.DOWN, null); if (state.failed) return element;
                    pushFollow(FOLLOW_itemStream_in_patternItem1406);
                    i1=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    pushFollow(FOLLOW_itemStream_in_patternItem1410);
                    i2=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    match(input, Token.UP, null); if (state.failed) return element;


                    if ( state.backtracking==0 ) {element=Pattern.logical(i1,LogicalElement.Type.OR,i2);}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:240:4: ^( COLLECT itemStream collect )
                    {
                    match(input,COLLECT,FOLLOW_COLLECT_in_patternItem1419); if (state.failed) return element;

                    match(input, Token.DOWN, null); if (state.failed) return element;
                    pushFollow(FOLLOW_itemStream_in_patternItem1421);
                    itemStream97=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    pushFollow(FOLLOW_collect_in_patternItem1423);
                    collect98=collect();

                    state._fsp--;
                    if (state.failed) return element;

                    match(input, Token.UP, null); if (state.failed) return element;


                    if ( state.backtracking==0 ) {element=Pattern.count(itemStream97,(collect98!=null?collect98.startVal:0),(collect98!=null?collect98.endVal:0));}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:241:4: itemStream
                    {
                    pushFollow(FOLLOW_itemStream_in_patternItem1432);
                    itemStream99=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {element=itemStream99;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return element;
    }
    // $ANTLR end "patternItem"



    // $ANTLR start "sequenceItem"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:244:1: sequenceItem returns [SequenceElement element] : ( ^( 'or' i1= itemStream i2= itemStream ) | ^( REGEX itemStream regex[$itemStream.basicStream] ) | itemStream );
    public final SequenceElement sequenceItem() throws RecognitionException {
        SequenceElement element = null;


        BasicStream i1 =null;

        BasicStream i2 =null;

        BasicStream itemStream100 =null;

        SequenceElement regex101 =null;

        BasicStream itemStream102 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:245:2: ( ^( 'or' i1= itemStream i2= itemStream ) | ^( REGEX itemStream regex[$itemStream.basicStream] ) | itemStream )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt59=1;
                }
                break;
            case REGEX:
                {
                alt59=2;
                }
                break;
            case STREAM:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:245:4: ^( 'or' i1= itemStream i2= itemStream )
                    {
                    match(input,123,FOLLOW_123_in_sequenceItem1455); if (state.failed) return element;

                    match(input, Token.DOWN, null); if (state.failed) return element;
                    pushFollow(FOLLOW_itemStream_in_sequenceItem1459);
                    i1=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    pushFollow(FOLLOW_itemStream_in_sequenceItem1463);
                    i2=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    match(input, Token.UP, null); if (state.failed) return element;


                    if ( state.backtracking==0 ) {element=Sequence.or(i1,i2);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:246:4: ^( REGEX itemStream regex[$itemStream.basicStream] )
                    {
                    match(input,REGEX,FOLLOW_REGEX_in_sequenceItem1477); if (state.failed) return element;

                    match(input, Token.DOWN, null); if (state.failed) return element;
                    pushFollow(FOLLOW_itemStream_in_sequenceItem1479);
                    itemStream100=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    pushFollow(FOLLOW_regex_in_sequenceItem1481);
                    regex101=regex(itemStream100);

                    state._fsp--;
                    if (state.failed) return element;

                    match(input, Token.UP, null); if (state.failed) return element;


                    if ( state.backtracking==0 ) {element=regex101;}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:247:4: itemStream
                    {
                    pushFollow(FOLLOW_itemStream_in_sequenceItem1492);
                    itemStream102=itemStream();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {element=itemStream102;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return element;
    }
    // $ANTLR end "sequenceItem"



    // $ANTLR start "itemStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:250:1: itemStream returns [BasicStream basicStream] : ^( STREAM rawStream ( attributeName )? ) ;
    public final BasicStream itemStream() throws RecognitionException {
        BasicStream basicStream = null;


        BasicStream rawStream103 =null;

        String attributeName104 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:251:2: ( ^( STREAM rawStream ( attributeName )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:251:4: ^( STREAM rawStream ( attributeName )? )
            {
            match(input,STREAM,FOLLOW_STREAM_in_itemStream1523); if (state.failed) return basicStream;

            match(input, Token.DOWN, null); if (state.failed) return basicStream;
            pushFollow(FOLLOW_rawStream_in_itemStream1525);
            rawStream103=rawStream();

            state._fsp--;
            if (state.failed) return basicStream;

            if ( state.backtracking==0 ) {basicStream =rawStream103;}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:251:59: ( attributeName )?
            int alt60=2;
            switch ( input.LA(1) ) {
                case ATTRIBUTE:
                    {
                    alt60=1;
                    }
                    break;
            }

            switch (alt60) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:251:60: attributeName
                    {
                    pushFollow(FOLLOW_attributeName_in_itemStream1529);
                    attributeName104=attributeName();

                    state._fsp--;
                    if (state.failed) return basicStream;

                    if ( state.backtracking==0 ) {basicStream.setStreamReferenceId(attributeName104);}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return basicStream;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return basicStream;
    }
    // $ANTLR end "itemStream"



    // $ANTLR start "regex"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:255:1: regex[BasicStream basicStream] returns [SequenceElement element] : ( '*' | '+' | '?' ) ( '?' )? ;
    public final SequenceElement regex(BasicStream basicStream) throws RecognitionException {
        SequenceElement element = null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:2: ( ( '*' | '+' | '?' ) ( '?' )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:4: ( '*' | '+' | '?' ) ( '?' )?
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:4: ( '*' | '+' | '?' )
            int alt61=3;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt61=1;
                }
                break;
            case 74:
                {
                alt61=2;
                }
                break;
            case 87:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:5: '*'
                    {
                    match(input,73,FOLLOW_73_in_regex1555); if (state.failed) return element;

                    if ( state.backtracking==0 ) {element =Sequence.zeroOrMany(basicStream);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:56: '+'
                    {
                    match(input,74,FOLLOW_74_in_regex1560); if (state.failed) return element;

                    if ( state.backtracking==0 ) {element =Sequence.oneOrMany(basicStream);}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:105: '?'
                    {
                    match(input,87,FOLLOW_87_in_regex1564); if (state.failed) return element;

                    if ( state.backtracking==0 ) {element =Sequence.zeroOrOne(basicStream);}

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:155: ( '?' )?
            int alt62=2;
            switch ( input.LA(1) ) {
                case 87:
                    {
                    alt62=1;
                    }
                    break;
            }

            switch (alt62) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:256:156: '?'
                    {
                    match(input,87,FOLLOW_87_in_regex1570); if (state.failed) return element;

                    if ( state.backtracking==0 ) {System.err.println(" ? variation in regex not yet supported!");}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return element;
    }
    // $ANTLR end "regex"



    // $ANTLR start "outputSelection"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:259:1: outputSelection returns [Selector selector] : ^( OUT_ATTRIBUTES outputAttributeList ) ( groupBy )? ( having )? ;
    public final Selector outputSelection() throws RecognitionException {
        Selector selector = null;


        List<OutputAttribute> outputAttributeList105 =null;

        List<Variable> groupBy106 =null;

        Condition having107 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:260:2: ( ^( OUT_ATTRIBUTES outputAttributeList ) ( groupBy )? ( having )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:260:4: ^( OUT_ATTRIBUTES outputAttributeList ) ( groupBy )? ( having )?
            {
            if ( state.backtracking==0 ) {selector = QueryFactory.outputSelector();}

            match(input,OUT_ATTRIBUTES,FOLLOW_OUT_ATTRIBUTES_in_outputSelection1594); if (state.failed) return selector;

            match(input, Token.DOWN, null); if (state.failed) return selector;
            pushFollow(FOLLOW_outputAttributeList_in_outputSelection1596);
            outputAttributeList105=outputAttributeList();

            state._fsp--;
            if (state.failed) return selector;

            if ( state.backtracking==0 ) {selector.addSelectionList(outputAttributeList105);}

            match(input, Token.UP, null); if (state.failed) return selector;


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:262:3: ( groupBy )?
            int alt63=2;
            switch ( input.LA(1) ) {
                case 109:
                    {
                    alt63=1;
                    }
                    break;
            }

            switch (alt63) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:262:4: groupBy
                    {
                    pushFollow(FOLLOW_groupBy_in_outputSelection1605);
                    groupBy106=groupBy();

                    state._fsp--;
                    if (state.failed) return selector;

                    if ( state.backtracking==0 ) {selector.addGroupByList(groupBy106);}

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:263:3: ( having )?
            int alt64=2;
            switch ( input.LA(1) ) {
                case 110:
                    {
                    alt64=1;
                    }
                    break;
            }

            switch (alt64) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:263:4: having
                    {
                    pushFollow(FOLLOW_having_in_outputSelection1614);
                    having107=having();

                    state._fsp--;
                    if (state.failed) return selector;

                    if ( state.backtracking==0 ) {selector.having(having107);}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return selector;
    }
    // $ANTLR end "outputSelection"



    // $ANTLR start "outputAttributeList"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:266:1: outputAttributeList returns [List<OutputAttribute> attributeList] : ( '*' | ( ^( OUT_ATTRIBUTE outputItem ) )+ );
    public final List<OutputAttribute> outputAttributeList() throws RecognitionException {
        List<OutputAttribute> attributeList = null;


        OutputAttribute outputItem108 =null;



        		attributeList =new ArrayList<OutputAttribute>();
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:270:2: ( '*' | ( ^( OUT_ATTRIBUTE outputItem ) )+ )
            int alt66=2;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt66=1;
                }
                break;
            case OUT_ATTRIBUTE:
                {
                alt66=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return attributeList;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }

            switch (alt66) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:270:4: '*'
                    {
                    match(input,73,FOLLOW_73_in_outputAttributeList1639); if (state.failed) return attributeList;

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:271:4: ( ^( OUT_ATTRIBUTE outputItem ) )+
                    {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:271:4: ( ^( OUT_ATTRIBUTE outputItem ) )+
                    int cnt65=0;
                    loop65:
                    do {
                        int alt65=2;
                        switch ( input.LA(1) ) {
                        case OUT_ATTRIBUTE:
                            {
                            alt65=1;
                            }
                            break;

                        }

                        switch (alt65) {
                    	case 1 :
                    	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:271:6: ^( OUT_ATTRIBUTE outputItem )
                    	    {
                    	    match(input,OUT_ATTRIBUTE,FOLLOW_OUT_ATTRIBUTE_in_outputAttributeList1648); if (state.failed) return attributeList;

                    	    match(input, Token.DOWN, null); if (state.failed) return attributeList;
                    	    pushFollow(FOLLOW_outputItem_in_outputAttributeList1650);
                    	    outputItem108=outputItem();

                    	    state._fsp--;
                    	    if (state.failed) return attributeList;

                    	    if ( state.backtracking==0 ) {attributeList.add(outputItem108);}

                    	    match(input, Token.UP, null); if (state.failed) return attributeList;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt65 >= 1 ) break loop65;
                    	    if (state.backtracking>0) {state.failed=true; return attributeList;}
                                EarlyExitException eee =
                                    new EarlyExitException(65, input);
                                throw eee;
                        }
                        cnt65++;
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return attributeList;
    }
    // $ANTLR end "outputAttributeList"



    // $ANTLR start "outputItem"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:274:1: outputItem returns [OutputAttribute value] : ( id extensionOutFunction[$id.value] | outFunction id |ex= expression id | attributeVariable );
    public final OutputAttribute outputItem() throws RecognitionException {
        OutputAttribute value = null;


        Expression ex =null;

        String id109 =null;

        OutputAttributeExtension extensionOutFunction110 =null;

        String id111 =null;

        SiddhiQLGrammarWalker.outFunction_return outFunction112 =null;

        String id113 =null;

        Variable attributeVariable114 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:275:2: ( id extensionOutFunction[$id.value] | outFunction id |ex= expression id | attributeVariable )
            int alt67=4;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                alt67=1;
                }
                break;
            case FUNCTION:
                {
                alt67=2;
                }
                break;
            case CONSTANT:
            case EXTENSION_FUNCTION:
            case 70:
            case 73:
            case 74:
            case 76:
            case 78:
            case 94:
            case 100:
            case 105:
            case 115:
            case 120:
            case 133:
                {
                alt67=3;
                }
                break;
            case ATTRIBUTE:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case ID:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            switch ( input.LA(5) ) {
                            case POSITIVE_INT_VAL:
                                {
                                switch ( input.LA(6) ) {
                                case UP:
                                    {
                                    switch ( input.LA(7) ) {
                                    case ID:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 22, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 18, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    case ID_QUOTES:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 22, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 19, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    default:
                                        if (state.backtracking>0) {state.failed=true; return value;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 67, 16, input);

                                        throw nvae;

                                    }

                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 12, input);

                                    throw nvae;

                                }

                                }
                                break;
                            case LAST:
                                {
                                switch ( input.LA(6) ) {
                                case UP:
                                    {
                                    switch ( input.LA(7) ) {
                                    case ID:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 23, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 20, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    case ID_QUOTES:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 23, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 21, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    default:
                                        if (state.backtracking>0) {state.failed=true; return value;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 67, 17, input);

                                        throw nvae;

                                    }

                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 13, input);

                                    throw nvae;

                                }

                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 8, input);

                                throw nvae;

                            }

                            }
                            break;
                        case ID:
                            {
                            switch ( input.LA(5) ) {
                            case UP:
                                {
                                switch ( input.LA(6) ) {
                                case ID:
                                case ID_QUOTES:
                                    {
                                    alt67=3;
                                    }
                                    break;
                                case UP:
                                    {
                                    alt67=4;
                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 14, input);

                                    throw nvae;

                                }

                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 9, input);

                                throw nvae;

                            }

                            }
                            break;
                        case ID_QUOTES:
                            {
                            switch ( input.LA(5) ) {
                            case UP:
                                {
                                switch ( input.LA(6) ) {
                                case ID:
                                case ID_QUOTES:
                                    {
                                    alt67=3;
                                    }
                                    break;
                                case UP:
                                    {
                                    alt67=4;
                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 14, input);

                                    throw nvae;

                                }

                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 10, input);

                                throw nvae;

                            }

                            }
                            break;
                        case UP:
                            {
                            switch ( input.LA(5) ) {
                            case ID:
                            case ID_QUOTES:
                                {
                                alt67=3;
                                }
                                break;
                            case UP:
                                {
                                alt67=4;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 11, input);

                                throw nvae;

                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return value;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 67, 6, input);

                            throw nvae;

                        }

                        }
                        break;
                    case ID_QUOTES:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            switch ( input.LA(5) ) {
                            case POSITIVE_INT_VAL:
                                {
                                switch ( input.LA(6) ) {
                                case UP:
                                    {
                                    switch ( input.LA(7) ) {
                                    case ID:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 22, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 18, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    case ID_QUOTES:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 22, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 19, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    default:
                                        if (state.backtracking>0) {state.failed=true; return value;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 67, 16, input);

                                        throw nvae;

                                    }

                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 12, input);

                                    throw nvae;

                                }

                                }
                                break;
                            case LAST:
                                {
                                switch ( input.LA(6) ) {
                                case UP:
                                    {
                                    switch ( input.LA(7) ) {
                                    case ID:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 23, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 20, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    case ID_QUOTES:
                                        {
                                        switch ( input.LA(8) ) {
                                        case UP:
                                            {
                                            switch ( input.LA(9) ) {
                                            case ID:
                                            case ID_QUOTES:
                                                {
                                                alt67=3;
                                                }
                                                break;
                                            case UP:
                                                {
                                                alt67=4;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return value;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 67, 23, input);

                                                throw nvae;

                                            }

                                            }
                                            break;
                                        default:
                                            if (state.backtracking>0) {state.failed=true; return value;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 67, 21, input);

                                            throw nvae;

                                        }

                                        }
                                        break;
                                    default:
                                        if (state.backtracking>0) {state.failed=true; return value;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 67, 17, input);

                                        throw nvae;

                                    }

                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 13, input);

                                    throw nvae;

                                }

                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 8, input);

                                throw nvae;

                            }

                            }
                            break;
                        case ID:
                            {
                            switch ( input.LA(5) ) {
                            case UP:
                                {
                                switch ( input.LA(6) ) {
                                case ID:
                                case ID_QUOTES:
                                    {
                                    alt67=3;
                                    }
                                    break;
                                case UP:
                                    {
                                    alt67=4;
                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 14, input);

                                    throw nvae;

                                }

                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 9, input);

                                throw nvae;

                            }

                            }
                            break;
                        case ID_QUOTES:
                            {
                            switch ( input.LA(5) ) {
                            case UP:
                                {
                                switch ( input.LA(6) ) {
                                case ID:
                                case ID_QUOTES:
                                    {
                                    alt67=3;
                                    }
                                    break;
                                case UP:
                                    {
                                    alt67=4;
                                    }
                                    break;
                                default:
                                    if (state.backtracking>0) {state.failed=true; return value;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 67, 14, input);

                                    throw nvae;

                                }

                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 10, input);

                                throw nvae;

                            }

                            }
                            break;
                        case UP:
                            {
                            switch ( input.LA(5) ) {
                            case ID:
                            case ID_QUOTES:
                                {
                                alt67=3;
                                }
                                break;
                            case UP:
                                {
                                alt67=4;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 67, 11, input);

                                throw nvae;

                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return value;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 67, 7, input);

                            throw nvae;

                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return value;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 5, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return value;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 4, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:275:4: id extensionOutFunction[$id.value]
                    {
                    pushFollow(FOLLOW_id_in_outputItem1671);
                    id109=id();

                    state._fsp--;
                    if (state.failed) return value;

                    pushFollow(FOLLOW_extensionOutFunction_in_outputItem1673);
                    extensionOutFunction110=extensionOutFunction(id109);

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =extensionOutFunction110;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:276:7: outFunction id
                    {
                    pushFollow(FOLLOW_outFunction_in_outputItem1684);
                    outFunction112=outFunction();

                    state._fsp--;
                    if (state.failed) return value;

                    pushFollow(FOLLOW_id_in_outputItem1686);
                    id111=id();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =new ComplexAttribute(id111, (outFunction112!=null?outFunction112.name:null), (outFunction112!=null?outFunction112.expressions:null));}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:277:4: ex= expression id
                    {
                    pushFollow(FOLLOW_expression_in_outputItem1697);
                    ex=expression();

                    state._fsp--;
                    if (state.failed) return value;

                    pushFollow(FOLLOW_id_in_outputItem1699);
                    id113=id();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =new SimpleAttribute(id113, ex);}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:278:4: attributeVariable
                    {
                    pushFollow(FOLLOW_attributeVariable_in_outputItem1711);
                    attributeVariable114=attributeVariable();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =new SimpleAttribute(attributeVariable114.getAttributeName(), attributeVariable114);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "outputItem"



    // $ANTLR start "extensionOutFunction"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:281:1: extensionOutFunction[String id] returns [OutputAttributeExtension value] : ^( EXTENSION_FUNCTION extensionId functionId ( parameters )? ) ;
    public final OutputAttributeExtension extensionOutFunction(String id) throws RecognitionException {
        OutputAttributeExtension value = null;


        String extensionId115 =null;

        String functionId116 =null;

        Expression[] parameters117 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:282:5: ( ^( EXTENSION_FUNCTION extensionId functionId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:282:7: ^( EXTENSION_FUNCTION extensionId functionId ( parameters )? )
            {
            match(input,EXTENSION_FUNCTION,FOLLOW_EXTENSION_FUNCTION_in_extensionOutFunction1735); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            pushFollow(FOLLOW_extensionId_in_extensionOutFunction1737);
            extensionId115=extensionId();

            state._fsp--;
            if (state.failed) return value;

            pushFollow(FOLLOW_functionId_in_extensionOutFunction1739);
            functionId116=functionId();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =new OutputAttributeExtension(id, extensionId115, functionId116,null);}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:283:29: ( parameters )?
            int alt68=2;
            switch ( input.LA(1) ) {
                case PARAMETERS:
                    {
                    alt68=1;
                    }
                    break;
            }

            switch (alt68) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:283:30: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_extensionOutFunction1772);
                    parameters117=parameters();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value = new OutputAttributeExtension(id, extensionId115, functionId116, parameters117);}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "extensionOutFunction"


    public static class outFunction_return extends TreeRuleReturnScope {
        public String name;
        public Expression[] expressions;
    };


    // $ANTLR start "outFunction"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:287:1: outFunction returns [String name, Expression[] expressions] : ^( FUNCTION ID ( parameters )? ) ;
    public final SiddhiQLGrammarWalker.outFunction_return outFunction() throws RecognitionException {
        SiddhiQLGrammarWalker.outFunction_return retval = new SiddhiQLGrammarWalker.outFunction_return();
        retval.start = input.LT(1);


        CommonTree ID118=null;
        Expression[] parameters119 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:288:2: ( ^( FUNCTION ID ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:288:5: ^( FUNCTION ID ( parameters )? )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_outFunction1801); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            ID118=(CommonTree)match(input,ID,FOLLOW_ID_in_outFunction1803); if (state.failed) return retval;

            if ( state.backtracking==0 ) {retval.name =(ID118!=null?ID118.getText():null);}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:288:38: ( parameters )?
            int alt69=2;
            switch ( input.LA(1) ) {
                case PARAMETERS:
                    {
                    alt69=1;
                    }
                    break;
            }

            switch (alt69) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:288:39: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_outFunction1808);
                    parameters119=parameters();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.expressions =parameters119;}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outFunction"



    // $ANTLR start "groupBy"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:291:1: groupBy returns [List<Variable> variables] : ^( 'group' ( attributeVariable )+ ) ;
    public final List<Variable> groupBy() throws RecognitionException {
        List<Variable> variables = null;


        Variable attributeVariable120 =null;



        		variables =new ArrayList<Variable>();
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:295:2: ( ^( 'group' ( attributeVariable )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:295:4: ^( 'group' ( attributeVariable )+ )
            {
            match(input,109,FOLLOW_109_in_groupBy1836); if (state.failed) return variables;

            match(input, Token.DOWN, null); if (state.failed) return variables;
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:295:14: ( attributeVariable )+
            int cnt70=0;
            loop70:
            do {
                int alt70=2;
                switch ( input.LA(1) ) {
                case ATTRIBUTE:
                    {
                    alt70=1;
                    }
                    break;

                }

                switch (alt70) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:295:15: attributeVariable
            	    {
            	    pushFollow(FOLLOW_attributeVariable_in_groupBy1839);
            	    attributeVariable120=attributeVariable();

            	    state._fsp--;
            	    if (state.failed) return variables;

            	    if ( state.backtracking==0 ) {variables.add(attributeVariable120);}

            	    }
            	    break;

            	default :
            	    if ( cnt70 >= 1 ) break loop70;
            	    if (state.backtracking>0) {state.failed=true; return variables;}
                        EarlyExitException eee =
                            new EarlyExitException(70, input);
                        throw eee;
                }
                cnt70++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return variables;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return variables;
    }
    // $ANTLR end "groupBy"



    // $ANTLR start "having"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:298:1: having returns [Condition value] : ^( 'having' condition ) ;
    public final Condition having() throws RecognitionException {
        Condition value = null;


        Condition condition121 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:299:2: ( ^( 'having' condition ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:299:4: ^( 'having' condition )
            {
            match(input,110,FOLLOW_110_in_having1860); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            pushFollow(FOLLOW_condition_in_having1862);
            condition121=condition();

            state._fsp--;
            if (state.failed) return value;

            match(input, Token.UP, null); if (state.failed) return value;


            if ( state.backtracking==0 ) {value =condition121;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "having"



    // $ANTLR start "filterHandler"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:302:1: filterHandler returns [Filter filter] : ^( FILTER condition ) ;
    public final Filter filterHandler() throws RecognitionException {
        Filter filter = null;


        Condition condition122 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:303:2: ( ^( FILTER condition ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:303:4: ^( FILTER condition )
            {
            match(input,FILTER,FOLLOW_FILTER_in_filterHandler1882); if (state.failed) return filter;

            match(input, Token.DOWN, null); if (state.failed) return filter;
            pushFollow(FOLLOW_condition_in_filterHandler1884);
            condition122=condition();

            state._fsp--;
            if (state.failed) return filter;

            if ( state.backtracking==0 ) {filter =new Filter(condition122);}

            match(input, Token.UP, null); if (state.failed) return filter;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return filter;
    }
    // $ANTLR end "filterHandler"



    // $ANTLR start "transformHandler"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:306:1: transformHandler returns [Transformer transformer] : ^( TRANSFORM extensibleId[\"transform\"] ( parameters )? ) ;
    public final Transformer transformHandler() throws RecognitionException {
        Transformer transformer = null;


        SiddhiQLGrammarWalker.extensibleId_return extensibleId123 =null;

        Expression[] parameters124 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:307:2: ( ^( TRANSFORM extensibleId[\"transform\"] ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:307:4: ^( TRANSFORM extensibleId[\"transform\"] ( parameters )? )
            {
            match(input,TRANSFORM,FOLLOW_TRANSFORM_in_transformHandler1905); if (state.failed) return transformer;

            match(input, Token.DOWN, null); if (state.failed) return transformer;
            pushFollow(FOLLOW_extensibleId_in_transformHandler1907);
            extensibleId123=extensibleId("transform");

            state._fsp--;
            if (state.failed) return transformer;

            if ( state.backtracking==0 ) {transformer =new Transformer((extensibleId123!=null?extensibleId123.name:null),(TransformExtension) (extensibleId123!=null?extensibleId123.extension:null), null);}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:307:146: ( parameters )?
            int alt71=2;
            switch ( input.LA(1) ) {
                case PARAMETERS:
                    {
                    alt71=1;
                    }
                    break;
            }

            switch (alt71) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:307:147: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_transformHandler1913);
                    parameters124=parameters();

                    state._fsp--;
                    if (state.failed) return transformer;

                    if ( state.backtracking==0 ) {transformer =new Transformer((extensibleId123!=null?extensibleId123.name:null), (TransformExtension)(extensibleId123!=null?extensibleId123.extension:null), parameters124);}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return transformer;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return transformer;
    }
    // $ANTLR end "transformHandler"



    // $ANTLR start "windowHandler"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:310:1: windowHandler returns [Window window] : ^( WINDOW extensibleId[\"window\"] ( parameters )? ) ;
    public final Window windowHandler() throws RecognitionException {
        Window window = null;


        SiddhiQLGrammarWalker.extensibleId_return extensibleId125 =null;

        Expression[] parameters126 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:311:2: ( ^( WINDOW extensibleId[\"window\"] ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:311:4: ^( WINDOW extensibleId[\"window\"] ( parameters )? )
            {
            match(input,WINDOW,FOLLOW_WINDOW_in_windowHandler1935); if (state.failed) return window;

            match(input, Token.DOWN, null); if (state.failed) return window;
            pushFollow(FOLLOW_extensibleId_in_windowHandler1937);
            extensibleId125=extensibleId("window");

            state._fsp--;
            if (state.failed) return window;

            if ( state.backtracking==0 ) {window =new Window((extensibleId125!=null?extensibleId125.name:null),(WindowExtension) (extensibleId125!=null?extensibleId125.extension:null), null);}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:311:126: ( parameters )?
            int alt72=2;
            switch ( input.LA(1) ) {
                case PARAMETERS:
                    {
                    alt72=1;
                    }
                    break;
            }

            switch (alt72) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:311:127: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_windowHandler1943);
                    parameters126=parameters();

                    state._fsp--;
                    if (state.failed) return window;

                    if ( state.backtracking==0 ) {window =new Window((extensibleId125!=null?extensibleId125.name:null), (WindowExtension)(extensibleId125!=null?extensibleId125.extension:null), parameters126);}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return window;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return window;
    }
    // $ANTLR end "windowHandler"


    public static class extensibleId_return extends TreeRuleReturnScope {
        public String name;
        public Extension extension;
    };


    // $ANTLR start "extensibleId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:314:1: extensibleId[String type] returns [String name, Extension extension] : ( id | ^( EXTENSION extensionId functionId ) );
    public final SiddhiQLGrammarWalker.extensibleId_return extensibleId(String type) throws RecognitionException {
        SiddhiQLGrammarWalker.extensibleId_return retval = new SiddhiQLGrammarWalker.extensibleId_return();
        retval.start = input.LT(1);


        String id127 =null;

        String extensionId128 =null;

        String functionId129 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:315:5: ( id | ^( EXTENSION extensionId functionId ) )
            int alt73=2;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                alt73=1;
                }
                break;
            case EXTENSION:
                {
                alt73=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }

            switch (alt73) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:315:7: id
                    {
                    pushFollow(FOLLOW_id_in_extensibleId1968);
                    id127=id();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.name =id127;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:316:7: ^( EXTENSION extensionId functionId )
                    {
                    match(input,EXTENSION,FOLLOW_EXTENSION_in_extensibleId1980); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_extensionId_in_extensibleId1984);
                    extensionId128=extensionId();

                    state._fsp--;
                    if (state.failed) return retval;

                    pushFollow(FOLLOW_functionId_in_extensibleId1986);
                    functionId129=functionId();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                            if("window".equals(type)){
                                retval.extension =new WindowExtension(extensionId128, functionId129);
                            } else if("transform".equals(type)){
                                retval.extension =new TransformExtension(extensionId128, functionId129);
                            } else {
                                System.err.println("Extension for "+type+" is not supported!");
                            }
                        }

                    match(input, Token.UP, null); if (state.failed) return retval;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "extensibleId"


    protected static class parameters_scope {
        List<Expression> parameterlist;
    }
    protected Stack parameters_stack = new Stack();



    // $ANTLR start "parameters"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:327:1: parameters returns [Expression[] expressions] : ^( PARAMETERS ( parameter )+ ) ;
    public final Expression[] parameters() throws RecognitionException {
        parameters_stack.push(new parameters_scope());
        Expression[] expressions = null;


        Expression parameter130 =null;



        		((parameters_scope)parameters_stack.peek()).parameterlist =new ArrayList<Expression>();
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:337:2: ( ^( PARAMETERS ( parameter )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:337:5: ^( PARAMETERS ( parameter )+ )
            {
            match(input,PARAMETERS,FOLLOW_PARAMETERS_in_parameters2024); if (state.failed) return expressions;

            match(input, Token.DOWN, null); if (state.failed) return expressions;
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:337:18: ( parameter )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                switch ( input.LA(1) ) {
                case ATTRIBUTE:
                case CONSTANT:
                case EXTENSION_FUNCTION:
                case 70:
                case 73:
                case 74:
                case 76:
                case 78:
                case 94:
                case 100:
                case 105:
                case 115:
                case 120:
                case 133:
                    {
                    alt74=1;
                    }
                    break;

                }

                switch (alt74) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:337:19: parameter
            	    {
            	    pushFollow(FOLLOW_parameter_in_parameters2027);
            	    parameter130=parameter();

            	    state._fsp--;
            	    if (state.failed) return expressions;

            	    if ( state.backtracking==0 ) {((parameters_scope)parameters_stack.peek()).parameterlist.add(parameter130);}

            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return expressions;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return expressions;


            }

            if ( state.backtracking==0 ) {
            		expressions =((parameters_scope)parameters_stack.peek()).parameterlist.toArray(new Expression[((parameters_scope)parameters_stack.peek()).parameterlist.size()]);
            	}
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            parameters_stack.pop();
        }
        return expressions;
    }
    // $ANTLR end "parameters"



    // $ANTLR start "time"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:340:1: time returns [Expression expression] : constant ;
    public final Expression time() throws RecognitionException {
        Expression expression = null;


        Expression constant131 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:341:2: ( constant )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:341:4: constant
            {
            pushFollow(FOLLOW_constant_in_time2047);
            constant131=constant();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {expression =constant131;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "time"



    // $ANTLR start "parameter"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:344:1: parameter returns [Expression expression] : e1= expression ;
    public final Expression parameter() throws RecognitionException {
        Expression expression = null;


        Expression e1 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:345:2: (e1= expression )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:345:4: e1= expression
            {
            pushFollow(FOLLOW_expression_in_parameter2067);
            e1=expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {expression =e1;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "parameter"


    public static class collect_return extends TreeRuleReturnScope {
        public int startVal;
        public int endVal;
    };


    // $ANTLR start "collect"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:348:1: collect returns [int startVal , int endVal] : ( countStart ':' countEnd | countStart ':' | ':' countEnd | countStartAndEnd );
    public final SiddhiQLGrammarWalker.collect_return collect() throws RecognitionException {
        SiddhiQLGrammarWalker.collect_return retval = new SiddhiQLGrammarWalker.collect_return();
        retval.start = input.LT(1);


        int countStart132 =0;

        int countEnd133 =0;

        int countStart134 =0;

        int countEnd135 =0;

        int countStartAndEnd136 =0;



        		retval.startVal =0;
        		retval.endVal =-2;//UNLIMITED
        	
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:353:2: ( countStart ':' countEnd | countStart ':' | ':' countEnd | countStartAndEnd )
            int alt75=4;
            switch ( input.LA(1) ) {
            case POSITIVE_INT_VAL:
                {
                switch ( input.LA(2) ) {
                case 79:
                    {
                    switch ( input.LA(3) ) {
                    case POSITIVE_INT_VAL:
                        {
                        alt75=1;
                        }
                        break;
                    case UP:
                        {
                        alt75=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 3, input);

                        throw nvae;

                    }

                    }
                    break;
                case UP:
                    {
                    alt75=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;

                }

                }
                break;
            case 79:
                {
                alt75=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }

            switch (alt75) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:353:4: countStart ':' countEnd
                    {
                    pushFollow(FOLLOW_countStart_in_collect2089);
                    countStart132=countStart();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,79,FOLLOW_79_in_collect2091); if (state.failed) return retval;

                    pushFollow(FOLLOW_countEnd_in_collect2093);
                    countEnd133=countEnd();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.startVal =countStart132; retval.endVal =countEnd133;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:354:4: countStart ':'
                    {
                    pushFollow(FOLLOW_countStart_in_collect2101);
                    countStart134=countStart();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,79,FOLLOW_79_in_collect2103); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.startVal =countStart134;}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:355:4: ':' countEnd
                    {
                    match(input,79,FOLLOW_79_in_collect2112); if (state.failed) return retval;

                    pushFollow(FOLLOW_countEnd_in_collect2114);
                    countEnd135=countEnd();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.endVal =countEnd135;}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:356:4: countStartAndEnd
                    {
                    pushFollow(FOLLOW_countStartAndEnd_in_collect2125);
                    countStartAndEnd136=countStartAndEnd();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.startVal =countStartAndEnd136; retval.endVal =countStartAndEnd136;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "collect"



    // $ANTLR start "countStart"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:360:1: countStart returns [int value] : POSITIVE_INT_VAL ;
    public final int countStart() throws RecognitionException {
        int value = 0;


        CommonTree POSITIVE_INT_VAL137=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:361:2: ( POSITIVE_INT_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:361:3: POSITIVE_INT_VAL
            {
            POSITIVE_INT_VAL137=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_countStart2150); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Integer.parseInt((POSITIVE_INT_VAL137!=null?POSITIVE_INT_VAL137.getText():null));}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "countStart"



    // $ANTLR start "countEnd"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:364:1: countEnd returns [int value] : POSITIVE_INT_VAL ;
    public final int countEnd() throws RecognitionException {
        int value = 0;


        CommonTree POSITIVE_INT_VAL138=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:365:2: ( POSITIVE_INT_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:365:3: POSITIVE_INT_VAL
            {
            POSITIVE_INT_VAL138=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_countEnd2167); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Integer.parseInt((POSITIVE_INT_VAL138!=null?POSITIVE_INT_VAL138.getText():null));}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "countEnd"



    // $ANTLR start "countStartAndEnd"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:368:1: countStartAndEnd returns [int value] : POSITIVE_INT_VAL ;
    public final int countStartAndEnd() throws RecognitionException {
        int value = 0;


        CommonTree POSITIVE_INT_VAL139=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:369:2: ( POSITIVE_INT_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:369:3: POSITIVE_INT_VAL
            {
            POSITIVE_INT_VAL139=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_countStartAndEnd2185); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Integer.parseInt((POSITIVE_INT_VAL139!=null?POSITIVE_INT_VAL139.getText():null));}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "countStartAndEnd"



    // $ANTLR start "condition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:374:1: condition returns [Condition condition] : ^( CONDITION conditionExpression ) ;
    public final Condition condition() throws RecognitionException {
        Condition condition = null;


        Condition conditionExpression140 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:375:2: ( ^( CONDITION conditionExpression ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:375:4: ^( CONDITION conditionExpression )
            {
            match(input,CONDITION,FOLLOW_CONDITION_in_condition2208); if (state.failed) return condition;

            match(input, Token.DOWN, null); if (state.failed) return condition;
            pushFollow(FOLLOW_conditionExpression_in_condition2210);
            conditionExpression140=conditionExpression();

            state._fsp--;
            if (state.failed) return condition;

            if ( state.backtracking==0 ) {condition =conditionExpression140;}

            match(input, Token.UP, null); if (state.failed) return condition;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return condition;
    }
    // $ANTLR end "condition"



    // $ANTLR start "conditionExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:378:1: conditionExpression returns [Condition condition] : ( ^( 'or' c1= conditionExpression c2= conditionExpression ) | ^( 'and' c1= conditionExpression c2= conditionExpression ) | ^( 'in' c1= conditionExpression streamId ) | ^( compareOperation m1= expression m2= expression ) | ^( 'not' c= conditionExpression ) | ^( CONDITION_FUNCTION functionId ( extensionId )? ( parameters )? ) | boolVal );
    public final Condition conditionExpression() throws RecognitionException {
        Condition condition = null;


        Condition c1 =null;

        Condition c2 =null;

        Expression m1 =null;

        Expression m2 =null;

        Condition c =null;

        String streamId141 =null;

        Condition.Operator compareOperation142 =null;

        String functionId143 =null;

        String extensionId144 =null;

        Expression[] parameters145 =null;

        boolean boolVal146 =false;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:379:5: ( ^( 'or' c1= conditionExpression c2= conditionExpression ) | ^( 'and' c1= conditionExpression c2= conditionExpression ) | ^( 'in' c1= conditionExpression streamId ) | ^( compareOperation m1= expression m2= expression ) | ^( 'not' c= conditionExpression ) | ^( CONDITION_FUNCTION functionId ( extensionId )? ( parameters )? ) | boolVal )
            int alt78=7;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt78=1;
                }
                break;
            case 92:
                {
                alt78=2;
                }
                break;
            case 111:
                {
                alt78=3;
                }
                break;
            case 68:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 96:
            case 114:
                {
                alt78=4;
                }
                break;
            case 121:
                {
                alt78=5;
                }
                break;
            case CONDITION_FUNCTION:
                {
                alt78=6;
                }
                break;
            case BOOL_VAL:
                {
                alt78=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return condition;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }

            switch (alt78) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:379:7: ^( 'or' c1= conditionExpression c2= conditionExpression )
                    {
                    match(input,123,FOLLOW_123_in_conditionExpression2232); if (state.failed) return condition;

                    match(input, Token.DOWN, null); if (state.failed) return condition;
                    pushFollow(FOLLOW_conditionExpression_in_conditionExpression2236);
                    c1=conditionExpression();

                    state._fsp--;
                    if (state.failed) return condition;

                    pushFollow(FOLLOW_conditionExpression_in_conditionExpression2240);
                    c2=conditionExpression();

                    state._fsp--;
                    if (state.failed) return condition;

                    match(input, Token.UP, null); if (state.failed) return condition;


                    if ( state.backtracking==0 ) {condition =Condition.or(c1,c2);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:380:7: ^( 'and' c1= conditionExpression c2= conditionExpression )
                    {
                    match(input,92,FOLLOW_92_in_conditionExpression2253); if (state.failed) return condition;

                    match(input, Token.DOWN, null); if (state.failed) return condition;
                    pushFollow(FOLLOW_conditionExpression_in_conditionExpression2257);
                    c1=conditionExpression();

                    state._fsp--;
                    if (state.failed) return condition;

                    pushFollow(FOLLOW_conditionExpression_in_conditionExpression2261);
                    c2=conditionExpression();

                    state._fsp--;
                    if (state.failed) return condition;

                    match(input, Token.UP, null); if (state.failed) return condition;


                    if ( state.backtracking==0 ) {condition =Condition.and(c1,c2);}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:381:7: ^( 'in' c1= conditionExpression streamId )
                    {
                    match(input,111,FOLLOW_111_in_conditionExpression2274); if (state.failed) return condition;

                    match(input, Token.DOWN, null); if (state.failed) return condition;
                    pushFollow(FOLLOW_conditionExpression_in_conditionExpression2278);
                    c1=conditionExpression();

                    state._fsp--;
                    if (state.failed) return condition;

                    pushFollow(FOLLOW_streamId_in_conditionExpression2280);
                    streamId141=streamId();

                    state._fsp--;
                    if (state.failed) return condition;

                    match(input, Token.UP, null); if (state.failed) return condition;


                    if ( state.backtracking==0 ) {condition =Condition.in(c1,streamId141);}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:382:7: ^( compareOperation m1= expression m2= expression )
                    {
                    pushFollow(FOLLOW_compareOperation_in_conditionExpression2310);
                    compareOperation142=compareOperation();

                    state._fsp--;
                    if (state.failed) return condition;

                    match(input, Token.DOWN, null); if (state.failed) return condition;
                    pushFollow(FOLLOW_expression_in_conditionExpression2314);
                    m1=expression();

                    state._fsp--;
                    if (state.failed) return condition;

                    pushFollow(FOLLOW_expression_in_conditionExpression2318);
                    m2=expression();

                    state._fsp--;
                    if (state.failed) return condition;

                    match(input, Token.UP, null); if (state.failed) return condition;


                    if ( state.backtracking==0 ) {condition =Condition.compare(m1,compareOperation142,m2);}

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:383:7: ^( 'not' c= conditionExpression )
                    {
                    match(input,121,FOLLOW_121_in_conditionExpression2338); if (state.failed) return condition;

                    match(input, Token.DOWN, null); if (state.failed) return condition;
                    pushFollow(FOLLOW_conditionExpression_in_conditionExpression2342);
                    c=conditionExpression();

                    state._fsp--;
                    if (state.failed) return condition;

                    match(input, Token.UP, null); if (state.failed) return condition;


                    if ( state.backtracking==0 ) {condition =Condition.not(c);}

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:384:7: ^( CONDITION_FUNCTION functionId ( extensionId )? ( parameters )? )
                    {
                    match(input,CONDITION_FUNCTION,FOLLOW_CONDITION_FUNCTION_in_conditionExpression2361); if (state.failed) return condition;

                    match(input, Token.DOWN, null); if (state.failed) return condition;
                    pushFollow(FOLLOW_functionId_in_conditionExpression2364);
                    functionId143=functionId();

                    state._fsp--;
                    if (state.failed) return condition;

                    if ( state.backtracking==0 ) {condition =new FunctionCondition(functionId143,null);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:385:17: ( extensionId )?
                    int alt76=2;
                    switch ( input.LA(1) ) {
                        case ID:
                        case ID_QUOTES:
                            {
                            alt76=1;
                            }
                            break;
                    }

                    switch (alt76) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:385:18: extensionId
                            {
                            pushFollow(FOLLOW_extensionId_in_conditionExpression2385);
                            extensionId144=extensionId();

                            state._fsp--;
                            if (state.failed) return condition;

                            if ( state.backtracking==0 ) {condition =new ConditionExtension(extensionId144,functionId143,null);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:386:17: ( parameters )?
                    int alt77=2;
                    switch ( input.LA(1) ) {
                        case PARAMETERS:
                            {
                            alt77=1;
                            }
                            break;
                    }

                    switch (alt77) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:386:18: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_conditionExpression2408);
                            parameters145=parameters();

                            state._fsp--;
                            if (state.failed) return condition;

                            if ( state.backtracking==0 ) {((FunctionCondition)condition).setParameters(parameters145);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return condition;


                    }
                    break;
                case 7 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:387:6: boolVal
                    {
                    pushFollow(FOLLOW_boolVal_in_conditionExpression2420);
                    boolVal146=boolVal();

                    state._fsp--;
                    if (state.failed) return condition;

                    if ( state.backtracking==0 ) {condition =Condition.bool(Expression.value(boolVal146));}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return condition;
    }
    // $ANTLR end "conditionExpression"



    // $ANTLR start "expression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:390:1: expression returns [Expression expression] : ( ^( '%' e1= expression e2= expression ) | ^( '/' e1= expression e2= expression ) | ^( '*' e1= expression e2= expression ) | ^( '-' e1= expression e2= expression ) | ^( '+' e1= expression e2= expression ) | valueExpression );
    public final Expression expression() throws RecognitionException {
        Expression expression = null;


        Expression e1 =null;

        Expression e2 =null;

        Expression valueExpression147 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:391:2: ( ^( '%' e1= expression e2= expression ) | ^( '/' e1= expression e2= expression ) | ^( '*' e1= expression e2= expression ) | ^( '-' e1= expression e2= expression ) | ^( '+' e1= expression e2= expression ) | valueExpression )
            int alt79=6;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt79=1;
                }
                break;
            case 78:
                {
                alt79=2;
                }
                break;
            case 73:
                {
                alt79=3;
                }
                break;
            case 76:
                {
                alt79=4;
                }
                break;
            case 74:
                {
                alt79=5;
                }
                break;
            case ATTRIBUTE:
            case CONSTANT:
            case EXTENSION_FUNCTION:
            case 94:
            case 100:
            case 105:
            case 115:
            case 120:
            case 133:
                {
                alt79=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:391:4: ^( '%' e1= expression e2= expression )
                    {
                    match(input,70,FOLLOW_70_in_expression2453); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_expression_in_expression2457);
                    e1=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    pushFollow(FOLLOW_expression_in_expression2461);
                    e2=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.mod(e1,e2);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:392:7: ^( '/' e1= expression e2= expression )
                    {
                    match(input,78,FOLLOW_78_in_expression2473); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_expression_in_expression2477);
                    e1=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    pushFollow(FOLLOW_expression_in_expression2481);
                    e2=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.divide(e1,e2);}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:393:7: ^( '*' e1= expression e2= expression )
                    {
                    match(input,73,FOLLOW_73_in_expression2493); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_expression_in_expression2497);
                    e1=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    pushFollow(FOLLOW_expression_in_expression2501);
                    e2=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.multiply(e1,e2);}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:394:7: ^( '-' e1= expression e2= expression )
                    {
                    match(input,76,FOLLOW_76_in_expression2513); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_expression_in_expression2517);
                    e1=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    pushFollow(FOLLOW_expression_in_expression2521);
                    e2=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.minus(e1,e2);}

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:395:7: ^( '+' e1= expression e2= expression )
                    {
                    match(input,74,FOLLOW_74_in_expression2533); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_expression_in_expression2537);
                    e1=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    pushFollow(FOLLOW_expression_in_expression2541);
                    e2=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.add(e1,e2);}

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:396:6: valueExpression
                    {
                    pushFollow(FOLLOW_valueExpression_in_expression2551);
                    valueExpression147=valueExpression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =valueExpression147;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "expression"



    // $ANTLR start "valueExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:399:1: valueExpression returns [Expression expression] : ( constant | type | attributeVariable | ^( EXTENSION_FUNCTION functionId ( extensionId )? ( parameters )? ) );
    public final Expression valueExpression() throws RecognitionException {
        Expression expression = null;


        Expression constant148 =null;

        Attribute.Type type149 =null;

        Variable attributeVariable150 =null;

        String functionId151 =null;

        String extensionId152 =null;

        Expression[] parameters153 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:400:5: ( constant | type | attributeVariable | ^( EXTENSION_FUNCTION functionId ( extensionId )? ( parameters )? ) )
            int alt82=4;
            switch ( input.LA(1) ) {
            case CONSTANT:
                {
                alt82=1;
                }
                break;
            case 94:
            case 100:
            case 105:
            case 115:
            case 120:
            case 133:
                {
                alt82=2;
                }
                break;
            case ATTRIBUTE:
                {
                alt82=3;
                }
                break;
            case EXTENSION_FUNCTION:
                {
                alt82=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }

            switch (alt82) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:400:6: constant
                    {
                    pushFollow(FOLLOW_constant_in_valueExpression2580);
                    constant148=constant();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =constant148;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:401:6: type
                    {
                    pushFollow(FOLLOW_type_in_valueExpression2592);
                    type149=type();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =Expression.type(type149);}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:402:6: attributeVariable
                    {
                    pushFollow(FOLLOW_attributeVariable_in_valueExpression2608);
                    attributeVariable150=attributeVariable();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =attributeVariable150;}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:403:6: ^( EXTENSION_FUNCTION functionId ( extensionId )? ( parameters )? )
                    {
                    match(input,EXTENSION_FUNCTION,FOLLOW_EXTENSION_FUNCTION_in_valueExpression2619); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_functionId_in_valueExpression2621);
                    functionId151=functionId();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new FunctionExpression(functionId151, null);}

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:404:17: ( extensionId )?
                    int alt80=2;
                    switch ( input.LA(1) ) {
                        case ID:
                        case ID_QUOTES:
                            {
                            alt80=1;
                            }
                            break;
                    }

                    switch (alt80) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:404:18: extensionId
                            {
                            pushFollow(FOLLOW_extensionId_in_valueExpression2642);
                            extensionId152=extensionId();

                            state._fsp--;
                            if (state.failed) return expression;

                            if ( state.backtracking==0 ) {expression =new ExpressionExtension(extensionId152,functionId151, null);}

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:405:17: ( parameters )?
                    int alt81=2;
                    switch ( input.LA(1) ) {
                        case PARAMETERS:
                            {
                            alt81=1;
                            }
                            break;
                    }

                    switch (alt81) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:405:18: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_valueExpression2665);
                            parameters153=parameters();

                            state._fsp--;
                            if (state.failed) return expression;

                            if ( state.backtracking==0 ) {((FunctionExpression)expression).setParameters(parameters153);}

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return expression;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "valueExpression"



    // $ANTLR start "constant"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:411:1: constant returns [Expression expression] : ( ^( CONSTANT intVal ) | ^( CONSTANT longVal ) | ^( CONSTANT floatVal ) | ^( CONSTANT doubleVal ) | ^( CONSTANT boolVal ) | ^( CONSTANT stringVal ) | ^( CONSTANT timeExpr ) );
    public final Expression constant() throws RecognitionException {
        Expression expression = null;


        int intVal154 =0;

        long longVal155 =0;

        float floatVal156 =0.0f;

        double doubleVal157 =0.0;

        boolean boolVal158 =false;

        String stringVal159 =null;

        long timeExpr160 =0;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:412:2: ( ^( CONSTANT intVal ) | ^( CONSTANT longVal ) | ^( CONSTANT floatVal ) | ^( CONSTANT doubleVal ) | ^( CONSTANT boolVal ) | ^( CONSTANT stringVal ) | ^( CONSTANT timeExpr ) )
            int alt83=7;
            switch ( input.LA(1) ) {
            case CONSTANT:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case SIGNED_VAL:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            switch ( input.LA(5) ) {
                            case POSITIVE_INT_VAL:
                                {
                                alt83=1;
                                }
                                break;
                            case POSITIVE_LONG_VAL:
                                {
                                alt83=2;
                                }
                                break;
                            case POSITIVE_FLOAT_VAL:
                                {
                                alt83=3;
                                }
                                break;
                            case POSITIVE_DOUBLE_VAL:
                                {
                                alt83=4;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return expression;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 83, 7, input);

                                throw nvae;

                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return expression;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 83, 3, input);

                            throw nvae;

                        }

                        }
                        break;
                    case BOOL_VAL:
                        {
                        alt83=5;
                        }
                        break;
                    case STRING_VAL:
                        {
                        alt83=6;
                        }
                        break;
                    case TIME_EXP:
                        {
                        alt83=7;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return expression;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 2, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return expression;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }

            switch (alt83) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:412:4: ^( CONSTANT intVal )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_constant2693); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_intVal_in_constant2695);
                    intVal154=intVal();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.value(intVal154);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:413:4: ^( CONSTANT longVal )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_constant2707); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_longVal_in_constant2709);
                    longVal155=longVal();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.value(longVal155);}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:414:4: ^( CONSTANT floatVal )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_constant2720); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_floatVal_in_constant2722);
                    floatVal156=floatVal();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.value(floatVal156);}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:415:4: ^( CONSTANT doubleVal )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_constant2733); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_doubleVal_in_constant2735);
                    doubleVal157=doubleVal();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.value(doubleVal157);}

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:416:4: ^( CONSTANT boolVal )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_constant2745); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_boolVal_in_constant2747);
                    boolVal158=boolVal();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.value(boolVal158);}

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:417:4: ^( CONSTANT stringVal )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_constant2758); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_stringVal_in_constant2760);
                    stringVal159=stringVal();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.value(stringVal159);}

                    }
                    break;
                case 7 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:418:4: ^( CONSTANT timeExpr )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_constant2770); if (state.failed) return expression;

                    match(input, Token.DOWN, null); if (state.failed) return expression;
                    pushFollow(FOLLOW_timeExpr_in_constant2772);
                    timeExpr160=timeExpr();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input, Token.UP, null); if (state.failed) return expression;


                    if ( state.backtracking==0 ) {expression =Expression.value(timeExpr160);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "constant"



    // $ANTLR start "timeExpr"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:421:2: timeExpr returns [long value] : ^( TIME_EXP ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? ) ;
    public final long timeExpr() throws RecognitionException {
        long value = 0;


        long yearValue161 =0;

        long monthValue162 =0;

        long weekValue163 =0;

        long dayValue164 =0;

        long hourValue165 =0;

        long minuteValue166 =0;

        long secondValue167 =0;

        long milliSecondValue168 =0;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:2: ( ^( TIME_EXP ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:3: ^( TIME_EXP ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? )
            {
            match(input,TIME_EXP,FOLLOW_TIME_EXP_in_timeExpr2796); if (state.failed) return value;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return value;
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:14: ( yearValue )?
                int alt84=2;
                switch ( input.LA(1) ) {
                    case YEAR:
                        {
                        alt84=1;
                        }
                        break;
                }

                switch (alt84) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:15: yearValue
                        {
                        pushFollow(FOLLOW_yearValue_in_timeExpr2799);
                        yearValue161=yearValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value =  yearValue161;}

                        }
                        break;

                }


                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:59: ( monthValue )?
                int alt85=2;
                switch ( input.LA(1) ) {
                    case MONTH:
                        {
                        alt85=1;
                        }
                        break;
                }

                switch (alt85) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:60: monthValue
                        {
                        pushFollow(FOLLOW_monthValue_in_timeExpr2808);
                        monthValue162=monthValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value =  monthValue162;}

                        }
                        break;

                }


                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:106: ( weekValue )?
                int alt86=2;
                switch ( input.LA(1) ) {
                    case WEEK:
                        {
                        alt86=1;
                        }
                        break;
                }

                switch (alt86) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:107: weekValue
                        {
                        pushFollow(FOLLOW_weekValue_in_timeExpr2817);
                        weekValue163=weekValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value =  weekValue163;}

                        }
                        break;

                }


                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:151: ( dayValue )?
                int alt87=2;
                switch ( input.LA(1) ) {
                    case DAY:
                        {
                        alt87=1;
                        }
                        break;
                }

                switch (alt87) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:152: dayValue
                        {
                        pushFollow(FOLLOW_dayValue_in_timeExpr2826);
                        dayValue164=dayValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value =  dayValue164;}

                        }
                        break;

                }


                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:195: ( hourValue )?
                int alt88=2;
                switch ( input.LA(1) ) {
                    case HOUR:
                        {
                        alt88=1;
                        }
                        break;
                }

                switch (alt88) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:196: hourValue
                        {
                        pushFollow(FOLLOW_hourValue_in_timeExpr2836);
                        hourValue165=hourValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value +=  hourValue165;}

                        }
                        break;

                }


                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:241: ( minuteValue )?
                int alt89=2;
                switch ( input.LA(1) ) {
                    case MIN:
                        {
                        alt89=1;
                        }
                        break;
                }

                switch (alt89) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:422:242: minuteValue
                        {
                        pushFollow(FOLLOW_minuteValue_in_timeExpr2845);
                        minuteValue166=minuteValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value +=  minuteValue166;}

                        }
                        break;

                }


                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:423:3: ( secondValue )?
                int alt90=2;
                switch ( input.LA(1) ) {
                    case SEC:
                        {
                        alt90=1;
                        }
                        break;
                }

                switch (alt90) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:423:4: secondValue
                        {
                        pushFollow(FOLLOW_secondValue_in_timeExpr2856);
                        secondValue167=secondValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value +=  secondValue167;}

                        }
                        break;

                }


                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:423:53: ( milliSecondValue )?
                int alt91=2;
                switch ( input.LA(1) ) {
                    case MILLI_SEC:
                        {
                        alt91=1;
                        }
                        break;
                }

                switch (alt91) {
                    case 1 :
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:423:54: milliSecondValue
                        {
                        pushFollow(FOLLOW_milliSecondValue_in_timeExpr2865);
                        milliSecondValue168=milliSecondValue();

                        state._fsp--;
                        if (state.failed) return value;

                        if ( state.backtracking==0 ) {value +=  milliSecondValue168;}

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return value;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "timeExpr"



    // $ANTLR start "yearValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:426:1: yearValue returns [long value] : ^( YEAR a= POSITIVE_INT_VAL ) ;
    public final long yearValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:427:2: ( ^( YEAR a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:427:4: ^( YEAR a= POSITIVE_INT_VAL )
            {
            match(input,YEAR,FOLLOW_YEAR_in_yearValue2889); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_yearValue2894); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =  Time.year(Integer.parseInt((a!=null?a.getText():null))).value();}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "yearValue"



    // $ANTLR start "monthValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:430:1: monthValue returns [long value] : ^( MONTH a= POSITIVE_INT_VAL ) ;
    public final long monthValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:431:2: ( ^( MONTH a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:431:4: ^( MONTH a= POSITIVE_INT_VAL )
            {
            match(input,MONTH,FOLLOW_MONTH_in_monthValue2916); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_monthValue2922); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =  Time.month(Integer.parseInt((a!=null?a.getText():null))).value();}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "monthValue"



    // $ANTLR start "weekValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:434:1: weekValue returns [long value] : ^( WEEK a= POSITIVE_INT_VAL ) ;
    public final long weekValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:435:2: ( ^( WEEK a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:435:4: ^( WEEK a= POSITIVE_INT_VAL )
            {
            match(input,WEEK,FOLLOW_WEEK_in_weekValue2942); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_weekValue2948); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =  Time.week(Integer.parseInt((a!=null?a.getText():null))).value();}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "weekValue"



    // $ANTLR start "dayValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:438:1: dayValue returns [long value] : ^( DAY a= POSITIVE_INT_VAL ) ;
    public final long dayValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:439:2: ( ^( DAY a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:439:4: ^( DAY a= POSITIVE_INT_VAL )
            {
            match(input,DAY,FOLLOW_DAY_in_dayValue2972); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_dayValue2978); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =  Time.day(Integer.parseInt((a!=null?a.getText():null))).value();}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dayValue"



    // $ANTLR start "hourValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:442:1: hourValue returns [long value] : ^( HOUR a= POSITIVE_INT_VAL ) ;
    public final long hourValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:443:2: ( ^( HOUR a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:443:4: ^( HOUR a= POSITIVE_INT_VAL )
            {
            match(input,HOUR,FOLLOW_HOUR_in_hourValue3001); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_hourValue3007); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =  Time.hour(Integer.parseInt((a!=null?a.getText():null))).value();}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "hourValue"



    // $ANTLR start "minuteValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:446:1: minuteValue returns [long value] : ^( MIN a= POSITIVE_INT_VAL ) ;
    public final long minuteValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:447:2: ( ^( MIN a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:447:4: ^( MIN a= POSITIVE_INT_VAL )
            {
            match(input,MIN,FOLLOW_MIN_in_minuteValue3029); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_minuteValue3035); if (state.failed) return value;

            if ( state.backtracking==0 ) {value = Time.minute(Integer.parseInt((a!=null?a.getText():null))).value();}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "minuteValue"



    // $ANTLR start "secondValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:450:1: secondValue returns [long value] : ^( SEC a= POSITIVE_INT_VAL ) ;
    public final long secondValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:451:2: ( ^( SEC a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:451:4: ^( SEC a= POSITIVE_INT_VAL )
            {
            match(input,SEC,FOLLOW_SEC_in_secondValue3056); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_secondValue3061); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =  Time.sec(Integer.parseInt((a!=null?a.getText():null))).value(); }

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "secondValue"



    // $ANTLR start "milliSecondValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:454:1: milliSecondValue returns [long value] : ^( MILLI_SEC a= POSITIVE_INT_VAL ) ;
    public final long milliSecondValue() throws RecognitionException {
        long value = 0;


        CommonTree a=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:455:2: ( ^( MILLI_SEC a= POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:455:4: ^( MILLI_SEC a= POSITIVE_INT_VAL )
            {
            match(input,MILLI_SEC,FOLLOW_MILLI_SEC_in_milliSecondValue3084); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            a=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_milliSecondValue3090); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =  Time.milliSec(Integer.parseInt((a!=null?a.getText():null))).value();}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "milliSecondValue"



    // $ANTLR start "partitionId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:458:1: partitionId returns [String value] : id ;
    public final String partitionId() throws RecognitionException {
        String value = null;


        String id169 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:459:2: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:459:4: id
            {
            pushFollow(FOLLOW_id_in_partitionId3109);
            id169=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id169;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "partitionId"



    // $ANTLR start "streamId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:462:1: streamId returns [String value] : id ;
    public final String streamId() throws RecognitionException {
        String value = null;


        String id170 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:463:2: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:463:4: id
            {
            pushFollow(FOLLOW_id_in_streamId3126);
            id170=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id170;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "streamId"



    // $ANTLR start "attributeVariable"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:466:1: attributeVariable returns [Variable variable] : ( streamPositionAttributeName | streamAttributeName | attributeName );
    public final Variable attributeVariable() throws RecognitionException {
        Variable variable = null;


        SiddhiQLGrammarWalker.streamPositionAttributeName_return streamPositionAttributeName171 =null;

        SiddhiQLGrammarWalker.streamAttributeName_return streamAttributeName172 =null;

        String attributeName173 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:467:2: ( streamPositionAttributeName | streamAttributeName | attributeName )
            int alt92=3;
            switch ( input.LA(1) ) {
            case ATTRIBUTE:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case ID:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            alt92=1;
                            }
                            break;
                        case ID:
                        case ID_QUOTES:
                            {
                            alt92=2;
                            }
                            break;
                        case UP:
                            {
                            alt92=3;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return variable;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 92, 3, input);

                            throw nvae;

                        }

                        }
                        break;
                    case ID_QUOTES:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            alt92=1;
                            }
                            break;
                        case ID:
                        case ID_QUOTES:
                            {
                            alt92=2;
                            }
                            break;
                        case UP:
                            {
                            alt92=3;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return variable;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 92, 4, input);

                            throw nvae;

                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return variable;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 92, 2, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return variable;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 92, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return variable;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }

            switch (alt92) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:467:3: streamPositionAttributeName
                    {
                    pushFollow(FOLLOW_streamPositionAttributeName_in_attributeVariable3143);
                    streamPositionAttributeName171=streamPositionAttributeName();

                    state._fsp--;
                    if (state.failed) return variable;

                    if ( state.backtracking==0 ) {variable =Expression.variable((streamPositionAttributeName171!=null?streamPositionAttributeName171.stream:null),(streamPositionAttributeName171!=null?streamPositionAttributeName171.position:0),(streamPositionAttributeName171!=null?streamPositionAttributeName171.attribute:null));}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:468:6: streamAttributeName
                    {
                    pushFollow(FOLLOW_streamAttributeName_in_attributeVariable3152);
                    streamAttributeName172=streamAttributeName();

                    state._fsp--;
                    if (state.failed) return variable;

                    if ( state.backtracking==0 ) {variable =Expression.variable((streamAttributeName172!=null?streamAttributeName172.stream:null),(streamAttributeName172!=null?streamAttributeName172.attribute:null));}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:469:6: attributeName
                    {
                    pushFollow(FOLLOW_attributeName_in_attributeVariable3164);
                    attributeName173=attributeName();

                    state._fsp--;
                    if (state.failed) return variable;

                    if ( state.backtracking==0 ) {variable =Expression.variable(attributeName173);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return variable;
    }
    // $ANTLR end "attributeVariable"


    public static class streamPositionAttributeName_return extends TreeRuleReturnScope {
        public String stream;
        public int position;
        public String attribute;
    };


    // $ANTLR start "streamPositionAttributeName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:472:1: streamPositionAttributeName returns [String stream, int position, String attribute] : ( ^( ATTRIBUTE ^( streamId POSITIVE_INT_VAL ) id ) | ^( ATTRIBUTE ^( streamId LAST ) id ) );
    public final SiddhiQLGrammarWalker.streamPositionAttributeName_return streamPositionAttributeName() throws RecognitionException {
        SiddhiQLGrammarWalker.streamPositionAttributeName_return retval = new SiddhiQLGrammarWalker.streamPositionAttributeName_return();
        retval.start = input.LT(1);


        CommonTree POSITIVE_INT_VAL175=null;
        String streamId174 =null;

        String id176 =null;

        String streamId177 =null;

        String id178 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:473:2: ( ^( ATTRIBUTE ^( streamId POSITIVE_INT_VAL ) id ) | ^( ATTRIBUTE ^( streamId LAST ) id ) )
            int alt93=2;
            switch ( input.LA(1) ) {
            case ATTRIBUTE:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case ID:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            switch ( input.LA(5) ) {
                            case POSITIVE_INT_VAL:
                                {
                                alt93=1;
                                }
                                break;
                            case LAST:
                                {
                                alt93=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 93, 5, input);

                                throw nvae;

                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 93, 3, input);

                            throw nvae;

                        }

                        }
                        break;
                    case ID_QUOTES:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            switch ( input.LA(5) ) {
                            case POSITIVE_INT_VAL:
                                {
                                alt93=1;
                                }
                                break;
                            case LAST:
                                {
                                alt93=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 93, 5, input);

                                throw nvae;

                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 93, 4, input);

                            throw nvae;

                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 2, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 93, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;

            }

            switch (alt93) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:473:4: ^( ATTRIBUTE ^( streamId POSITIVE_INT_VAL ) id )
                    {
                    match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_streamPositionAttributeName3187); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_streamId_in_streamPositionAttributeName3190);
                    streamId174=streamId();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.stream =streamId174;}

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    POSITIVE_INT_VAL175=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_streamPositionAttributeName3194); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.position =Integer.parseInt((POSITIVE_INT_VAL175!=null?POSITIVE_INT_VAL175.getText():null));}

                    match(input, Token.UP, null); if (state.failed) return retval;


                    pushFollow(FOLLOW_id_in_streamPositionAttributeName3199);
                    id176=id();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.attribute =id176;}

                    match(input, Token.UP, null); if (state.failed) return retval;


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:474:4: ^( ATTRIBUTE ^( streamId LAST ) id )
                    {
                    match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_streamPositionAttributeName3209); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_streamId_in_streamPositionAttributeName3212);
                    streamId177=streamId();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.stream =streamId177;}

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,LAST,FOLLOW_LAST_in_streamPositionAttributeName3216); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.position =SiddhiConstants.LAST;}

                    match(input, Token.UP, null); if (state.failed) return retval;


                    pushFollow(FOLLOW_id_in_streamPositionAttributeName3221);
                    id178=id();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.attribute =id178;}

                    match(input, Token.UP, null); if (state.failed) return retval;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "streamPositionAttributeName"


    public static class streamAttributeName_return extends TreeRuleReturnScope {
        public String stream;
        public String attribute;
    };


    // $ANTLR start "streamAttributeName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:477:1: streamAttributeName returns [String stream, String attribute] : ^( ATTRIBUTE ( streamId ) id ) ;
    public final SiddhiQLGrammarWalker.streamAttributeName_return streamAttributeName() throws RecognitionException {
        SiddhiQLGrammarWalker.streamAttributeName_return retval = new SiddhiQLGrammarWalker.streamAttributeName_return();
        retval.start = input.LT(1);


        String streamId179 =null;

        String id180 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:478:2: ( ^( ATTRIBUTE ( streamId ) id ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:478:3: ^( ATTRIBUTE ( streamId ) id )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_streamAttributeName3240); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:478:16: ( streamId )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:478:17: streamId
            {
            pushFollow(FOLLOW_streamId_in_streamAttributeName3243);
            streamId179=streamId();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {retval.stream =streamId179;}

            }


            pushFollow(FOLLOW_id_in_streamAttributeName3248);
            id180=id();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {retval.attribute =id180;}

            match(input, Token.UP, null); if (state.failed) return retval;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "streamAttributeName"



    // $ANTLR start "attributeName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:481:1: attributeName returns [String value] : ^( ATTRIBUTE id ) ;
    public final String attributeName() throws RecognitionException {
        String value = null;


        String id181 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:482:2: ( ^( ATTRIBUTE id ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:482:3: ^( ATTRIBUTE id )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_attributeName3268); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            pushFollow(FOLLOW_id_in_attributeName3270);
            id181=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id181;}

            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "attributeName"



    // $ANTLR start "join"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:485:1: join returns [JoinStream.Type type] : ( ^( 'join' ^( 'outer' 'left' ) ) | ^( 'join' ^( 'outer' 'right' ) ) | ^( 'join' ^( 'outer' 'full' ) ) | ^( 'join' 'inner' ) );
    public final JoinStream.Type join() throws RecognitionException {
        JoinStream.Type type = null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:486:2: ( ^( 'join' ^( 'outer' 'left' ) ) | ^( 'join' ^( 'outer' 'right' ) ) | ^( 'join' ^( 'outer' 'full' ) ) | ^( 'join' 'inner' ) )
            int alt94=4;
            switch ( input.LA(1) ) {
            case 117:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case 124:
                        {
                        switch ( input.LA(4) ) {
                        case DOWN:
                            {
                            switch ( input.LA(5) ) {
                            case 119:
                                {
                                alt94=1;
                                }
                                break;
                            case 129:
                                {
                                alt94=2;
                                }
                                break;
                            case 108:
                                {
                                alt94=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return type;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 94, 5, input);

                                throw nvae;

                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return type;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 94, 3, input);

                            throw nvae;

                        }

                        }
                        break;
                    case 112:
                        {
                        alt94=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return type;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 94, 2, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return type;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 94, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }

            switch (alt94) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:486:5: ^( 'join' ^( 'outer' 'left' ) )
                    {
                    match(input,117,FOLLOW_117_in_join3291); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    match(input,124,FOLLOW_124_in_join3294); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    match(input,119,FOLLOW_119_in_join3296); if (state.failed) return type;

                    match(input, Token.UP, null); if (state.failed) return type;


                    match(input, Token.UP, null); if (state.failed) return type;


                    if ( state.backtracking==0 ) {type =JoinStream.Type.LEFT_OUTER_JOIN;}

                    if ( state.backtracking==0 ) {System.err.println("Left outer join not yet supported!");}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:487:5: ^( 'join' ^( 'outer' 'right' ) )
                    {
                    match(input,117,FOLLOW_117_in_join3310); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    match(input,124,FOLLOW_124_in_join3313); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    match(input,129,FOLLOW_129_in_join3315); if (state.failed) return type;

                    match(input, Token.UP, null); if (state.failed) return type;


                    match(input, Token.UP, null); if (state.failed) return type;


                    if ( state.backtracking==0 ) {type =JoinStream.Type.RIGHT_OUTER_JOIN;}

                    if ( state.backtracking==0 ) {System.err.println("Right outer join not yet supported!");}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:488:5: ^( 'join' ^( 'outer' 'full' ) )
                    {
                    match(input,117,FOLLOW_117_in_join3329); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    match(input,124,FOLLOW_124_in_join3332); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    match(input,108,FOLLOW_108_in_join3334); if (state.failed) return type;

                    match(input, Token.UP, null); if (state.failed) return type;


                    match(input, Token.UP, null); if (state.failed) return type;


                    if ( state.backtracking==0 ) {type =JoinStream.Type.FULL_OUTER_JOIN;}

                    if ( state.backtracking==0 ) {System.err.println("Full outer join not yet supported!");}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:489:4: ^( 'join' 'inner' )
                    {
                    match(input,117,FOLLOW_117_in_join3346); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    match(input,112,FOLLOW_112_in_join3348); if (state.failed) return type;

                    match(input, Token.UP, null); if (state.failed) return type;


                    if ( state.backtracking==0 ) {type =JoinStream.Type.INNER_JOIN;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "join"



    // $ANTLR start "compareOperation"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:492:1: compareOperation returns [Condition.Operator operator] : ( '==' | '!=' | '<=' | '>=' | '<' | '>' | 'contains' | 'instanceof' );
    public final Condition.Operator compareOperation() throws RecognitionException {
        Condition.Operator operator = null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:493:2: ( '==' | '!=' | '<=' | '>=' | '<' | '>' | 'contains' | 'instanceof' )
            int alt95=8;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt95=1;
                }
                break;
            case 68:
                {
                alt95=2;
                }
                break;
            case 82:
                {
                alt95=3;
                }
                break;
            case 86:
                {
                alt95=4;
                }
                break;
            case 81:
                {
                alt95=5;
                }
                break;
            case 85:
                {
                alt95=6;
                }
                break;
            case 96:
                {
                alt95=7;
                }
                break;
            case 114:
                {
                alt95=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return operator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;

            }

            switch (alt95) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:493:3: '=='
                    {
                    match(input,84,FOLLOW_84_in_compareOperation3368); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.EQUAL;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:494:3: '!='
                    {
                    match(input,68,FOLLOW_68_in_compareOperation3377); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.NOT_EQUAL;}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:495:3: '<='
                    {
                    match(input,82,FOLLOW_82_in_compareOperation3385); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.LESS_THAN_EQUAL;}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:496:3: '>='
                    {
                    match(input,86,FOLLOW_86_in_compareOperation3392); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.GREATER_THAN_EQUAL;}

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:497:3: '<'
                    {
                    match(input,81,FOLLOW_81_in_compareOperation3400); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.LESS_THAN;}

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:498:3: '>'
                    {
                    match(input,85,FOLLOW_85_in_compareOperation3408); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.GREATER_THAN;}

                    }
                    break;
                case 7 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:499:3: 'contains'
                    {
                    match(input,96,FOLLOW_96_in_compareOperation3417); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.CONTAINS;}

                    }
                    break;
                case 8 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:500:3: 'instanceof'
                    {
                    match(input,114,FOLLOW_114_in_compareOperation3423); if (state.failed) return operator;

                    if ( state.backtracking==0 ) {operator =Condition.Operator.INSTANCE_OF;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return operator;
    }
    // $ANTLR end "compareOperation"



    // $ANTLR start "id"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:503:1: id returns [String value] : ( ID | ID_QUOTES );
    public final String id() throws RecognitionException {
        String value = null;


        CommonTree ID182=null;
        CommonTree ID_QUOTES183=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:504:5: ( ID | ID_QUOTES )
            int alt96=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt96=1;
                }
                break;
            case ID_QUOTES:
                {
                alt96=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }

            switch (alt96) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:504:7: ID
                    {
                    ID182=(CommonTree)match(input,ID,FOLLOW_ID_in_id3444); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =(ID182!=null?ID182.getText():null);}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:505:7: ID_QUOTES
                    {
                    ID_QUOTES183=(CommonTree)match(input,ID_QUOTES,FOLLOW_ID_QUOTES_in_id3454); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =(ID_QUOTES183!=null?ID_QUOTES183.getText():null);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "id"



    // $ANTLR start "intVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:508:1: intVal returns [int value] : ^( SIGNED_VAL POSITIVE_INT_VAL ( '-' )? ) ;
    public final int intVal() throws RecognitionException {
        int value = 0;


        CommonTree POSITIVE_INT_VAL184=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:509:5: ( ^( SIGNED_VAL POSITIVE_INT_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:509:7: ^( SIGNED_VAL POSITIVE_INT_VAL ( '-' )? )
            {
            match(input,SIGNED_VAL,FOLLOW_SIGNED_VAL_in_intVal3478); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            POSITIVE_INT_VAL184=(CommonTree)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_intVal3481); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Integer.parseInt((POSITIVE_INT_VAL184!=null?POSITIVE_INT_VAL184.getText():null));}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:509:89: ( '-' )?
            int alt97=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt97=1;
                    }
                    break;
            }

            switch (alt97) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:509:90: '-'
                    {
                    match(input,76,FOLLOW_76_in_intVal3486); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =value*-1;}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "intVal"



    // $ANTLR start "longVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:512:1: longVal returns [long value] : ^( SIGNED_VAL POSITIVE_LONG_VAL ( '-' )? ) ;
    public final long longVal() throws RecognitionException {
        long value = 0;


        CommonTree POSITIVE_LONG_VAL185=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:513:5: ( ^( SIGNED_VAL POSITIVE_LONG_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:513:7: ^( SIGNED_VAL POSITIVE_LONG_VAL ( '-' )? )
            {
            match(input,SIGNED_VAL,FOLLOW_SIGNED_VAL_in_longVal3513); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            POSITIVE_LONG_VAL185=(CommonTree)match(input,POSITIVE_LONG_VAL,FOLLOW_POSITIVE_LONG_VAL_in_longVal3516); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Long.parseLong((POSITIVE_LONG_VAL185!=null?POSITIVE_LONG_VAL185.getText():null).substring(0,(POSITIVE_LONG_VAL185!=null?POSITIVE_LONG_VAL185.getText():null).length()-1));}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:513:137: ( '-' )?
            int alt98=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt98=1;
                    }
                    break;
            }

            switch (alt98) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:513:138: '-'
                    {
                    match(input,76,FOLLOW_76_in_longVal3521); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =value*-1;}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "longVal"



    // $ANTLR start "floatVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:516:1: floatVal returns [float value] : ^( SIGNED_VAL POSITIVE_FLOAT_VAL ( '-' )? ) ;
    public final float floatVal() throws RecognitionException {
        float value = 0.0f;


        CommonTree POSITIVE_FLOAT_VAL186=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:517:5: ( ^( SIGNED_VAL POSITIVE_FLOAT_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:517:7: ^( SIGNED_VAL POSITIVE_FLOAT_VAL ( '-' )? )
            {
            match(input,SIGNED_VAL,FOLLOW_SIGNED_VAL_in_floatVal3548); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            POSITIVE_FLOAT_VAL186=(CommonTree)match(input,POSITIVE_FLOAT_VAL,FOLLOW_POSITIVE_FLOAT_VAL_in_floatVal3551); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Float.parseFloat((POSITIVE_FLOAT_VAL186!=null?POSITIVE_FLOAT_VAL186.getText():null));}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:517:93: ( '-' )?
            int alt99=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt99=1;
                    }
                    break;
            }

            switch (alt99) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:517:94: '-'
                    {
                    match(input,76,FOLLOW_76_in_floatVal3556); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =value*-1;}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "floatVal"



    // $ANTLR start "doubleVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:520:1: doubleVal returns [double value] : ^( SIGNED_VAL POSITIVE_DOUBLE_VAL ( '-' )? ) ;
    public final double doubleVal() throws RecognitionException {
        double value = 0.0;


        CommonTree POSITIVE_DOUBLE_VAL187=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:521:5: ( ^( SIGNED_VAL POSITIVE_DOUBLE_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:521:7: ^( SIGNED_VAL POSITIVE_DOUBLE_VAL ( '-' )? )
            {
            match(input,SIGNED_VAL,FOLLOW_SIGNED_VAL_in_doubleVal3583); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            POSITIVE_DOUBLE_VAL187=(CommonTree)match(input,POSITIVE_DOUBLE_VAL,FOLLOW_POSITIVE_DOUBLE_VAL_in_doubleVal3586); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Double.parseDouble((POSITIVE_DOUBLE_VAL187!=null?POSITIVE_DOUBLE_VAL187.getText():null));}

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:521:97: ( '-' )?
            int alt100=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt100=1;
                    }
                    break;
            }

            switch (alt100) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:521:98: '-'
                    {
                    match(input,76,FOLLOW_76_in_doubleVal3591); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =value*-1;}

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return value;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "doubleVal"



    // $ANTLR start "boolVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:524:1: boolVal returns [boolean value] : BOOL_VAL ;
    public final boolean boolVal() throws RecognitionException {
        boolean value = false;


        CommonTree BOOL_VAL188=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:525:5: ( BOOL_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:525:7: BOOL_VAL
            {
            BOOL_VAL188=(CommonTree)match(input,BOOL_VAL,FOLLOW_BOOL_VAL_in_boolVal3617); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =Boolean.parseBoolean((BOOL_VAL188!=null?BOOL_VAL188.getText():null));}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "boolVal"



    // $ANTLR start "extensionId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:528:1: extensionId returns [String value] : id ;
    public final String extensionId() throws RecognitionException {
        String value = null;


        String id189 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:529:5: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:529:7: id
            {
            pushFollow(FOLLOW_id_in_extensionId3640);
            id189=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id189;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "extensionId"



    // $ANTLR start "functionId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:532:1: functionId returns [String value] : id ;
    public final String functionId() throws RecognitionException {
        String value = null;


        String id190 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:533:5: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:533:7: id
            {
            pushFollow(FOLLOW_id_in_functionId3663);
            id190=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id190;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "functionId"



    // $ANTLR start "tableType"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:536:1: tableType returns [String value] : id ;
    public final String tableType() throws RecognitionException {
        String value = null;


        String id191 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:537:5: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:537:7: id
            {
            pushFollow(FOLLOW_id_in_tableType3686);
            id191=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id191;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "tableType"



    // $ANTLR start "dataSourceName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:540:1: dataSourceName returns [String value] : id ;
    public final String dataSourceName() throws RecognitionException {
        String value = null;


        String id192 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:541:5: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:541:7: id
            {
            pushFollow(FOLLOW_id_in_dataSourceName3709);
            id192=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id192;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dataSourceName"



    // $ANTLR start "tableParamName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:544:1: tableParamName returns [String value] : stringVal ;
    public final String tableParamName() throws RecognitionException {
        String value = null;


        String stringVal193 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:545:5: ( stringVal )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:545:7: stringVal
            {
            pushFollow(FOLLOW_stringVal_in_tableParamName3732);
            stringVal193=stringVal();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =stringVal193;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "tableParamName"



    // $ANTLR start "tableParamValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:548:1: tableParamValue returns [String value] : stringVal ;
    public final String tableParamValue() throws RecognitionException {
        String value = null;


        String stringVal194 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:549:5: ( stringVal )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:549:7: stringVal
            {
            pushFollow(FOLLOW_stringVal_in_tableParamValue3755);
            stringVal194=stringVal();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =stringVal194;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "tableParamValue"



    // $ANTLR start "databaseName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:553:1: databaseName returns [String value] : id ;
    public final String databaseName() throws RecognitionException {
        String value = null;


        String id195 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:554:5: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:554:7: id
            {
            pushFollow(FOLLOW_id_in_databaseName3779);
            id195=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id195;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "databaseName"



    // $ANTLR start "tableName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:557:1: tableName returns [String value] : id ;
    public final String tableName() throws RecognitionException {
        String value = null;


        String id196 =null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:558:5: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:558:7: id
            {
            pushFollow(FOLLOW_id_in_tableName3802);
            id196=id();

            state._fsp--;
            if (state.failed) return value;

            if ( state.backtracking==0 ) {value =id196;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "tableName"



    // $ANTLR start "stringVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:561:1: stringVal returns [String value] : STRING_VAL ;
    public final String stringVal() throws RecognitionException {
        String value = null;


        CommonTree STRING_VAL197=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:562:5: ( STRING_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:562:7: STRING_VAL
            {
            STRING_VAL197=(CommonTree)match(input,STRING_VAL,FOLLOW_STRING_VAL_in_stringVal3825); if (state.failed) return value;

            if ( state.backtracking==0 ) {value =(STRING_VAL197!=null?STRING_VAL197.getText():null);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "stringVal"



    // $ANTLR start "type"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:565:1: type returns [Attribute.Type type] : ( 'string' | 'int' | 'long' | 'float' | 'double' | 'bool' );
    public final Attribute.Type type() throws RecognitionException {
        Attribute.Type type = null;


        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:566:2: ( 'string' | 'int' | 'long' | 'float' | 'double' | 'bool' )
            int alt101=6;
            switch ( input.LA(1) ) {
            case 133:
                {
                alt101=1;
                }
                break;
            case 115:
                {
                alt101=2;
                }
                break;
            case 120:
                {
                alt101=3;
                }
                break;
            case 105:
                {
                alt101=4;
                }
                break;
            case 100:
                {
                alt101=5;
                }
                break;
            case 94:
                {
                alt101=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }

            switch (alt101) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:566:3: 'string'
                    {
                    match(input,133,FOLLOW_133_in_type3848); if (state.failed) return type;

                    if ( state.backtracking==0 ) {type =Attribute.Type.STRING;}

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:567:3: 'int'
                    {
                    match(input,115,FOLLOW_115_in_type3856); if (state.failed) return type;

                    if ( state.backtracking==0 ) {type =Attribute.Type.INT;}

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:568:3: 'long'
                    {
                    match(input,120,FOLLOW_120_in_type3865); if (state.failed) return type;

                    if ( state.backtracking==0 ) {type =Attribute.Type.LONG;}

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:569:3: 'float'
                    {
                    match(input,105,FOLLOW_105_in_type3873); if (state.failed) return type;

                    if ( state.backtracking==0 ) {type =Attribute.Type.FLOAT;}

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:570:3: 'double'
                    {
                    match(input,100,FOLLOW_100_in_type3881); if (state.failed) return type;

                    if ( state.backtracking==0 ) {type =Attribute.Type.DOUBLE;}

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:571:3: 'bool'
                    {
                    match(input,94,FOLLOW_94_in_type3889); if (state.failed) return type;

                    if ( state.backtracking==0 ) {type =Attribute.Type.BOOL;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "type"

    // $ANTLR start synpred14_SiddhiQLGrammarWalker
    public final void synpred14_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:121:4: ( ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? ) )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:121:4: ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? )
        {
        match(input,QUERY,FOLLOW_QUERY_in_synpred14_SiddhiQLGrammarWalker401); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_inputStream_in_synpred14_SiddhiQLGrammarWalker403);
        inputStream();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_outputSelection_in_synpred14_SiddhiQLGrammarWalker405);
        outputSelection();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_outputStream_in_synpred14_SiddhiQLGrammarWalker407);
        outputStream();

        state._fsp--;
        if (state.failed) return ;

        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:10: ( output )?
        int alt103=2;
        switch ( input.LA(1) ) {
            case OUTPUT:
                {
                alt103=1;
                }
                break;
        }

        switch (alt103) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:11: output
                {
                pushFollow(FOLLOW_output_in_synpred14_SiddhiQLGrammarWalker422);
                output();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:57: ( partition )?
        int alt104=2;
        switch ( input.LA(1) ) {
            case PARTITION:
                {
                alt104=1;
                }
                break;
        }

        switch (alt104) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:122:58: partition
                {
                pushFollow(FOLLOW_partition_in_synpred14_SiddhiQLGrammarWalker429);
                partition();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred14_SiddhiQLGrammarWalker

    // $ANTLR start synpred29_SiddhiQLGrammarWalker
    public final void synpred29_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:143:4: ( windowStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:143:4: windowStream
        {
        pushFollow(FOLLOW_windowStream_in_synpred29_SiddhiQLGrammarWalker637);
        windowStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred29_SiddhiQLGrammarWalker

    // $ANTLR start synpred50_SiddhiQLGrammarWalker
    public final void synpred50_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:4: ( leftStream join rightStream 'unidirectional' ( condition )? ( time )? )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:4: leftStream join rightStream 'unidirectional' ( condition )? ( time )?
        {
        pushFollow(FOLLOW_leftStream_in_synpred50_SiddhiQLGrammarWalker989);
        leftStream();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_join_in_synpred50_SiddhiQLGrammarWalker992);
        join();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_rightStream_in_synpred50_SiddhiQLGrammarWalker994);
        rightStream();

        state._fsp--;
        if (state.failed) return ;

        match(input,136,FOLLOW_136_in_synpred50_SiddhiQLGrammarWalker996); if (state.failed) return ;

        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:50: ( condition )?
        int alt114=2;
        switch ( input.LA(1) ) {
            case CONDITION:
                {
                alt114=1;
                }
                break;
        }

        switch (alt114) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:51: condition
                {
                pushFollow(FOLLOW_condition_in_synpred50_SiddhiQLGrammarWalker999);
                condition();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:112: ( time )?
        int alt115=2;
        switch ( input.LA(1) ) {
            case CONSTANT:
                {
                alt115=1;
                }
                break;
        }

        switch (alt115) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:184:113: time
                {
                pushFollow(FOLLOW_time_in_synpred50_SiddhiQLGrammarWalker1006);
                time();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred50_SiddhiQLGrammarWalker

    // $ANTLR start synpred53_SiddhiQLGrammarWalker
    public final void synpred53_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:4: ( leftStream join rightStream ( condition )? ( time )? )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:4: leftStream join rightStream ( condition )? ( time )?
        {
        pushFollow(FOLLOW_leftStream_in_synpred53_SiddhiQLGrammarWalker1017);
        leftStream();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_join_in_synpred53_SiddhiQLGrammarWalker1019);
        join();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_rightStream_in_synpred53_SiddhiQLGrammarWalker1021);
        rightStream();

        state._fsp--;
        if (state.failed) return ;

        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:32: ( condition )?
        int alt116=2;
        switch ( input.LA(1) ) {
            case CONDITION:
                {
                alt116=1;
                }
                break;
        }

        switch (alt116) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:33: condition
                {
                pushFollow(FOLLOW_condition_in_synpred53_SiddhiQLGrammarWalker1024);
                condition();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:94: ( time )?
        int alt117=2;
        switch ( input.LA(1) ) {
            case CONSTANT:
                {
                alt117=1;
                }
                break;
        }

        switch (alt117) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:185:95: time
                {
                pushFollow(FOLLOW_time_in_synpred53_SiddhiQLGrammarWalker1031);
                time();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred53_SiddhiQLGrammarWalker

    // $ANTLR start synpred56_SiddhiQLGrammarWalker
    public final void synpred56_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:190:8: ( windowStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:190:8: windowStream
        {
        pushFollow(FOLLOW_windowStream_in_synpred56_SiddhiQLGrammarWalker1090);
        windowStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred56_SiddhiQLGrammarWalker

    // $ANTLR start synpred57_SiddhiQLGrammarWalker
    public final void synpred57_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:195:8: ( windowStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:195:8: windowStream
        {
        pushFollow(FOLLOW_windowStream_in_synpred57_SiddhiQLGrammarWalker1126);
        windowStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred57_SiddhiQLGrammarWalker

    // $ANTLR start synpred60_SiddhiQLGrammarWalker
    public final void synpred60_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        PatternElement p =null;


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:4: ( ^( 'every' patternItem ) (p= patternStream )? )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:4: ^( 'every' patternItem ) (p= patternStream )?
        {
        match(input,102,FOLLOW_102_in_synpred60_SiddhiQLGrammarWalker1219); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_patternItem_in_synpred60_SiddhiQLGrammarWalker1222);
        patternItem();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:76: (p= patternStream )?
        int alt118=2;
        switch ( input.LA(1) ) {
            case COLLECT:
            case STREAM:
            case 92:
            case 102:
            case 123:
                {
                alt118=1;
                }
                break;
        }

        switch (alt118) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:211:77: p= patternStream
                {
                pushFollow(FOLLOW_patternStream_in_synpred60_SiddhiQLGrammarWalker1230);
                p=patternStream();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred60_SiddhiQLGrammarWalker

    // $ANTLR start synpred62_SiddhiQLGrammarWalker
    public final void synpred62_SiddhiQLGrammarWalker_fragment() throws RecognitionException {
        PatternElement p =null;


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:212:4: ( ^( 'every' nonEveryPatternStream ) (p= patternStream )? )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:212:4: ^( 'every' nonEveryPatternStream ) (p= patternStream )?
        {
        match(input,102,FOLLOW_102_in_synpred62_SiddhiQLGrammarWalker1240); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_nonEveryPatternStream_in_synpred62_SiddhiQLGrammarWalker1242);
        nonEveryPatternStream();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:212:98: (p= patternStream )?
        int alt119=2;
        switch ( input.LA(1) ) {
            case COLLECT:
            case STREAM:
            case 92:
            case 102:
            case 123:
                {
                alt119=1;
                }
                break;
        }

        switch (alt119) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammarWalker.g:212:99: p= patternStream
                {
                pushFollow(FOLLOW_patternStream_in_synpred62_SiddhiQLGrammarWalker1253);
                p=patternStream();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred62_SiddhiQLGrammarWalker

    // Delegated rules

    public final boolean synpred60_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_SiddhiQLGrammarWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_SiddhiQLGrammarWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_PARTITION_DEFINITION_in_executionPlan67 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_definitionPartition_in_executionPlan69 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STREAM_DEFINITION_in_executionPlan81 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_definitionStream_in_executionPlan83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TABLE_DEFINITION_in_executionPlan95 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_definitionTable_in_executionPlan97 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_query_in_executionPlan108 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_definitionStream_in_definitionStreamFinal131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamId_in_definitionStream159 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_ATTRIBUTE_in_definitionStream165 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_definitionStream167 = new BitSet(new long[]{0x0000000000000000L,0x0108021040000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_definitionStream169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_definitionPartition_in_definitionPartitionFinal191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partitionId_in_definitionPartition214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PARTITION_TYPE_in_definitionPartition220 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_partitionType_in_definitionPartition222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_streamAttributeName_in_partitionType247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_partitionType257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_in_partitionType267 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_stringVal_in_partitionType269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definitionTable_in_definitionTableFinal292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_definitionTable322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_ATTRIBUTE_in_definitionTable329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_definitionTable331 = new BitSet(new long[]{0x0000000000000000L,0x0108021040000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_definitionTable333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TABLE_in_definitionTable343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TABLE_PARAMETER_in_definitionTable348 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tableParamName_in_definitionTable350 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_tableParamValue_in_definitionTable352 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_query_in_queryFinal380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_in_query401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inputStream_in_query403 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_outputSelection_in_query405 = new BitSet(new long[]{0x8000000000802000L});
    public static final BitSet FOLLOW_outputStream_in_query407 = new BitSet(new long[]{0x0000004200000008L});
    public static final BitSet FOLLOW_output_in_query422 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_partition_in_query429 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUERY_in_query440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inputStream_in_query442 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_outputSelection_in_query444 = new BitSet(new long[]{0x0000004200000008L});
    public static final BitSet FOLLOW_output_in_query458 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_partition_in_query465 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INSERT_INTO_STREAM_in_outputStream487 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_streamId_in_outputStream489 = new BitSet(new long[]{0x0000000000000008L,0x0000008208000000L});
    public static final BitSet FOLLOW_outputTypeCondition_in_outputStream494 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DELETE_STREAM_in_outputStream506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_streamId_in_outputStream508 = new BitSet(new long[]{0x0000000000000208L,0x0000008208000000L});
    public static final BitSet FOLLOW_outputTypeCondition_in_outputStream513 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_condition_in_outputStream520 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UPDATE_STREAM_in_outputStream532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_streamId_in_outputStream534 = new BitSet(new long[]{0x0000000000000208L,0x0000008208000000L});
    public static final BitSet FOLLOW_outputTypeCondition_in_outputStream539 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_condition_in_outputStream546 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_103_in_outputTypeCondition566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_outputTypeCondition573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_outputTypeCondition580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEQUENCE_FULL_in_inputStream602 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sequenceFullStream_in_inputStream604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATTERN_FULL_in_inputStream613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_patternFullStream_in_inputStream616 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_JOIN_in_inputStream626 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_joinStream_in_inputStream628 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_windowStream_in_inputStream637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basicStream_in_inputStream653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_output685 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_timeExpr_in_output687 = new BitSet(new long[]{0x0040000000000008L,0x0040010004000000L});
    public static final BitSet FOLLOW_SNAPSHOT_in_output691 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_outputType_in_output699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output712 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_output714 = new BitSet(new long[]{0x0000000000000008L,0x0040010004000000L});
    public static final BitSet FOLLOW_outputType_in_output720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_90_in_outputType744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_outputType752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_outputType760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partition778 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_partitionId_in_partition780 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STREAM_in_basicStream800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rawStream_in_basicStream802 = new BitSet(new long[]{0x4000000000600008L});
    public static final BitSet FOLLOW_transformHandler_in_basicStream807 = new BitSet(new long[]{0x0000000000600008L});
    public static final BitSet FOLLOW_id_in_basicStream814 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STREAM_in_windowStream843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ANONYMOUS_in_windowStream847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_returnQuery_in_windowStream849 = new BitSet(new long[]{0x4000000000010000L,0x0000000000000002L});
    public static final BitSet FOLLOW_filterHandler_in_windowStream854 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_transformHandler_in_windowStream861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_windowHandler_in_windowStream868 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_windowStream875 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STREAM_in_windowStream886 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_streamId_in_windowStream890 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filterHandler_in_windowStream895 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_transformHandler_in_windowStream902 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_windowHandler_in_windowStream909 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_windowStream916 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANONYMOUS_in_rawStream938 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_returnQuery_in_rawStream940 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_filterHandler_in_rawStream945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_streamId_in_rawStream958 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filterHandler_in_rawStream963 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_leftStream_in_joinStream989 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_join_in_joinStream992 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rightStream_in_joinStream994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_joinStream996 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_condition_in_joinStream999 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_time_in_joinStream1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_joinStream1017 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_join_in_joinStream1019 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rightStream_in_joinStream1021 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_condition_in_joinStream1024 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_time_in_joinStream1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_joinStream1048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_joinStream1050 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_join_in_joinStream1053 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rightStream_in_joinStream1055 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_condition_in_joinStream1058 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_time_in_joinStream1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_leftStream1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basicStream_in_leftStream1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_rightStream1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basicStream_in_rightStream1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_QUERY_in_returnQuery1164 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inputStream_in_returnQuery1167 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_outputSelection_in_returnQuery1169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATTERN_in_patternFullStream1188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_patternStream_in_patternFullStream1191 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_time_in_patternFullStream1196 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_102_in_patternStream1219 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_patternItem_in_patternStream1222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_patternStream_in_patternStream1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_patternStream1240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nonEveryPatternStream_in_patternStream1242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_patternStream_in_patternStream1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_patternItem_in_patternStream1262 = new BitSet(new long[]{0x0080000000000082L,0x0800004010000000L});
    public static final BitSet FOLLOW_patternStream_in_patternStream1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_patternItem_in_nonEveryPatternStream1292 = new BitSet(new long[]{0x0080000000000082L,0x0800000010000000L});
    public static final BitSet FOLLOW_nonEveryPatternStream_in_nonEveryPatternStream1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEQUENCE_in_sequenceFullStream1319 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sequenceStream_in_sequenceFullStream1322 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_time_in_sequenceFullStream1327 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_sequenceItem_in_sequenceStream1361 = new BitSet(new long[]{0x0081000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_92_in_patternItem1383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1387 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_123_in_patternItem1401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1406 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1410 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COLLECT_in_patternItem1419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1421 = new BitSet(new long[]{0x0000200000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_collect_in_patternItem1423 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_sequenceItem1455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1459 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1463 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REGEX_in_sequenceItem1477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1479 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800600L});
    public static final BitSet FOLLOW_regex_in_sequenceItem1481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_itemStream1523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rawStream_in_itemStream1525 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_attributeName_in_itemStream1529 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_73_in_regex1555 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_74_in_regex1560 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_regex1564 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_regex1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUT_ATTRIBUTES_in_outputSelection1594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_outputAttributeList_in_outputSelection1596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_groupBy_in_outputSelection1605 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_having_in_outputSelection1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_outputAttributeList1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUT_ATTRIBUTE_in_outputAttributeList1648 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_outputItem_in_outputAttributeList1650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_outputItem1671 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_extensionOutFunction_in_outputItem1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_outFunction_in_outputItem1684 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_outputItem1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_outputItem1697 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_outputItem1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeVariable_in_outputItem1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENSION_FUNCTION_in_extensionOutFunction1735 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_extensionId_in_extensionOutFunction1737 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_functionId_in_extensionOutFunction1739 = new BitSet(new long[]{0x0000002000000008L});
    public static final BitSet FOLLOW_parameters_in_extensionOutFunction1772 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_outFunction1801 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_outFunction1803 = new BitSet(new long[]{0x0000002000000008L});
    public static final BitSet FOLLOW_parameters_in_outFunction1808 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_109_in_groupBy1836 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeVariable_in_groupBy1839 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_110_in_having1860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_condition_in_having1862 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filterHandler1882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_condition_in_filterHandler1884 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRANSFORM_in_transformHandler1905 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_extensibleId_in_transformHandler1907 = new BitSet(new long[]{0x0000002000000008L});
    public static final BitSet FOLLOW_parameters_in_transformHandler1913 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WINDOW_in_windowHandler1935 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_extensibleId_in_windowHandler1937 = new BitSet(new long[]{0x0000002000000008L});
    public static final BitSet FOLLOW_parameters_in_windowHandler1943 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_extensibleId1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENSION_in_extensibleId1980 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_extensionId_in_extensibleId1984 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_functionId_in_extensibleId1986 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMETERS_in_parameters2024 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_parameter_in_parameters2027 = new BitSet(new long[]{0x0000000000008828L,0x0108021040005640L,0x0000000000000020L});
    public static final BitSet FOLLOW_constant_in_time2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_parameter2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStart_in_collect2089 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_collect2091 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_countEnd_in_collect2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStart_in_collect2101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_collect2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_collect2112 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_countEnd_in_collect2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStartAndEnd_in_collect2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_countStart2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_countEnd2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_countStartAndEnd2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONDITION_in_condition2208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditionExpression_in_condition2210 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_123_in_conditionExpression2232 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditionExpression_in_conditionExpression2236 = new BitSet(new long[]{0x0000000000000440L,0x0A04800110760010L});
    public static final BitSet FOLLOW_conditionExpression_in_conditionExpression2240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_92_in_conditionExpression2253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditionExpression_in_conditionExpression2257 = new BitSet(new long[]{0x0000000000000440L,0x0A04800110760010L});
    public static final BitSet FOLLOW_conditionExpression_in_conditionExpression2261 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_111_in_conditionExpression2274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditionExpression_in_conditionExpression2278 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_streamId_in_conditionExpression2280 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_compareOperation_in_conditionExpression2310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditionExpression2314 = new BitSet(new long[]{0x0000000000008820L,0x0108021040005640L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_conditionExpression2318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_121_in_conditionExpression2338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditionExpression_in_conditionExpression2342 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONDITION_FUNCTION_in_conditionExpression2361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionId_in_conditionExpression2364 = new BitSet(new long[]{0x0000002000600008L});
    public static final BitSet FOLLOW_extensionId_in_conditionExpression2385 = new BitSet(new long[]{0x0000002000000008L});
    public static final BitSet FOLLOW_parameters_in_conditionExpression2408 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_boolVal_in_conditionExpression2420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_expression2453 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2457 = new BitSet(new long[]{0x0000000000008820L,0x0108021040005640L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_expression2461 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_78_in_expression2473 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2477 = new BitSet(new long[]{0x0000000000008820L,0x0108021040005640L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_expression2481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_73_in_expression2493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2497 = new BitSet(new long[]{0x0000000000008820L,0x0108021040005640L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_expression2501 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_76_in_expression2513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2517 = new BitSet(new long[]{0x0000000000008820L,0x0108021040005640L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_expression2521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_74_in_expression2533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2537 = new BitSet(new long[]{0x0000000000008820L,0x0108021040005640L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_expression2541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_valueExpression_in_expression2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_valueExpression2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_valueExpression2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeVariable_in_valueExpression2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENSION_FUNCTION_in_valueExpression2619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionId_in_valueExpression2621 = new BitSet(new long[]{0x0000002000600008L});
    public static final BitSet FOLLOW_extensionId_in_valueExpression2642 = new BitSet(new long[]{0x0000002000000008L});
    public static final BitSet FOLLOW_parameters_in_valueExpression2665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONSTANT_in_constant2693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_intVal_in_constant2695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONSTANT_in_constant2707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_longVal_in_constant2709 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONSTANT_in_constant2720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_floatVal_in_constant2722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONSTANT_in_constant2733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_doubleVal_in_constant2735 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONSTANT_in_constant2745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolVal_in_constant2747 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONSTANT_in_constant2758 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stringVal_in_constant2760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONSTANT_in_constant2770 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_timeExpr_in_constant2772 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIME_EXP_in_timeExpr2796 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_yearValue_in_timeExpr2799 = new BitSet(new long[]{0x0004000070101008L,0x0000000000000001L});
    public static final BitSet FOLLOW_monthValue_in_timeExpr2808 = new BitSet(new long[]{0x0004000030101008L,0x0000000000000001L});
    public static final BitSet FOLLOW_weekValue_in_timeExpr2817 = new BitSet(new long[]{0x0004000030101008L});
    public static final BitSet FOLLOW_dayValue_in_timeExpr2826 = new BitSet(new long[]{0x0004000030100008L});
    public static final BitSet FOLLOW_hourValue_in_timeExpr2836 = new BitSet(new long[]{0x0004000030000008L});
    public static final BitSet FOLLOW_minuteValue_in_timeExpr2845 = new BitSet(new long[]{0x0004000010000008L});
    public static final BitSet FOLLOW_secondValue_in_timeExpr2856 = new BitSet(new long[]{0x0000000010000008L});
    public static final BitSet FOLLOW_milliSecondValue_in_timeExpr2865 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_YEAR_in_yearValue2889 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_yearValue2894 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MONTH_in_monthValue2916 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_monthValue2922 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WEEK_in_weekValue2942 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_weekValue2948 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DAY_in_dayValue2972 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_dayValue2978 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_HOUR_in_hourValue3001 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_hourValue3007 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MIN_in_minuteValue3029 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_minuteValue3035 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEC_in_secondValue3056 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_secondValue3061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MILLI_SEC_in_milliSecondValue3084 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_milliSecondValue3090 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_partitionId3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_streamId3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamPositionAttributeName_in_attributeVariable3143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamAttributeName_in_attributeVariable3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attributeVariable3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_streamPositionAttributeName3187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_streamId_in_streamPositionAttributeName3190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_streamPositionAttributeName3194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_streamPositionAttributeName3199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_streamPositionAttributeName3209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_streamId_in_streamPositionAttributeName3212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LAST_in_streamPositionAttributeName3216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_streamPositionAttributeName3221 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_streamAttributeName3240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_streamId_in_streamAttributeName3243 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_streamAttributeName3248 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_attributeName3268 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_id_in_attributeName3270 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_117_in_join3291 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_124_in_join3294 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_119_in_join3296 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_117_in_join3310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_124_in_join3313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_129_in_join3315 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_117_in_join3329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_124_in_join3332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_108_in_join3334 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_117_in_join3346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_112_in_join3348 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_84_in_compareOperation3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_compareOperation3377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_compareOperation3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_compareOperation3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_compareOperation3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_compareOperation3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_compareOperation3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_compareOperation3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_id3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_QUOTES_in_id3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIGNED_VAL_in_intVal3478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_intVal3481 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_intVal3486 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SIGNED_VAL_in_longVal3513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_LONG_VAL_in_longVal3516 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_longVal3521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SIGNED_VAL_in_floatVal3548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_FLOAT_VAL_in_floatVal3551 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_floatVal3556 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SIGNED_VAL_in_doubleVal3583 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_POSITIVE_DOUBLE_VAL_in_doubleVal3586 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_doubleVal3591 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_VAL_in_boolVal3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_extensionId3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_functionId3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_tableType3686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_dataSourceName3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringVal_in_tableParamName3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringVal_in_tableParamValue3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_databaseName3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_tableName3802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_VAL_in_stringVal3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_type3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_type3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_type3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_type3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_type3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_type3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_in_synpred14_SiddhiQLGrammarWalker401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inputStream_in_synpred14_SiddhiQLGrammarWalker403 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_outputSelection_in_synpred14_SiddhiQLGrammarWalker405 = new BitSet(new long[]{0x8000000000802000L});
    public static final BitSet FOLLOW_outputStream_in_synpred14_SiddhiQLGrammarWalker407 = new BitSet(new long[]{0x0000004200000008L});
    public static final BitSet FOLLOW_output_in_synpred14_SiddhiQLGrammarWalker422 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_partition_in_synpred14_SiddhiQLGrammarWalker429 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_windowStream_in_synpred29_SiddhiQLGrammarWalker637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_synpred50_SiddhiQLGrammarWalker989 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_join_in_synpred50_SiddhiQLGrammarWalker992 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rightStream_in_synpred50_SiddhiQLGrammarWalker994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_synpred50_SiddhiQLGrammarWalker996 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_condition_in_synpred50_SiddhiQLGrammarWalker999 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_time_in_synpred50_SiddhiQLGrammarWalker1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_synpred53_SiddhiQLGrammarWalker1017 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_join_in_synpred53_SiddhiQLGrammarWalker1019 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rightStream_in_synpred53_SiddhiQLGrammarWalker1021 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_condition_in_synpred53_SiddhiQLGrammarWalker1024 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_time_in_synpred53_SiddhiQLGrammarWalker1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_synpred56_SiddhiQLGrammarWalker1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_synpred57_SiddhiQLGrammarWalker1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_synpred60_SiddhiQLGrammarWalker1219 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_patternItem_in_synpred60_SiddhiQLGrammarWalker1222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_patternStream_in_synpred60_SiddhiQLGrammarWalker1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_synpred62_SiddhiQLGrammarWalker1240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nonEveryPatternStream_in_synpred62_SiddhiQLGrammarWalker1242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_patternStream_in_synpred62_SiddhiQLGrammarWalker1253 = new BitSet(new long[]{0x0000000000000002L});

}