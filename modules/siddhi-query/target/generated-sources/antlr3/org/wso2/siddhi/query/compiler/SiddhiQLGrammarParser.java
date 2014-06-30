// $ANTLR 3.4 org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g 2014-06-30 09:22:21

	package org.wso2.siddhi.query.compiler;
	import java.util.LinkedList;
	import org.wso2.siddhi.query.compiler.exception.SiddhiParserException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class SiddhiQLGrammarParser extends Parser {
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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public SiddhiQLGrammarParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public SiddhiQLGrammarParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return SiddhiQLGrammarParser.tokenNames; }
    public String getGrammarFileName() { return "org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g"; }


      @Override
      public void emitErrorMessage(String errorMessage) {
        throw new SiddhiParserException(errorMessage);
      }


    public static class executionPlan_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "executionPlan"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:94:1: executionPlan : ( definitionPartition | definitionStream | definitionTable | query ) ( ';' ( definitionPartition | definitionStream | definitionTable | query ) )* ( ';' )? EOF -> ( ^( PARTITION_DEFINITION definitionPartition ) )* ( ^( STREAM_DEFINITION definitionStream ) )* ( ^( TABLE_DEFINITION definitionTable ) )* ( query )* ;
    public final SiddhiQLGrammarParser.executionPlan_return executionPlan() throws RecognitionException {
        SiddhiQLGrammarParser.executionPlan_return retval = new SiddhiQLGrammarParser.executionPlan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal5=null;
        Token char_literal10=null;
        Token EOF11=null;
        SiddhiQLGrammarParser.definitionPartition_return definitionPartition1 =null;

        SiddhiQLGrammarParser.definitionStream_return definitionStream2 =null;

        SiddhiQLGrammarParser.definitionTable_return definitionTable3 =null;

        SiddhiQLGrammarParser.query_return query4 =null;

        SiddhiQLGrammarParser.definitionPartition_return definitionPartition6 =null;

        SiddhiQLGrammarParser.definitionStream_return definitionStream7 =null;

        SiddhiQLGrammarParser.definitionTable_return definitionTable8 =null;

        SiddhiQLGrammarParser.query_return query9 =null;


        CommonTree char_literal5_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree EOF11_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_definitionTable=new RewriteRuleSubtreeStream(adaptor,"rule definitionTable");
        RewriteRuleSubtreeStream stream_query=new RewriteRuleSubtreeStream(adaptor,"rule query");
        RewriteRuleSubtreeStream stream_definitionStream=new RewriteRuleSubtreeStream(adaptor,"rule definitionStream");
        RewriteRuleSubtreeStream stream_definitionPartition=new RewriteRuleSubtreeStream(adaptor,"rule definitionPartition");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:2: ( ( definitionPartition | definitionStream | definitionTable | query ) ( ';' ( definitionPartition | definitionStream | definitionTable | query ) )* ( ';' )? EOF -> ( ^( PARTITION_DEFINITION definitionPartition ) )* ( ^( STREAM_DEFINITION definitionStream ) )* ( ^( TABLE_DEFINITION definitionTable ) )* ( query )* )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:3: ( definitionPartition | definitionStream | definitionTable | query ) ( ';' ( definitionPartition | definitionStream | definitionTable | query ) )* ( ';' )? EOF
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:3: ( definitionPartition | definitionStream | definitionTable | query )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 98:
                {
                switch ( input.LA(2) ) {
                case 126:
                    {
                    alt1=1;
                    }
                    break;
                case 132:
                    {
                    alt1=2;
                    }
                    break;
                case 134:
                    {
                    alt1=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }

                }
                break;
            case 107:
                {
                alt1=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:4: definitionPartition
                    {
                    pushFollow(FOLLOW_definitionPartition_in_executionPlan348);
                    definitionPartition1=definitionPartition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_definitionPartition.add(definitionPartition1.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:24: definitionStream
                    {
                    pushFollow(FOLLOW_definitionStream_in_executionPlan350);
                    definitionStream2=definitionStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_definitionStream.add(definitionStream2.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:41: definitionTable
                    {
                    pushFollow(FOLLOW_definitionTable_in_executionPlan352);
                    definitionTable3=definitionTable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_definitionTable.add(definitionTable3.getTree());

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:57: query
                    {
                    pushFollow(FOLLOW_query_in_executionPlan354);
                    query4=query();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_query.add(query4.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:64: ( ';' ( definitionPartition | definitionStream | definitionTable | query ) )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case 80:
                    {
                    switch ( input.LA(2) ) {
                    case 98:
                    case 107:
                        {
                        alt3=1;
                        }
                        break;

                    }

                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:65: ';' ( definitionPartition | definitionStream | definitionTable | query )
            	    {
            	    char_literal5=(Token)match(input,80,FOLLOW_80_in_executionPlan358); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_80.add(char_literal5);


            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:69: ( definitionPartition | definitionStream | definitionTable | query )
            	    int alt2=4;
            	    switch ( input.LA(1) ) {
            	    case 98:
            	        {
            	        switch ( input.LA(2) ) {
            	        case 126:
            	            {
            	            alt2=1;
            	            }
            	            break;
            	        case 132:
            	            {
            	            alt2=2;
            	            }
            	            break;
            	        case 134:
            	            {
            	            alt2=3;
            	            }
            	            break;
            	        default:
            	            if (state.backtracking>0) {state.failed=true; return retval;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 2, 1, input);

            	            throw nvae;

            	        }

            	        }
            	        break;
            	    case 107:
            	        {
            	        alt2=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:70: definitionPartition
            	            {
            	            pushFollow(FOLLOW_definitionPartition_in_executionPlan361);
            	            definitionPartition6=definitionPartition();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_definitionPartition.add(definitionPartition6.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:91: definitionStream
            	            {
            	            pushFollow(FOLLOW_definitionStream_in_executionPlan364);
            	            definitionStream7=definitionStream();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_definitionStream.add(definitionStream7.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:108: definitionTable
            	            {
            	            pushFollow(FOLLOW_definitionTable_in_executionPlan366);
            	            definitionTable8=definitionTable();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_definitionTable.add(definitionTable8.getTree());

            	            }
            	            break;
            	        case 4 :
            	            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:124: query
            	            {
            	            pushFollow(FOLLOW_query_in_executionPlan368);
            	            query9=query();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_query.add(query9.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:133: ( ';' )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case 80:
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:133: ';'
                    {
                    char_literal10=(Token)match(input,80,FOLLOW_80_in_executionPlan373); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_80.add(char_literal10);


                    }
                    break;

            }


            EOF11=(Token)match(input,EOF,FOLLOW_EOF_in_executionPlan376); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF11);


            // AST REWRITE
            // elements: definitionTable, definitionStream, definitionPartition, query
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:143: -> ( ^( PARTITION_DEFINITION definitionPartition ) )* ( ^( STREAM_DEFINITION definitionStream ) )* ( ^( TABLE_DEFINITION definitionTable ) )* ( query )*
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:146: ( ^( PARTITION_DEFINITION definitionPartition ) )*
                while ( stream_definitionPartition.hasNext() ) {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:147: ^( PARTITION_DEFINITION definitionPartition )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(PARTITION_DEFINITION, "PARTITION_DEFINITION")
                    , root_1);

                    adaptor.addChild(root_1, stream_definitionPartition.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_definitionPartition.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:193: ( ^( STREAM_DEFINITION definitionStream ) )*
                while ( stream_definitionStream.hasNext() ) {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:194: ^( STREAM_DEFINITION definitionStream )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(STREAM_DEFINITION, "STREAM_DEFINITION")
                    , root_1);

                    adaptor.addChild(root_1, stream_definitionStream.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_definitionStream.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:235: ( ^( TABLE_DEFINITION definitionTable ) )*
                while ( stream_definitionTable.hasNext() ) {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:236: ^( TABLE_DEFINITION definitionTable )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(TABLE_DEFINITION, "TABLE_DEFINITION")
                    , root_1);

                    adaptor.addChild(root_1, stream_definitionTable.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_definitionTable.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:95:275: ( query )*
                while ( stream_query.hasNext() ) {
                    adaptor.addChild(root_0, stream_query.nextTree());

                }
                stream_query.reset();

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "executionPlan"


    public static class definitionStreamFinal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "definitionStreamFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:98:1: definitionStreamFinal : definitionStream ( ';' )? EOF -> definitionStream ;
    public final SiddhiQLGrammarParser.definitionStreamFinal_return definitionStreamFinal() throws RecognitionException {
        SiddhiQLGrammarParser.definitionStreamFinal_return retval = new SiddhiQLGrammarParser.definitionStreamFinal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal13=null;
        Token EOF14=null;
        SiddhiQLGrammarParser.definitionStream_return definitionStream12 =null;


        CommonTree char_literal13_tree=null;
        CommonTree EOF14_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_definitionStream=new RewriteRuleSubtreeStream(adaptor,"rule definitionStream");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:99:5: ( definitionStream ( ';' )? EOF -> definitionStream )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:99:7: definitionStream ( ';' )? EOF
            {
            pushFollow(FOLLOW_definitionStream_in_definitionStreamFinal429);
            definitionStream12=definitionStream();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_definitionStream.add(definitionStream12.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:99:24: ( ';' )?
            int alt5=2;
            switch ( input.LA(1) ) {
                case 80:
                    {
                    alt5=1;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:99:24: ';'
                    {
                    char_literal13=(Token)match(input,80,FOLLOW_80_in_definitionStreamFinal431); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_80.add(char_literal13);


                    }
                    break;

            }


            EOF14=(Token)match(input,EOF,FOLLOW_EOF_in_definitionStreamFinal434); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF14);


            // AST REWRITE
            // elements: definitionStream
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 99:33: -> definitionStream
            {
                adaptor.addChild(root_0, stream_definitionStream.nextTree());

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "definitionStreamFinal"


    public static class definitionStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "definitionStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:102:1: definitionStream : 'define' 'stream' streamId '(' attributeName type ( ',' attributeName type )* ')' -> ^( streamId ( ^( IN_ATTRIBUTE attributeName type ) )+ ) ;
    public final SiddhiQLGrammarParser.definitionStream_return definitionStream() throws RecognitionException {
        SiddhiQLGrammarParser.definitionStream_return retval = new SiddhiQLGrammarParser.definitionStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal15=null;
        Token string_literal16=null;
        Token char_literal18=null;
        Token char_literal21=null;
        Token char_literal24=null;
        SiddhiQLGrammarParser.streamId_return streamId17 =null;

        SiddhiQLGrammarParser.attributeName_return attributeName19 =null;

        SiddhiQLGrammarParser.type_return type20 =null;

        SiddhiQLGrammarParser.attributeName_return attributeName22 =null;

        SiddhiQLGrammarParser.type_return type23 =null;


        CommonTree string_literal15_tree=null;
        CommonTree string_literal16_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal24_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_132=new RewriteRuleTokenStream(adaptor,"token 132");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_streamId=new RewriteRuleSubtreeStream(adaptor,"rule streamId");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:103:2: ( 'define' 'stream' streamId '(' attributeName type ( ',' attributeName type )* ')' -> ^( streamId ( ^( IN_ATTRIBUTE attributeName type ) )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:103:3: 'define' 'stream' streamId '(' attributeName type ( ',' attributeName type )* ')'
            {
            string_literal15=(Token)match(input,98,FOLLOW_98_in_definitionStream452); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(string_literal15);


            string_literal16=(Token)match(input,132,FOLLOW_132_in_definitionStream454); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_132.add(string_literal16);


            pushFollow(FOLLOW_streamId_in_definitionStream456);
            streamId17=streamId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_streamId.add(streamId17.getTree());

            char_literal18=(Token)match(input,71,FOLLOW_71_in_definitionStream458); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(char_literal18);


            pushFollow(FOLLOW_attributeName_in_definitionStream460);
            attributeName19=attributeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributeName.add(attributeName19.getTree());

            pushFollow(FOLLOW_type_in_definitionStream462);
            type20=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type20.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:103:53: ( ',' attributeName type )*
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:103:54: ',' attributeName type
            	    {
            	    char_literal21=(Token)match(input,75,FOLLOW_75_in_definitionStream465); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_75.add(char_literal21);


            	    pushFollow(FOLLOW_attributeName_in_definitionStream467);
            	    attributeName22=attributeName();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attributeName.add(attributeName22.getTree());

            	    pushFollow(FOLLOW_type_in_definitionStream469);
            	    type23=type();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_type.add(type23.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            char_literal24=(Token)match(input,72,FOLLOW_72_in_definitionStream474); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal24);


            // AST REWRITE
            // elements: type, streamId, attributeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 103:85: -> ^( streamId ( ^( IN_ATTRIBUTE attributeName type ) )+ )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:103:89: ^( streamId ( ^( IN_ATTRIBUTE attributeName type ) )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_streamId.nextNode(), root_1);

                if ( !(stream_type.hasNext()||stream_attributeName.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_type.hasNext()||stream_attributeName.hasNext() ) {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:103:101: ^( IN_ATTRIBUTE attributeName type )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(IN_ATTRIBUTE, "IN_ATTRIBUTE")
                    , root_2);

                    adaptor.addChild(root_2, stream_attributeName.nextTree());

                    adaptor.addChild(root_2, stream_type.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_type.reset();
                stream_attributeName.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "definitionStream"


    public static class definitionPartitionFinal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "definitionPartitionFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:106:1: definitionPartitionFinal : definitionPartition ( ';' )? EOF -> definitionPartition ;
    public final SiddhiQLGrammarParser.definitionPartitionFinal_return definitionPartitionFinal() throws RecognitionException {
        SiddhiQLGrammarParser.definitionPartitionFinal_return retval = new SiddhiQLGrammarParser.definitionPartitionFinal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal26=null;
        Token EOF27=null;
        SiddhiQLGrammarParser.definitionPartition_return definitionPartition25 =null;


        CommonTree char_literal26_tree=null;
        CommonTree EOF27_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_definitionPartition=new RewriteRuleSubtreeStream(adaptor,"rule definitionPartition");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:107:5: ( definitionPartition ( ';' )? EOF -> definitionPartition )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:107:6: definitionPartition ( ';' )? EOF
            {
            pushFollow(FOLLOW_definitionPartition_in_definitionPartitionFinal506);
            definitionPartition25=definitionPartition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_definitionPartition.add(definitionPartition25.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:107:26: ( ';' )?
            int alt7=2;
            switch ( input.LA(1) ) {
                case 80:
                    {
                    alt7=1;
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:107:26: ';'
                    {
                    char_literal26=(Token)match(input,80,FOLLOW_80_in_definitionPartitionFinal508); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_80.add(char_literal26);


                    }
                    break;

            }


            EOF27=(Token)match(input,EOF,FOLLOW_EOF_in_definitionPartitionFinal511); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF27);


            // AST REWRITE
            // elements: definitionPartition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 107:35: -> definitionPartition
            {
                adaptor.addChild(root_0, stream_definitionPartition.nextTree());

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "definitionPartitionFinal"


    public static class definitionPartition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "definitionPartition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:111:1: definitionPartition : 'define' 'partition' partitionId 'by' partitionType ( ',' partitionType )* -> ^( partitionId ( ^( PARTITION_TYPE partitionType ) )+ ) ;
    public final SiddhiQLGrammarParser.definitionPartition_return definitionPartition() throws RecognitionException {
        SiddhiQLGrammarParser.definitionPartition_return retval = new SiddhiQLGrammarParser.definitionPartition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal28=null;
        Token string_literal29=null;
        Token string_literal31=null;
        Token char_literal33=null;
        SiddhiQLGrammarParser.partitionId_return partitionId30 =null;

        SiddhiQLGrammarParser.partitionType_return partitionType32 =null;

        SiddhiQLGrammarParser.partitionType_return partitionType34 =null;


        CommonTree string_literal28_tree=null;
        CommonTree string_literal29_tree=null;
        CommonTree string_literal31_tree=null;
        CommonTree char_literal33_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_126=new RewriteRuleTokenStream(adaptor,"token 126");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_partitionType=new RewriteRuleSubtreeStream(adaptor,"rule partitionType");
        RewriteRuleSubtreeStream stream_partitionId=new RewriteRuleSubtreeStream(adaptor,"rule partitionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:112:2: ( 'define' 'partition' partitionId 'by' partitionType ( ',' partitionType )* -> ^( partitionId ( ^( PARTITION_TYPE partitionType ) )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:112:3: 'define' 'partition' partitionId 'by' partitionType ( ',' partitionType )*
            {
            string_literal28=(Token)match(input,98,FOLLOW_98_in_definitionPartition529); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(string_literal28);


            string_literal29=(Token)match(input,126,FOLLOW_126_in_definitionPartition531); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_126.add(string_literal29);


            pushFollow(FOLLOW_partitionId_in_definitionPartition533);
            partitionId30=partitionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionId.add(partitionId30.getTree());

            string_literal31=(Token)match(input,95,FOLLOW_95_in_definitionPartition535); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(string_literal31);


            pushFollow(FOLLOW_partitionType_in_definitionPartition537);
            partitionType32=partitionType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionType.add(partitionType32.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:112:55: ( ',' partitionType )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt8=1;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:112:56: ',' partitionType
            	    {
            	    char_literal33=(Token)match(input,75,FOLLOW_75_in_definitionPartition540); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_75.add(char_literal33);


            	    pushFollow(FOLLOW_partitionType_in_definitionPartition542);
            	    partitionType34=partitionType();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_partitionType.add(partitionType34.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // AST REWRITE
            // elements: partitionType, partitionId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 112:77: -> ^( partitionId ( ^( PARTITION_TYPE partitionType ) )+ )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:112:80: ^( partitionId ( ^( PARTITION_TYPE partitionType ) )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_partitionId.nextNode(), root_1);

                if ( !(stream_partitionType.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_partitionType.hasNext() ) {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:112:95: ^( PARTITION_TYPE partitionType )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(PARTITION_TYPE, "PARTITION_TYPE")
                    , root_2);

                    adaptor.addChild(root_2, stream_partitionType.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_partitionType.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "definitionPartition"


    public static class partitionType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partitionType"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:115:1: partitionType : ( streamAttributeName | attributeName | 'range' condition 'as' stringVal -> condition stringVal );
    public final SiddhiQLGrammarParser.partitionType_return partitionType() throws RecognitionException {
        SiddhiQLGrammarParser.partitionType_return retval = new SiddhiQLGrammarParser.partitionType_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal37=null;
        Token string_literal39=null;
        SiddhiQLGrammarParser.streamAttributeName_return streamAttributeName35 =null;

        SiddhiQLGrammarParser.attributeName_return attributeName36 =null;

        SiddhiQLGrammarParser.condition_return condition38 =null;

        SiddhiQLGrammarParser.stringVal_return stringVal40 =null;


        CommonTree string_literal37_tree=null;
        CommonTree string_literal39_tree=null;
        RewriteRuleTokenStream stream_127=new RewriteRuleTokenStream(adaptor,"token 127");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_stringVal=new RewriteRuleSubtreeStream(adaptor,"rule stringVal");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:116:9: ( streamAttributeName | attributeName | 'range' condition 'as' stringVal -> condition stringVal )
            int alt9=3;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                switch ( input.LA(2) ) {
                case 77:
                    {
                    alt9=1;
                    }
                    break;
                case EOF:
                case 75:
                case 80:
                    {
                    alt9=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }

                }
                break;
            case 127:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:116:11: streamAttributeName
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_streamAttributeName_in_partitionType579);
                    streamAttributeName35=streamAttributeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, streamAttributeName35.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:117:11: attributeName
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeName_in_partitionType591);
                    attributeName36=attributeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeName36.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:118:11: 'range' condition 'as' stringVal
                    {
                    string_literal37=(Token)match(input,127,FOLLOW_127_in_partitionType603); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_127.add(string_literal37);


                    pushFollow(FOLLOW_condition_in_partitionType605);
                    condition38=condition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_condition.add(condition38.getTree());

                    string_literal39=(Token)match(input,93,FOLLOW_93_in_partitionType607); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_93.add(string_literal39);


                    pushFollow(FOLLOW_stringVal_in_partitionType609);
                    stringVal40=stringVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringVal.add(stringVal40.getTree());

                    // AST REWRITE
                    // elements: stringVal, condition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 118:44: -> condition stringVal
                    {
                        adaptor.addChild(root_0, stream_condition.nextTree());

                        adaptor.addChild(root_0, stream_stringVal.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partitionType"


    public static class definitionTableFinal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "definitionTableFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:121:1: definitionTableFinal : definitionTable ( ';' )? EOF -> definitionTable ;
    public final SiddhiQLGrammarParser.definitionTableFinal_return definitionTableFinal() throws RecognitionException {
        SiddhiQLGrammarParser.definitionTableFinal_return retval = new SiddhiQLGrammarParser.definitionTableFinal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal42=null;
        Token EOF43=null;
        SiddhiQLGrammarParser.definitionTable_return definitionTable41 =null;


        CommonTree char_literal42_tree=null;
        CommonTree EOF43_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_definitionTable=new RewriteRuleSubtreeStream(adaptor,"rule definitionTable");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:122:5: ( definitionTable ( ';' )? EOF -> definitionTable )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:122:6: definitionTable ( ';' )? EOF
            {
            pushFollow(FOLLOW_definitionTable_in_definitionTableFinal635);
            definitionTable41=definitionTable();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_definitionTable.add(definitionTable41.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:122:22: ( ';' )?
            int alt10=2;
            switch ( input.LA(1) ) {
                case 80:
                    {
                    alt10=1;
                    }
                    break;
            }

            switch (alt10) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:122:22: ';'
                    {
                    char_literal42=(Token)match(input,80,FOLLOW_80_in_definitionTableFinal637); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_80.add(char_literal42);


                    }
                    break;

            }


            EOF43=(Token)match(input,EOF,FOLLOW_EOF_in_definitionTableFinal640); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF43);


            // AST REWRITE
            // elements: definitionTable
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 122:31: -> definitionTable
            {
                adaptor.addChild(root_0, stream_definitionTable.nextTree());

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "definitionTableFinal"


    public static class definitionTable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "definitionTable"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:125:1: definitionTable : 'define' 'table' id '(' attributeName type ( ',' attributeName type )* ')' ( 'from' '(' tableParamName '=' tableParamValue ( ',' tableParamName '=' tableParamValue )* ')' )? -> ^( id ( ^( IN_ATTRIBUTE attributeName type ) )+ ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )? ) ;
    public final SiddhiQLGrammarParser.definitionTable_return definitionTable() throws RecognitionException {
        SiddhiQLGrammarParser.definitionTable_return retval = new SiddhiQLGrammarParser.definitionTable_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal44=null;
        Token string_literal45=null;
        Token char_literal47=null;
        Token char_literal50=null;
        Token char_literal53=null;
        Token string_literal54=null;
        Token char_literal55=null;
        Token char_literal57=null;
        Token char_literal59=null;
        Token char_literal61=null;
        Token char_literal63=null;
        SiddhiQLGrammarParser.id_return id46 =null;

        SiddhiQLGrammarParser.attributeName_return attributeName48 =null;

        SiddhiQLGrammarParser.type_return type49 =null;

        SiddhiQLGrammarParser.attributeName_return attributeName51 =null;

        SiddhiQLGrammarParser.type_return type52 =null;

        SiddhiQLGrammarParser.tableParamName_return tableParamName56 =null;

        SiddhiQLGrammarParser.tableParamValue_return tableParamValue58 =null;

        SiddhiQLGrammarParser.tableParamName_return tableParamName60 =null;

        SiddhiQLGrammarParser.tableParamValue_return tableParamValue62 =null;


        CommonTree string_literal44_tree=null;
        CommonTree string_literal45_tree=null;
        CommonTree char_literal47_tree=null;
        CommonTree char_literal50_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree string_literal54_tree=null;
        CommonTree char_literal55_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree char_literal59_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree char_literal63_tree=null;
        RewriteRuleTokenStream stream_134=new RewriteRuleTokenStream(adaptor,"token 134");
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_tableParamName=new RewriteRuleSubtreeStream(adaptor,"rule tableParamName");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_tableParamValue=new RewriteRuleSubtreeStream(adaptor,"rule tableParamValue");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:2: ( 'define' 'table' id '(' attributeName type ( ',' attributeName type )* ')' ( 'from' '(' tableParamName '=' tableParamValue ( ',' tableParamName '=' tableParamValue )* ')' )? -> ^( id ( ^( IN_ATTRIBUTE attributeName type ) )+ ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:3: 'define' 'table' id '(' attributeName type ( ',' attributeName type )* ')' ( 'from' '(' tableParamName '=' tableParamValue ( ',' tableParamName '=' tableParamValue )* ')' )?
            {
            string_literal44=(Token)match(input,98,FOLLOW_98_in_definitionTable658); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(string_literal44);


            string_literal45=(Token)match(input,134,FOLLOW_134_in_definitionTable660); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_134.add(string_literal45);


            pushFollow(FOLLOW_id_in_definitionTable662);
            id46=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id46.getTree());

            char_literal47=(Token)match(input,71,FOLLOW_71_in_definitionTable664); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(char_literal47);


            pushFollow(FOLLOW_attributeName_in_definitionTable666);
            attributeName48=attributeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributeName.add(attributeName48.getTree());

            pushFollow(FOLLOW_type_in_definitionTable668);
            type49=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type49.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:46: ( ',' attributeName type )*
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt11=1;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:47: ',' attributeName type
            	    {
            	    char_literal50=(Token)match(input,75,FOLLOW_75_in_definitionTable671); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_75.add(char_literal50);


            	    pushFollow(FOLLOW_attributeName_in_definitionTable673);
            	    attributeName51=attributeName();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attributeName.add(attributeName51.getTree());

            	    pushFollow(FOLLOW_type_in_definitionTable675);
            	    type52=type();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_type.add(type52.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            char_literal53=(Token)match(input,72,FOLLOW_72_in_definitionTable680); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal53);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:77: ( 'from' '(' tableParamName '=' tableParamValue ( ',' tableParamName '=' tableParamValue )* ')' )?
            int alt13=2;
            switch ( input.LA(1) ) {
                case 107:
                    {
                    alt13=1;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:78: 'from' '(' tableParamName '=' tableParamValue ( ',' tableParamName '=' tableParamValue )* ')'
                    {
                    string_literal54=(Token)match(input,107,FOLLOW_107_in_definitionTable683); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_107.add(string_literal54);


                    char_literal55=(Token)match(input,71,FOLLOW_71_in_definitionTable685); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal55);


                    pushFollow(FOLLOW_tableParamName_in_definitionTable687);
                    tableParamName56=tableParamName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tableParamName.add(tableParamName56.getTree());

                    char_literal57=(Token)match(input,83,FOLLOW_83_in_definitionTable689); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_83.add(char_literal57);


                    pushFollow(FOLLOW_tableParamValue_in_definitionTable691);
                    tableParamValue58=tableParamValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tableParamValue.add(tableParamValue58.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:124: ( ',' tableParamName '=' tableParamValue )*
                    loop12:
                    do {
                        int alt12=2;
                        switch ( input.LA(1) ) {
                        case 75:
                            {
                            alt12=1;
                            }
                            break;

                        }

                        switch (alt12) {
                    	case 1 :
                    	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:125: ',' tableParamName '=' tableParamValue
                    	    {
                    	    char_literal59=(Token)match(input,75,FOLLOW_75_in_definitionTable694); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_75.add(char_literal59);


                    	    pushFollow(FOLLOW_tableParamName_in_definitionTable696);
                    	    tableParamName60=tableParamName();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_tableParamName.add(tableParamName60.getTree());

                    	    char_literal61=(Token)match(input,83,FOLLOW_83_in_definitionTable698); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_83.add(char_literal61);


                    	    pushFollow(FOLLOW_tableParamValue_in_definitionTable700);
                    	    tableParamValue62=tableParamValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_tableParamValue.add(tableParamValue62.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    char_literal63=(Token)match(input,72,FOLLOW_72_in_definitionTable705); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal63);


                    }
                    break;

            }


            // AST REWRITE
            // elements: type, tableParamName, tableParamValue, attributeName, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 126:175: -> ^( id ( ^( IN_ATTRIBUTE attributeName type ) )+ ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:179: ^( id ( ^( IN_ATTRIBUTE attributeName type ) )+ ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_id.nextNode(), root_1);

                if ( !(stream_type.hasNext()||stream_attributeName.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_type.hasNext()||stream_attributeName.hasNext() ) {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:185: ^( IN_ATTRIBUTE attributeName type )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(IN_ATTRIBUTE, "IN_ATTRIBUTE")
                    , root_2);

                    adaptor.addChild(root_2, stream_attributeName.nextTree());

                    adaptor.addChild(root_2, stream_type.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_type.reset();
                stream_attributeName.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:222: ( ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ ) )?
                if ( stream_tableParamName.hasNext()||stream_tableParamValue.hasNext() ) {
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:222: ^( TABLE ( ^( TABLE_PARAMETER tableParamName tableParamValue ) )+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(TABLE, "TABLE")
                    , root_2);

                    if ( !(stream_tableParamName.hasNext()||stream_tableParamValue.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_tableParamName.hasNext()||stream_tableParamValue.hasNext() ) {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:126:231: ^( TABLE_PARAMETER tableParamName tableParamValue )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(TABLE_PARAMETER, "TABLE_PARAMETER")
                        , root_3);

                        adaptor.addChild(root_3, stream_tableParamName.nextTree());

                        adaptor.addChild(root_3, stream_tableParamValue.nextTree());

                        adaptor.addChild(root_2, root_3);
                        }

                    }
                    stream_tableParamName.reset();
                    stream_tableParamValue.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_tableParamName.reset();
                stream_tableParamValue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "definitionTable"


    public static class queryFinal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "queryFinal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:129:1: queryFinal : query ( ';' )? EOF -> query ;
    public final SiddhiQLGrammarParser.queryFinal_return queryFinal() throws RecognitionException {
        SiddhiQLGrammarParser.queryFinal_return retval = new SiddhiQLGrammarParser.queryFinal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal65=null;
        Token EOF66=null;
        SiddhiQLGrammarParser.query_return query64 =null;


        CommonTree char_literal65_tree=null;
        CommonTree EOF66_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_query=new RewriteRuleSubtreeStream(adaptor,"rule query");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:130:5: ( query ( ';' )? EOF -> query )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:130:6: query ( ';' )? EOF
            {
            pushFollow(FOLLOW_query_in_queryFinal758);
            query64=query();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_query.add(query64.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:130:12: ( ';' )?
            int alt14=2;
            switch ( input.LA(1) ) {
                case 80:
                    {
                    alt14=1;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:130:12: ';'
                    {
                    char_literal65=(Token)match(input,80,FOLLOW_80_in_queryFinal760); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_80.add(char_literal65);


                    }
                    break;

            }


            EOF66=(Token)match(input,EOF,FOLLOW_EOF_in_queryFinal763); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF66);


            // AST REWRITE
            // elements: query
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 130:21: -> query
            {
                adaptor.addChild(root_0, stream_query.nextTree());

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "queryFinal"


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:133:1: query : ( inputStream outputSelection ( output )? outputStream ( partition )? -> ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? ) | inputStream outputSelection ( output )? ( 'return' )? ( partition )? -> ^( QUERY inputStream outputSelection ( output )? ( partition )? ) );
    public final SiddhiQLGrammarParser.query_return query() throws RecognitionException {
        SiddhiQLGrammarParser.query_return retval = new SiddhiQLGrammarParser.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal75=null;
        SiddhiQLGrammarParser.inputStream_return inputStream67 =null;

        SiddhiQLGrammarParser.outputSelection_return outputSelection68 =null;

        SiddhiQLGrammarParser.output_return output69 =null;

        SiddhiQLGrammarParser.outputStream_return outputStream70 =null;

        SiddhiQLGrammarParser.partition_return partition71 =null;

        SiddhiQLGrammarParser.inputStream_return inputStream72 =null;

        SiddhiQLGrammarParser.outputSelection_return outputSelection73 =null;

        SiddhiQLGrammarParser.output_return output74 =null;

        SiddhiQLGrammarParser.partition_return partition76 =null;


        CommonTree string_literal75_tree=null;
        RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
        RewriteRuleSubtreeStream stream_partition=new RewriteRuleSubtreeStream(adaptor,"rule partition");
        RewriteRuleSubtreeStream stream_inputStream=new RewriteRuleSubtreeStream(adaptor,"rule inputStream");
        RewriteRuleSubtreeStream stream_outputStream=new RewriteRuleSubtreeStream(adaptor,"rule outputStream");
        RewriteRuleSubtreeStream stream_outputSelection=new RewriteRuleSubtreeStream(adaptor,"rule outputSelection");
        RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:2: ( inputStream outputSelection ( output )? outputStream ( partition )? -> ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? ) | inputStream outputSelection ( output )? ( 'return' )? ( partition )? -> ^( QUERY inputStream outputSelection ( output )? ( partition )? ) )
            int alt20=2;
            switch ( input.LA(1) ) {
            case 107:
                {
                int LA20_1 = input.LA(2);

                if ( (synpred22_SiddhiQLGrammar()) ) {
                    alt20=1;
                }
                else if ( (true) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }

            switch (alt20) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:3: inputStream outputSelection ( output )? outputStream ( partition )?
                    {
                    pushFollow(FOLLOW_inputStream_in_query780);
                    inputStream67=inputStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inputStream.add(inputStream67.getTree());

                    pushFollow(FOLLOW_outputSelection_in_query782);
                    outputSelection68=outputSelection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputSelection.add(outputSelection68.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:31: ( output )?
                    int alt15=2;
                    switch ( input.LA(1) ) {
                        case 125:
                            {
                            alt15=1;
                            }
                            break;
                    }

                    switch (alt15) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:31: output
                            {
                            pushFollow(FOLLOW_output_in_query784);
                            output69=output();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_output.add(output69.getTree());

                            }
                            break;

                    }


                    pushFollow(FOLLOW_outputStream_in_query787);
                    outputStream70=outputStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputStream.add(outputStream70.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:52: ( partition )?
                    int alt16=2;
                    switch ( input.LA(1) ) {
                        case 126:
                            {
                            alt16=1;
                            }
                            break;
                    }

                    switch (alt16) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:52: partition
                            {
                            pushFollow(FOLLOW_partition_in_query789);
                            partition71=partition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_partition.add(partition71.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: output, partition, inputStream, outputStream, outputSelection
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 134:63: -> ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:67: ^( QUERY inputStream outputSelection outputStream ( output )? ( partition )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(QUERY, "QUERY")
                        , root_1);

                        adaptor.addChild(root_1, stream_inputStream.nextTree());

                        adaptor.addChild(root_1, stream_outputSelection.nextTree());

                        adaptor.addChild(root_1, stream_outputStream.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:116: ( output )?
                        if ( stream_output.hasNext() ) {
                            adaptor.addChild(root_1, stream_output.nextTree());

                        }
                        stream_output.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:124: ( partition )?
                        if ( stream_partition.hasNext() ) {
                            adaptor.addChild(root_1, stream_partition.nextTree());

                        }
                        stream_partition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:3: inputStream outputSelection ( output )? ( 'return' )? ( partition )?
                    {
                    pushFollow(FOLLOW_inputStream_in_query813);
                    inputStream72=inputStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inputStream.add(inputStream72.getTree());

                    pushFollow(FOLLOW_outputSelection_in_query815);
                    outputSelection73=outputSelection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputSelection.add(outputSelection73.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:31: ( output )?
                    int alt17=2;
                    switch ( input.LA(1) ) {
                        case 125:
                            {
                            alt17=1;
                            }
                            break;
                    }

                    switch (alt17) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:31: output
                            {
                            pushFollow(FOLLOW_output_in_query817);
                            output74=output();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_output.add(output74.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:39: ( 'return' )?
                    int alt18=2;
                    switch ( input.LA(1) ) {
                        case 128:
                            {
                            alt18=1;
                            }
                            break;
                    }

                    switch (alt18) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:39: 'return'
                            {
                            string_literal75=(Token)match(input,128,FOLLOW_128_in_query820); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_128.add(string_literal75);


                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:49: ( partition )?
                    int alt19=2;
                    switch ( input.LA(1) ) {
                        case 126:
                            {
                            alt19=1;
                            }
                            break;
                    }

                    switch (alt19) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:49: partition
                            {
                            pushFollow(FOLLOW_partition_in_query823);
                            partition76=partition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_partition.add(partition76.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: inputStream, output, outputSelection, partition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 135:60: -> ^( QUERY inputStream outputSelection ( output )? ( partition )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:64: ^( QUERY inputStream outputSelection ( output )? ( partition )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(QUERY, "QUERY")
                        , root_1);

                        adaptor.addChild(root_1, stream_inputStream.nextTree());

                        adaptor.addChild(root_1, stream_outputSelection.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:100: ( output )?
                        if ( stream_output.hasNext() ) {
                            adaptor.addChild(root_1, stream_output.nextTree());

                        }
                        stream_output.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:135:108: ( partition )?
                        if ( stream_partition.hasNext() ) {
                            adaptor.addChild(root_1, stream_partition.nextTree());

                        }
                        stream_partition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    public static class outputStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "outputStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:138:1: outputStream : ( 'insert' 'into' streamId ( outputTypeCondition )? -> ^( INSERT_INTO_STREAM streamId ( outputTypeCondition )? ) | 'delete' id ( outputTypeCondition )? ( 'on' condition )? -> ^( DELETE_STREAM id ( outputTypeCondition )? ( condition )? ) | 'update' id ( outputTypeCondition )? ( 'on' condition )? -> ^( UPDATE_STREAM id ( outputTypeCondition )? ( condition )? ) );
    public final SiddhiQLGrammarParser.outputStream_return outputStream() throws RecognitionException {
        SiddhiQLGrammarParser.outputStream_return retval = new SiddhiQLGrammarParser.outputStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal77=null;
        Token string_literal78=null;
        Token string_literal81=null;
        Token string_literal84=null;
        Token string_literal86=null;
        Token string_literal89=null;
        SiddhiQLGrammarParser.streamId_return streamId79 =null;

        SiddhiQLGrammarParser.outputTypeCondition_return outputTypeCondition80 =null;

        SiddhiQLGrammarParser.id_return id82 =null;

        SiddhiQLGrammarParser.outputTypeCondition_return outputTypeCondition83 =null;

        SiddhiQLGrammarParser.condition_return condition85 =null;

        SiddhiQLGrammarParser.id_return id87 =null;

        SiddhiQLGrammarParser.outputTypeCondition_return outputTypeCondition88 =null;

        SiddhiQLGrammarParser.condition_return condition90 =null;


        CommonTree string_literal77_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree string_literal84_tree=null;
        CommonTree string_literal86_tree=null;
        CommonTree string_literal89_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleTokenStream stream_137=new RewriteRuleTokenStream(adaptor,"token 137");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_streamId=new RewriteRuleSubtreeStream(adaptor,"rule streamId");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_outputTypeCondition=new RewriteRuleSubtreeStream(adaptor,"rule outputTypeCondition");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:139:2: ( 'insert' 'into' streamId ( outputTypeCondition )? -> ^( INSERT_INTO_STREAM streamId ( outputTypeCondition )? ) | 'delete' id ( outputTypeCondition )? ( 'on' condition )? -> ^( DELETE_STREAM id ( outputTypeCondition )? ( condition )? ) | 'update' id ( outputTypeCondition )? ( 'on' condition )? -> ^( UPDATE_STREAM id ( outputTypeCondition )? ( condition )? ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt26=1;
                }
                break;
            case 99:
                {
                alt26=2;
                }
                break;
            case 137:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:139:3: 'insert' 'into' streamId ( outputTypeCondition )?
                    {
                    string_literal77=(Token)match(input,113,FOLLOW_113_in_outputStream852); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_113.add(string_literal77);


                    string_literal78=(Token)match(input,116,FOLLOW_116_in_outputStream854); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_116.add(string_literal78);


                    pushFollow(FOLLOW_streamId_in_outputStream856);
                    streamId79=streamId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_streamId.add(streamId79.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:139:28: ( outputTypeCondition )?
                    int alt21=2;
                    switch ( input.LA(1) ) {
                        case 106:
                            {
                            alt21=1;
                            }
                            break;
                    }

                    switch (alt21) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:139:28: outputTypeCondition
                            {
                            pushFollow(FOLLOW_outputTypeCondition_in_outputStream858);
                            outputTypeCondition80=outputTypeCondition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_outputTypeCondition.add(outputTypeCondition80.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: streamId, outputTypeCondition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 139:49: -> ^( INSERT_INTO_STREAM streamId ( outputTypeCondition )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:139:52: ^( INSERT_INTO_STREAM streamId ( outputTypeCondition )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(INSERT_INTO_STREAM, "INSERT_INTO_STREAM")
                        , root_1);

                        adaptor.addChild(root_1, stream_streamId.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:139:82: ( outputTypeCondition )?
                        if ( stream_outputTypeCondition.hasNext() ) {
                            adaptor.addChild(root_1, stream_outputTypeCondition.nextTree());

                        }
                        stream_outputTypeCondition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:3: 'delete' id ( outputTypeCondition )? ( 'on' condition )?
                    {
                    string_literal81=(Token)match(input,99,FOLLOW_99_in_outputStream874); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_99.add(string_literal81);


                    pushFollow(FOLLOW_id_in_outputStream876);
                    id82=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id82.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:15: ( outputTypeCondition )?
                    int alt22=2;
                    switch ( input.LA(1) ) {
                        case 106:
                            {
                            alt22=1;
                            }
                            break;
                    }

                    switch (alt22) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:15: outputTypeCondition
                            {
                            pushFollow(FOLLOW_outputTypeCondition_in_outputStream878);
                            outputTypeCondition83=outputTypeCondition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_outputTypeCondition.add(outputTypeCondition83.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:36: ( 'on' condition )?
                    int alt23=2;
                    switch ( input.LA(1) ) {
                        case 122:
                            {
                            alt23=1;
                            }
                            break;
                    }

                    switch (alt23) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:37: 'on' condition
                            {
                            string_literal84=(Token)match(input,122,FOLLOW_122_in_outputStream882); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_122.add(string_literal84);


                            pushFollow(FOLLOW_condition_in_outputStream884);
                            condition85=condition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_condition.add(condition85.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: id, outputTypeCondition, condition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 140:55: -> ^( DELETE_STREAM id ( outputTypeCondition )? ( condition )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:58: ^( DELETE_STREAM id ( outputTypeCondition )? ( condition )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(DELETE_STREAM, "DELETE_STREAM")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:77: ( outputTypeCondition )?
                        if ( stream_outputTypeCondition.hasNext() ) {
                            adaptor.addChild(root_1, stream_outputTypeCondition.nextTree());

                        }
                        stream_outputTypeCondition.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:140:98: ( condition )?
                        if ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_1, stream_condition.nextTree());

                        }
                        stream_condition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:3: 'update' id ( outputTypeCondition )? ( 'on' condition )?
                    {
                    string_literal86=(Token)match(input,137,FOLLOW_137_in_outputStream905); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_137.add(string_literal86);


                    pushFollow(FOLLOW_id_in_outputStream907);
                    id87=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id87.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:15: ( outputTypeCondition )?
                    int alt24=2;
                    switch ( input.LA(1) ) {
                        case 106:
                            {
                            alt24=1;
                            }
                            break;
                    }

                    switch (alt24) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:15: outputTypeCondition
                            {
                            pushFollow(FOLLOW_outputTypeCondition_in_outputStream909);
                            outputTypeCondition88=outputTypeCondition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_outputTypeCondition.add(outputTypeCondition88.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:36: ( 'on' condition )?
                    int alt25=2;
                    switch ( input.LA(1) ) {
                        case 122:
                            {
                            alt25=1;
                            }
                            break;
                    }

                    switch (alt25) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:37: 'on' condition
                            {
                            string_literal89=(Token)match(input,122,FOLLOW_122_in_outputStream913); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_122.add(string_literal89);


                            pushFollow(FOLLOW_condition_in_outputStream915);
                            condition90=condition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_condition.add(condition90.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: condition, outputTypeCondition, id
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 141:55: -> ^( UPDATE_STREAM id ( outputTypeCondition )? ( condition )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:58: ^( UPDATE_STREAM id ( outputTypeCondition )? ( condition )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(UPDATE_STREAM, "UPDATE_STREAM")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:77: ( outputTypeCondition )?
                        if ( stream_outputTypeCondition.hasNext() ) {
                            adaptor.addChild(root_1, stream_outputTypeCondition.nextTree());

                        }
                        stream_outputTypeCondition.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:141:98: ( condition )?
                        if ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_1, stream_condition.nextTree());

                        }
                        stream_condition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outputStream"


    public static class outputTypeCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "outputTypeCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:144:1: outputTypeCondition : ( 'for' ! 'expired-events' | 'for' ! 'current-events' | 'for' ! 'all-events' );
    public final SiddhiQLGrammarParser.outputTypeCondition_return outputTypeCondition() throws RecognitionException {
        SiddhiQLGrammarParser.outputTypeCondition_return retval = new SiddhiQLGrammarParser.outputTypeCondition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal91=null;
        Token string_literal92=null;
        Token string_literal93=null;
        Token string_literal94=null;
        Token string_literal95=null;
        Token string_literal96=null;

        CommonTree string_literal91_tree=null;
        CommonTree string_literal92_tree=null;
        CommonTree string_literal93_tree=null;
        CommonTree string_literal94_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree string_literal96_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:145:2: ( 'for' ! 'expired-events' | 'for' ! 'current-events' | 'for' ! 'all-events' )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 106:
                {
                switch ( input.LA(2) ) {
                case 103:
                    {
                    alt27=1;
                    }
                    break;
                case 97:
                    {
                    alt27=2;
                    }
                    break;
                case 91:
                    {
                    alt27=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:145:4: 'for' ! 'expired-events'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    string_literal91=(Token)match(input,106,FOLLOW_106_in_outputTypeCondition943); if (state.failed) return retval;

                    string_literal92=(Token)match(input,103,FOLLOW_103_in_outputTypeCondition946); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = 
                    (CommonTree)adaptor.create(string_literal92)
                    ;
                    adaptor.addChild(root_0, string_literal92_tree);
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:145:30: 'for' ! 'current-events'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    string_literal93=(Token)match(input,106,FOLLOW_106_in_outputTypeCondition950); if (state.failed) return retval;

                    string_literal94=(Token)match(input,97,FOLLOW_97_in_outputTypeCondition953); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = 
                    (CommonTree)adaptor.create(string_literal94)
                    ;
                    adaptor.addChild(root_0, string_literal94_tree);
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:145:56: 'for' ! 'all-events'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    string_literal95=(Token)match(input,106,FOLLOW_106_in_outputTypeCondition957); if (state.failed) return retval;

                    string_literal96=(Token)match(input,91,FOLLOW_91_in_outputTypeCondition960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = 
                    (CommonTree)adaptor.create(string_literal96)
                    ;
                    adaptor.addChild(root_0, string_literal96_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outputTypeCondition"


    public static class inputStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inputStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:148:1: inputStream : 'from' ( sequenceFullStream -> ^( SEQUENCE_FULL sequenceFullStream ) | patternFullStream -> ^( PATTERN_FULL patternFullStream ) | joinStream -> ^( JOIN joinStream ) | windowStream -> windowStream | basicStream -> basicStream ) ;
    public final SiddhiQLGrammarParser.inputStream_return inputStream() throws RecognitionException {
        SiddhiQLGrammarParser.inputStream_return retval = new SiddhiQLGrammarParser.inputStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal97=null;
        SiddhiQLGrammarParser.sequenceFullStream_return sequenceFullStream98 =null;

        SiddhiQLGrammarParser.patternFullStream_return patternFullStream99 =null;

        SiddhiQLGrammarParser.joinStream_return joinStream100 =null;

        SiddhiQLGrammarParser.windowStream_return windowStream101 =null;

        SiddhiQLGrammarParser.basicStream_return basicStream102 =null;


        CommonTree string_literal97_tree=null;
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleSubtreeStream stream_sequenceFullStream=new RewriteRuleSubtreeStream(adaptor,"rule sequenceFullStream");
        RewriteRuleSubtreeStream stream_windowStream=new RewriteRuleSubtreeStream(adaptor,"rule windowStream");
        RewriteRuleSubtreeStream stream_patternFullStream=new RewriteRuleSubtreeStream(adaptor,"rule patternFullStream");
        RewriteRuleSubtreeStream stream_basicStream=new RewriteRuleSubtreeStream(adaptor,"rule basicStream");
        RewriteRuleSubtreeStream stream_joinStream=new RewriteRuleSubtreeStream(adaptor,"rule joinStream");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:149:2: ( 'from' ( sequenceFullStream -> ^( SEQUENCE_FULL sequenceFullStream ) | patternFullStream -> ^( PATTERN_FULL patternFullStream ) | joinStream -> ^( JOIN joinStream ) | windowStream -> windowStream | basicStream -> basicStream ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:149:3: 'from' ( sequenceFullStream -> ^( SEQUENCE_FULL sequenceFullStream ) | patternFullStream -> ^( PATTERN_FULL patternFullStream ) | joinStream -> ^( JOIN joinStream ) | windowStream -> windowStream | basicStream -> basicStream )
            {
            string_literal97=(Token)match(input,107,FOLLOW_107_in_inputStream970); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_107.add(string_literal97);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:149:10: ( sequenceFullStream -> ^( SEQUENCE_FULL sequenceFullStream ) | patternFullStream -> ^( PATTERN_FULL patternFullStream ) | joinStream -> ^( JOIN joinStream ) | windowStream -> windowStream | basicStream -> basicStream )
            int alt28=5;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                int LA28_1 = input.LA(2);

                if ( (synpred35_SiddhiQLGrammar()) ) {
                    alt28=1;
                }
                else if ( (synpred36_SiddhiQLGrammar()) ) {
                    alt28=2;
                }
                else if ( (synpred37_SiddhiQLGrammar()) ) {
                    alt28=3;
                }
                else if ( (synpred38_SiddhiQLGrammar()) ) {
                    alt28=4;
                }
                else if ( (true) ) {
                    alt28=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;

                }
                }
                break;
            case 71:
                {
                int LA28_2 = input.LA(2);

                if ( (synpred36_SiddhiQLGrammar()) ) {
                    alt28=2;
                }
                else if ( (synpred37_SiddhiQLGrammar()) ) {
                    alt28=3;
                }
                else if ( (synpred38_SiddhiQLGrammar()) ) {
                    alt28=4;
                }
                else if ( (true) ) {
                    alt28=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;

                }
                }
                break;
            case 102:
                {
                alt28=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:149:12: sequenceFullStream
                    {
                    pushFollow(FOLLOW_sequenceFullStream_in_inputStream974);
                    sequenceFullStream98=sequenceFullStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_sequenceFullStream.add(sequenceFullStream98.getTree());

                    // AST REWRITE
                    // elements: sequenceFullStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 149:31: -> ^( SEQUENCE_FULL sequenceFullStream )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:149:34: ^( SEQUENCE_FULL sequenceFullStream )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(SEQUENCE_FULL, "SEQUENCE_FULL")
                        , root_1);

                        adaptor.addChild(root_1, stream_sequenceFullStream.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:150:5: patternFullStream
                    {
                    pushFollow(FOLLOW_patternFullStream_in_inputStream988);
                    patternFullStream99=patternFullStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_patternFullStream.add(patternFullStream99.getTree());

                    // AST REWRITE
                    // elements: patternFullStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 150:23: -> ^( PATTERN_FULL patternFullStream )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:150:27: ^( PATTERN_FULL patternFullStream )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(PATTERN_FULL, "PATTERN_FULL")
                        , root_1);

                        adaptor.addChild(root_1, stream_patternFullStream.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:151:5: joinStream
                    {
                    pushFollow(FOLLOW_joinStream_in_inputStream1005);
                    joinStream100=joinStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_joinStream.add(joinStream100.getTree());

                    // AST REWRITE
                    // elements: joinStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 151:16: -> ^( JOIN joinStream )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:151:19: ^( JOIN joinStream )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(JOIN, "JOIN")
                        , root_1);

                        adaptor.addChild(root_1, stream_joinStream.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:152:5: windowStream
                    {
                    pushFollow(FOLLOW_windowStream_in_inputStream1020);
                    windowStream101=windowStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_windowStream.add(windowStream101.getTree());

                    // AST REWRITE
                    // elements: windowStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 152:18: -> windowStream
                    {
                        adaptor.addChild(root_0, stream_windowStream.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:153:5: basicStream
                    {
                    pushFollow(FOLLOW_basicStream_in_inputStream1030);
                    basicStream102=basicStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_basicStream.add(basicStream102.getTree());

                    // AST REWRITE
                    // elements: basicStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 153:18: -> basicStream
                    {
                        adaptor.addChild(root_0, stream_basicStream.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inputStream"


    public static class output_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:157:1: output : ( 'output' ( outputType )? 'every' ( timeExpr -> ^( OUTPUT timeExpr ( outputType )? ) | POSITIVE_INT_VAL 'events' -> ^( OUTPUT POSITIVE_INT_VAL ( outputType )? ) ) | 'output' 'snapshot' 'every' timeExpr -> ^( OUTPUT timeExpr SNAPSHOT ) );
    public final SiddhiQLGrammarParser.output_return output() throws RecognitionException {
        SiddhiQLGrammarParser.output_return retval = new SiddhiQLGrammarParser.output_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal103=null;
        Token string_literal105=null;
        Token POSITIVE_INT_VAL107=null;
        Token string_literal108=null;
        Token string_literal109=null;
        Token string_literal110=null;
        Token string_literal111=null;
        SiddhiQLGrammarParser.outputType_return outputType104 =null;

        SiddhiQLGrammarParser.timeExpr_return timeExpr106 =null;

        SiddhiQLGrammarParser.timeExpr_return timeExpr112 =null;


        CommonTree string_literal103_tree=null;
        CommonTree string_literal105_tree=null;
        CommonTree POSITIVE_INT_VAL107_tree=null;
        CommonTree string_literal108_tree=null;
        CommonTree string_literal109_tree=null;
        CommonTree string_literal110_tree=null;
        CommonTree string_literal111_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleTokenStream stream_131=new RewriteRuleTokenStream(adaptor,"token 131");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
        RewriteRuleSubtreeStream stream_timeExpr=new RewriteRuleSubtreeStream(adaptor,"rule timeExpr");
        RewriteRuleSubtreeStream stream_outputType=new RewriteRuleSubtreeStream(adaptor,"rule outputType");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:2: ( 'output' ( outputType )? 'every' ( timeExpr -> ^( OUTPUT timeExpr ( outputType )? ) | POSITIVE_INT_VAL 'events' -> ^( OUTPUT POSITIVE_INT_VAL ( outputType )? ) ) | 'output' 'snapshot' 'every' timeExpr -> ^( OUTPUT timeExpr SNAPSHOT ) )
            int alt31=2;
            switch ( input.LA(1) ) {
            case 125:
                {
                switch ( input.LA(2) ) {
                case 131:
                    {
                    alt31=2;
                    }
                    break;
                case 90:
                case 102:
                case 104:
                case 118:
                    {
                    alt31=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:4: 'output' ( outputType )? 'every' ( timeExpr -> ^( OUTPUT timeExpr ( outputType )? ) | POSITIVE_INT_VAL 'events' -> ^( OUTPUT POSITIVE_INT_VAL ( outputType )? ) )
                    {
                    string_literal103=(Token)match(input,125,FOLLOW_125_in_output1052); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_125.add(string_literal103);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:13: ( outputType )?
                    int alt29=2;
                    switch ( input.LA(1) ) {
                        case 90:
                        case 104:
                        case 118:
                            {
                            alt29=1;
                            }
                            break;
                    }

                    switch (alt29) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:13: outputType
                            {
                            pushFollow(FOLLOW_outputType_in_output1054);
                            outputType104=outputType();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_outputType.add(outputType104.getTree());

                            }
                            break;

                    }


                    string_literal105=(Token)match(input,102,FOLLOW_102_in_output1057); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_102.add(string_literal105);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:33: ( timeExpr -> ^( OUTPUT timeExpr ( outputType )? ) | POSITIVE_INT_VAL 'events' -> ^( OUTPUT POSITIVE_INT_VAL ( outputType )? ) )
                    int alt30=2;
                    switch ( input.LA(1) ) {
                    case POSITIVE_INT_VAL:
                        {
                        switch ( input.LA(2) ) {
                        case 101:
                            {
                            alt30=2;
                            }
                            break;
                        case ID:
                            {
                            alt30=1;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 30, 1, input);

                            throw nvae;

                        }

                        }
                        break;
                    case EOF:
                    case 80:
                    case 99:
                    case 113:
                    case 126:
                    case 128:
                    case 137:
                        {
                        alt30=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;

                    }

                    switch (alt30) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:35: timeExpr
                            {
                            pushFollow(FOLLOW_timeExpr_in_output1061);
                            timeExpr106=timeExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_timeExpr.add(timeExpr106.getTree());

                            // AST REWRITE
                            // elements: timeExpr, outputType
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {

                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 158:46: -> ^( OUTPUT timeExpr ( outputType )? )
                            {
                                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:50: ^( OUTPUT timeExpr ( outputType )? )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(OUTPUT, "OUTPUT")
                                , root_1);

                                adaptor.addChild(root_1, stream_timeExpr.nextTree());

                                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:158:68: ( outputType )?
                                if ( stream_outputType.hasNext() ) {
                                    adaptor.addChild(root_1, stream_outputType.nextTree());

                                }
                                stream_outputType.reset();

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;
                            }

                            }
                            break;
                        case 2 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:159:36: POSITIVE_INT_VAL 'events'
                            {
                            POSITIVE_INT_VAL107=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_output1113); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL107);


                            string_literal108=(Token)match(input,101,FOLLOW_101_in_output1115); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_101.add(string_literal108);


                            // AST REWRITE
                            // elements: POSITIVE_INT_VAL, outputType
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {

                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 159:62: -> ^( OUTPUT POSITIVE_INT_VAL ( outputType )? )
                            {
                                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:159:66: ^( OUTPUT POSITIVE_INT_VAL ( outputType )? )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(OUTPUT, "OUTPUT")
                                , root_1);

                                adaptor.addChild(root_1, 
                                stream_POSITIVE_INT_VAL.nextNode()
                                );

                                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:159:92: ( outputType )?
                                if ( stream_outputType.hasNext() ) {
                                    adaptor.addChild(root_1, stream_outputType.nextTree());

                                }
                                stream_outputType.reset();

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:161:4: 'output' 'snapshot' 'every' timeExpr
                    {
                    string_literal109=(Token)match(input,125,FOLLOW_125_in_output1136); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_125.add(string_literal109);


                    string_literal110=(Token)match(input,131,FOLLOW_131_in_output1138); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_131.add(string_literal110);


                    string_literal111=(Token)match(input,102,FOLLOW_102_in_output1140); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_102.add(string_literal111);


                    pushFollow(FOLLOW_timeExpr_in_output1142);
                    timeExpr112=timeExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_timeExpr.add(timeExpr112.getTree());

                    // AST REWRITE
                    // elements: timeExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 161:43: -> ^( OUTPUT timeExpr SNAPSHOT )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:161:47: ^( OUTPUT timeExpr SNAPSHOT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(OUTPUT, "OUTPUT")
                        , root_1);

                        adaptor.addChild(root_1, stream_timeExpr.nextTree());

                        adaptor.addChild(root_1, 
                        (CommonTree)adaptor.create(SNAPSHOT, "SNAPSHOT")
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output"


    public static class outputType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "outputType"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:164:1: outputType : ( 'all' | 'last' | 'first' );
    public final SiddhiQLGrammarParser.outputType_return outputType() throws RecognitionException {
        SiddhiQLGrammarParser.outputType_return retval = new SiddhiQLGrammarParser.outputType_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set113=null;

        CommonTree set113_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:165:2: ( 'all' | 'last' | 'first' )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set113=(Token)input.LT(1);

            if ( input.LA(1)==90||input.LA(1)==104||input.LA(1)==118 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set113)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outputType"


    public static class partition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:170:1: partition : 'partition' 'by' partitionId -> ^( PARTITION partitionId ) ;
    public final SiddhiQLGrammarParser.partition_return partition() throws RecognitionException {
        SiddhiQLGrammarParser.partition_return retval = new SiddhiQLGrammarParser.partition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal114=null;
        Token string_literal115=null;
        SiddhiQLGrammarParser.partitionId_return partitionId116 =null;


        CommonTree string_literal114_tree=null;
        CommonTree string_literal115_tree=null;
        RewriteRuleTokenStream stream_126=new RewriteRuleTokenStream(adaptor,"token 126");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleSubtreeStream stream_partitionId=new RewriteRuleSubtreeStream(adaptor,"rule partitionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:171:2: ( 'partition' 'by' partitionId -> ^( PARTITION partitionId ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:171:3: 'partition' 'by' partitionId
            {
            string_literal114=(Token)match(input,126,FOLLOW_126_in_partition1186); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_126.add(string_literal114);


            string_literal115=(Token)match(input,95,FOLLOW_95_in_partition1188); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(string_literal115);


            pushFollow(FOLLOW_partitionId_in_partition1190);
            partitionId116=partitionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionId.add(partitionId116.getTree());

            // AST REWRITE
            // elements: partitionId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 171:32: -> ^( PARTITION partitionId )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:171:35: ^( PARTITION partitionId )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PARTITION, "PARTITION")
                , root_1);

                adaptor.addChild(root_1, stream_partitionId.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition"


    public static class patternFullStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "patternFullStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:174:1: patternFullStream : ( '(' patternStream ')' ( 'within' time )? -> ^( PATTERN patternStream ( time )? ) | patternStream ( 'within' time )? -> ^( PATTERN patternStream ( time )? ) );
    public final SiddhiQLGrammarParser.patternFullStream_return patternFullStream() throws RecognitionException {
        SiddhiQLGrammarParser.patternFullStream_return retval = new SiddhiQLGrammarParser.patternFullStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal117=null;
        Token char_literal119=null;
        Token string_literal120=null;
        Token string_literal123=null;
        SiddhiQLGrammarParser.patternStream_return patternStream118 =null;

        SiddhiQLGrammarParser.time_return time121 =null;

        SiddhiQLGrammarParser.patternStream_return patternStream122 =null;

        SiddhiQLGrammarParser.time_return time124 =null;


        CommonTree char_literal117_tree=null;
        CommonTree char_literal119_tree=null;
        CommonTree string_literal120_tree=null;
        CommonTree string_literal123_tree=null;
        RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_time=new RewriteRuleSubtreeStream(adaptor,"rule time");
        RewriteRuleSubtreeStream stream_patternStream=new RewriteRuleSubtreeStream(adaptor,"rule patternStream");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:175:2: ( '(' patternStream ')' ( 'within' time )? -> ^( PATTERN patternStream ( time )? ) | patternStream ( 'within' time )? -> ^( PATTERN patternStream ( time )? ) )
            int alt34=2;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt34=1;
                }
                break;
            case ID:
            case ID_QUOTES:
            case 102:
                {
                alt34=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:175:3: '(' patternStream ')' ( 'within' time )?
                    {
                    char_literal117=(Token)match(input,71,FOLLOW_71_in_patternFullStream1212); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal117);


                    pushFollow(FOLLOW_patternStream_in_patternFullStream1214);
                    patternStream118=patternStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_patternStream.add(patternStream118.getTree());

                    char_literal119=(Token)match(input,72,FOLLOW_72_in_patternFullStream1216); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal119);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:175:25: ( 'within' time )?
                    int alt32=2;
                    switch ( input.LA(1) ) {
                        case 139:
                            {
                            alt32=1;
                            }
                            break;
                    }

                    switch (alt32) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:175:26: 'within' time
                            {
                            string_literal120=(Token)match(input,139,FOLLOW_139_in_patternFullStream1219); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_139.add(string_literal120);


                            pushFollow(FOLLOW_time_in_patternFullStream1221);
                            time121=time();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_time.add(time121.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: patternStream, time
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 175:42: -> ^( PATTERN patternStream ( time )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:175:46: ^( PATTERN patternStream ( time )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(PATTERN, "PATTERN")
                        , root_1);

                        adaptor.addChild(root_1, stream_patternStream.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:175:72: ( time )?
                        if ( stream_time.hasNext() ) {
                            adaptor.addChild(root_1, stream_time.nextTree());

                        }
                        stream_time.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:176:3: patternStream ( 'within' time )?
                    {
                    pushFollow(FOLLOW_patternStream_in_patternFullStream1243);
                    patternStream122=patternStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_patternStream.add(patternStream122.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:176:18: ( 'within' time )?
                    int alt33=2;
                    switch ( input.LA(1) ) {
                        case 139:
                            {
                            alt33=1;
                            }
                            break;
                    }

                    switch (alt33) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:176:19: 'within' time
                            {
                            string_literal123=(Token)match(input,139,FOLLOW_139_in_patternFullStream1247); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_139.add(string_literal123);


                            pushFollow(FOLLOW_time_in_patternFullStream1249);
                            time124=time();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_time.add(time124.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: patternStream, time
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 176:36: -> ^( PATTERN patternStream ( time )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:176:40: ^( PATTERN patternStream ( time )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(PATTERN, "PATTERN")
                        , root_1);

                        adaptor.addChild(root_1, stream_patternStream.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:176:66: ( time )?
                        if ( stream_time.hasNext() ) {
                            adaptor.addChild(root_1, stream_time.nextTree());

                        }
                        stream_time.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "patternFullStream"


    public static class basicStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "basicStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:179:1: basicStream : rawStream ( transformHandler )? ( 'as' id )? -> ^( STREAM rawStream ( transformHandler )? ( id )? ) ;
    public final SiddhiQLGrammarParser.basicStream_return basicStream() throws RecognitionException {
        SiddhiQLGrammarParser.basicStream_return retval = new SiddhiQLGrammarParser.basicStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal127=null;
        SiddhiQLGrammarParser.rawStream_return rawStream125 =null;

        SiddhiQLGrammarParser.transformHandler_return transformHandler126 =null;

        SiddhiQLGrammarParser.id_return id128 =null;


        CommonTree string_literal127_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_rawStream=new RewriteRuleSubtreeStream(adaptor,"rule rawStream");
        RewriteRuleSubtreeStream stream_transformHandler=new RewriteRuleSubtreeStream(adaptor,"rule transformHandler");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:2: ( rawStream ( transformHandler )? ( 'as' id )? -> ^( STREAM rawStream ( transformHandler )? ( id )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:4: rawStream ( transformHandler )? ( 'as' id )?
            {
            pushFollow(FOLLOW_rawStream_in_basicStream1280);
            rawStream125=rawStream();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rawStream.add(rawStream125.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:14: ( transformHandler )?
            int alt35=2;
            switch ( input.LA(1) ) {
                case 69:
                    {
                    alt35=1;
                    }
                    break;
            }

            switch (alt35) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:14: transformHandler
                    {
                    pushFollow(FOLLOW_transformHandler_in_basicStream1282);
                    transformHandler126=transformHandler();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_transformHandler.add(transformHandler126.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:32: ( 'as' id )?
            int alt36=2;
            switch ( input.LA(1) ) {
                case 93:
                    {
                    alt36=1;
                    }
                    break;
            }

            switch (alt36) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:33: 'as' id
                    {
                    string_literal127=(Token)match(input,93,FOLLOW_93_in_basicStream1286); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_93.add(string_literal127);


                    pushFollow(FOLLOW_id_in_basicStream1288);
                    id128=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id128.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: transformHandler, rawStream, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 180:43: -> ^( STREAM rawStream ( transformHandler )? ( id )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:46: ^( STREAM rawStream ( transformHandler )? ( id )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STREAM, "STREAM")
                , root_1);

                adaptor.addChild(root_1, stream_rawStream.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:65: ( transformHandler )?
                if ( stream_transformHandler.hasNext() ) {
                    adaptor.addChild(root_1, stream_transformHandler.nextTree());

                }
                stream_transformHandler.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:180:84: ( id )?
                if ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "basicStream"


    public static class windowStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "windowStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:183:1: windowStream : ( streamId ( filterHandler )? ( transformHandler )? windowHandler ( 'as' id )? -> ^( STREAM ^( streamId ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) | '(' returnQuery ')' ( filterHandler )? ( transformHandler )? windowHandler ( 'as' id )? -> ^( STREAM ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) );
    public final SiddhiQLGrammarParser.windowStream_return windowStream() throws RecognitionException {
        SiddhiQLGrammarParser.windowStream_return retval = new SiddhiQLGrammarParser.windowStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal133=null;
        Token char_literal135=null;
        Token char_literal137=null;
        Token string_literal141=null;
        SiddhiQLGrammarParser.streamId_return streamId129 =null;

        SiddhiQLGrammarParser.filterHandler_return filterHandler130 =null;

        SiddhiQLGrammarParser.transformHandler_return transformHandler131 =null;

        SiddhiQLGrammarParser.windowHandler_return windowHandler132 =null;

        SiddhiQLGrammarParser.id_return id134 =null;

        SiddhiQLGrammarParser.returnQuery_return returnQuery136 =null;

        SiddhiQLGrammarParser.filterHandler_return filterHandler138 =null;

        SiddhiQLGrammarParser.transformHandler_return transformHandler139 =null;

        SiddhiQLGrammarParser.windowHandler_return windowHandler140 =null;

        SiddhiQLGrammarParser.id_return id142 =null;


        CommonTree string_literal133_tree=null;
        CommonTree char_literal135_tree=null;
        CommonTree char_literal137_tree=null;
        CommonTree string_literal141_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_streamId=new RewriteRuleSubtreeStream(adaptor,"rule streamId");
        RewriteRuleSubtreeStream stream_filterHandler=new RewriteRuleSubtreeStream(adaptor,"rule filterHandler");
        RewriteRuleSubtreeStream stream_windowHandler=new RewriteRuleSubtreeStream(adaptor,"rule windowHandler");
        RewriteRuleSubtreeStream stream_returnQuery=new RewriteRuleSubtreeStream(adaptor,"rule returnQuery");
        RewriteRuleSubtreeStream stream_transformHandler=new RewriteRuleSubtreeStream(adaptor,"rule transformHandler");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:2: ( streamId ( filterHandler )? ( transformHandler )? windowHandler ( 'as' id )? -> ^( STREAM ^( streamId ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) | '(' returnQuery ')' ( filterHandler )? ( transformHandler )? windowHandler ( 'as' id )? -> ^( STREAM ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? ) )
            int alt43=2;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                alt43=1;
                }
                break;
            case 71:
                {
                alt43=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:4: streamId ( filterHandler )? ( transformHandler )? windowHandler ( 'as' id )?
                    {
                    pushFollow(FOLLOW_streamId_in_windowStream1316);
                    streamId129=streamId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_streamId.add(streamId129.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:14: ( filterHandler )?
                    int alt37=2;
                    switch ( input.LA(1) ) {
                        case 88:
                            {
                            alt37=1;
                            }
                            break;
                    }

                    switch (alt37) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:14: filterHandler
                            {
                            pushFollow(FOLLOW_filterHandler_in_windowStream1319);
                            filterHandler130=filterHandler();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_filterHandler.add(filterHandler130.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:29: ( transformHandler )?
                    int alt38=2;
                    switch ( input.LA(1) ) {
                        case 69:
                            {
                            switch ( input.LA(2) ) {
                                case 135:
                                    {
                                    alt38=1;
                                    }
                                    break;
                            }

                            }
                            break;
                    }

                    switch (alt38) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:29: transformHandler
                            {
                            pushFollow(FOLLOW_transformHandler_in_windowStream1322);
                            transformHandler131=transformHandler();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_transformHandler.add(transformHandler131.getTree());

                            }
                            break;

                    }


                    pushFollow(FOLLOW_windowHandler_in_windowStream1325);
                    windowHandler132=windowHandler();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_windowHandler.add(windowHandler132.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:61: ( 'as' id )?
                    int alt39=2;
                    switch ( input.LA(1) ) {
                        case 93:
                            {
                            alt39=1;
                            }
                            break;
                    }

                    switch (alt39) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:62: 'as' id
                            {
                            string_literal133=(Token)match(input,93,FOLLOW_93_in_windowStream1328); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_93.add(string_literal133);


                            pushFollow(FOLLOW_id_in_windowStream1330);
                            id134=id();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_id.add(id134.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: transformHandler, filterHandler, windowHandler, id, streamId
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 184:71: -> ^( STREAM ^( streamId ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:74: ^( STREAM ^( streamId ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(STREAM, "STREAM")
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:83: ^( streamId ( filterHandler )? ( transformHandler )? windowHandler )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_streamId.nextNode(), root_2);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:95: ( filterHandler )?
                        if ( stream_filterHandler.hasNext() ) {
                            adaptor.addChild(root_2, stream_filterHandler.nextTree());

                        }
                        stream_filterHandler.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:110: ( transformHandler )?
                        if ( stream_transformHandler.hasNext() ) {
                            adaptor.addChild(root_2, stream_transformHandler.nextTree());

                        }
                        stream_transformHandler.reset();

                        adaptor.addChild(root_2, stream_windowHandler.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:184:144: ( id )?
                        if ( stream_id.hasNext() ) {
                            adaptor.addChild(root_1, stream_id.nextTree());

                        }
                        stream_id.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:4: '(' returnQuery ')' ( filterHandler )? ( transformHandler )? windowHandler ( 'as' id )?
                    {
                    char_literal135=(Token)match(input,71,FOLLOW_71_in_windowStream1359); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal135);


                    pushFollow(FOLLOW_returnQuery_in_windowStream1361);
                    returnQuery136=returnQuery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_returnQuery.add(returnQuery136.getTree());

                    char_literal137=(Token)match(input,72,FOLLOW_72_in_windowStream1363); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal137);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:25: ( filterHandler )?
                    int alt40=2;
                    switch ( input.LA(1) ) {
                        case 88:
                            {
                            alt40=1;
                            }
                            break;
                    }

                    switch (alt40) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:25: filterHandler
                            {
                            pushFollow(FOLLOW_filterHandler_in_windowStream1366);
                            filterHandler138=filterHandler();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_filterHandler.add(filterHandler138.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:40: ( transformHandler )?
                    int alt41=2;
                    switch ( input.LA(1) ) {
                        case 69:
                            {
                            switch ( input.LA(2) ) {
                                case 135:
                                    {
                                    alt41=1;
                                    }
                                    break;
                            }

                            }
                            break;
                    }

                    switch (alt41) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:40: transformHandler
                            {
                            pushFollow(FOLLOW_transformHandler_in_windowStream1369);
                            transformHandler139=transformHandler();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_transformHandler.add(transformHandler139.getTree());

                            }
                            break;

                    }


                    pushFollow(FOLLOW_windowHandler_in_windowStream1372);
                    windowHandler140=windowHandler();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_windowHandler.add(windowHandler140.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:72: ( 'as' id )?
                    int alt42=2;
                    switch ( input.LA(1) ) {
                        case 93:
                            {
                            alt42=1;
                            }
                            break;
                    }

                    switch (alt42) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:73: 'as' id
                            {
                            string_literal141=(Token)match(input,93,FOLLOW_93_in_windowStream1375); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_93.add(string_literal141);


                            pushFollow(FOLLOW_id_in_windowStream1377);
                            id142=id();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_id.add(id142.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: filterHandler, windowHandler, id, returnQuery, transformHandler
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 185:84: -> ^( STREAM ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:88: ^( STREAM ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler ) ( id )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(STREAM, "STREAM")
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:97: ^( ANONYMOUS returnQuery ( filterHandler )? ( transformHandler )? windowHandler )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ANONYMOUS, "ANONYMOUS")
                        , root_2);

                        adaptor.addChild(root_2, stream_returnQuery.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:124: ( filterHandler )?
                        if ( stream_filterHandler.hasNext() ) {
                            adaptor.addChild(root_2, stream_filterHandler.nextTree());

                        }
                        stream_filterHandler.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:139: ( transformHandler )?
                        if ( stream_transformHandler.hasNext() ) {
                            adaptor.addChild(root_2, stream_transformHandler.nextTree());

                        }
                        stream_transformHandler.reset();

                        adaptor.addChild(root_2, stream_windowHandler.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:185:173: ( id )?
                        if ( stream_id.hasNext() ) {
                            adaptor.addChild(root_1, stream_id.nextTree());

                        }
                        stream_id.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "windowStream"


    public static class rawStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rawStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:188:1: rawStream : ( streamId ( filterHandler )? -> ^( streamId ( filterHandler )? ) | '(' returnQuery ')' ( filterHandler )? -> ^( ANONYMOUS returnQuery ( filterHandler )? ) );
    public final SiddhiQLGrammarParser.rawStream_return rawStream() throws RecognitionException {
        SiddhiQLGrammarParser.rawStream_return retval = new SiddhiQLGrammarParser.rawStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal145=null;
        Token char_literal147=null;
        SiddhiQLGrammarParser.streamId_return streamId143 =null;

        SiddhiQLGrammarParser.filterHandler_return filterHandler144 =null;

        SiddhiQLGrammarParser.returnQuery_return returnQuery146 =null;

        SiddhiQLGrammarParser.filterHandler_return filterHandler148 =null;


        CommonTree char_literal145_tree=null;
        CommonTree char_literal147_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_streamId=new RewriteRuleSubtreeStream(adaptor,"rule streamId");
        RewriteRuleSubtreeStream stream_filterHandler=new RewriteRuleSubtreeStream(adaptor,"rule filterHandler");
        RewriteRuleSubtreeStream stream_returnQuery=new RewriteRuleSubtreeStream(adaptor,"rule returnQuery");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:189:2: ( streamId ( filterHandler )? -> ^( streamId ( filterHandler )? ) | '(' returnQuery ')' ( filterHandler )? -> ^( ANONYMOUS returnQuery ( filterHandler )? ) )
            int alt46=2;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                alt46=1;
                }
                break;
            case 71:
                {
                alt46=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:189:4: streamId ( filterHandler )?
                    {
                    pushFollow(FOLLOW_streamId_in_rawStream1419);
                    streamId143=streamId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_streamId.add(streamId143.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:189:14: ( filterHandler )?
                    int alt44=2;
                    switch ( input.LA(1) ) {
                        case 88:
                            {
                            alt44=1;
                            }
                            break;
                    }

                    switch (alt44) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:189:14: filterHandler
                            {
                            pushFollow(FOLLOW_filterHandler_in_rawStream1422);
                            filterHandler144=filterHandler();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_filterHandler.add(filterHandler144.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: filterHandler, streamId
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 189:31: -> ^( streamId ( filterHandler )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:189:34: ^( streamId ( filterHandler )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_streamId.nextNode(), root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:189:47: ( filterHandler )?
                        if ( stream_filterHandler.hasNext() ) {
                            adaptor.addChild(root_1, stream_filterHandler.nextTree());

                        }
                        stream_filterHandler.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:190:4: '(' returnQuery ')' ( filterHandler )?
                    {
                    char_literal145=(Token)match(input,71,FOLLOW_71_in_rawStream1443); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal145);


                    pushFollow(FOLLOW_returnQuery_in_rawStream1445);
                    returnQuery146=returnQuery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_returnQuery.add(returnQuery146.getTree());

                    char_literal147=(Token)match(input,72,FOLLOW_72_in_rawStream1447); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal147);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:190:25: ( filterHandler )?
                    int alt45=2;
                    switch ( input.LA(1) ) {
                        case 88:
                            {
                            alt45=1;
                            }
                            break;
                    }

                    switch (alt45) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:190:25: filterHandler
                            {
                            pushFollow(FOLLOW_filterHandler_in_rawStream1450);
                            filterHandler148=filterHandler();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_filterHandler.add(filterHandler148.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: filterHandler, returnQuery
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 190:41: -> ^( ANONYMOUS returnQuery ( filterHandler )? )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:190:45: ^( ANONYMOUS returnQuery ( filterHandler )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ANONYMOUS, "ANONYMOUS")
                        , root_1);

                        adaptor.addChild(root_1, stream_returnQuery.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:190:70: ( filterHandler )?
                        if ( stream_filterHandler.hasNext() ) {
                            adaptor.addChild(root_1, stream_filterHandler.nextTree());

                        }
                        stream_filterHandler.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rawStream"


    public static class joinStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "joinStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:193:1: joinStream : ( leftStream join rightStream 'unidirectional' ( 'on' condition )? ( 'within' time )? -> leftStream join rightStream 'unidirectional' ( condition )? ( time )? | leftStream join rightStream ( 'on' condition )? ( 'within' time )? -> leftStream join rightStream ( condition )? ( time )? | leftStream 'unidirectional' join rightStream ( 'on' condition )? ( 'within' time )? -> leftStream 'unidirectional' join rightStream ( condition )? ( time )? );
    public final SiddhiQLGrammarParser.joinStream_return joinStream() throws RecognitionException {
        SiddhiQLGrammarParser.joinStream_return retval = new SiddhiQLGrammarParser.joinStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal152=null;
        Token string_literal153=null;
        Token string_literal155=null;
        Token string_literal160=null;
        Token string_literal162=null;
        Token string_literal165=null;
        Token string_literal168=null;
        Token string_literal170=null;
        SiddhiQLGrammarParser.leftStream_return leftStream149 =null;

        SiddhiQLGrammarParser.join_return join150 =null;

        SiddhiQLGrammarParser.rightStream_return rightStream151 =null;

        SiddhiQLGrammarParser.condition_return condition154 =null;

        SiddhiQLGrammarParser.time_return time156 =null;

        SiddhiQLGrammarParser.leftStream_return leftStream157 =null;

        SiddhiQLGrammarParser.join_return join158 =null;

        SiddhiQLGrammarParser.rightStream_return rightStream159 =null;

        SiddhiQLGrammarParser.condition_return condition161 =null;

        SiddhiQLGrammarParser.time_return time163 =null;

        SiddhiQLGrammarParser.leftStream_return leftStream164 =null;

        SiddhiQLGrammarParser.join_return join166 =null;

        SiddhiQLGrammarParser.rightStream_return rightStream167 =null;

        SiddhiQLGrammarParser.condition_return condition169 =null;

        SiddhiQLGrammarParser.time_return time171 =null;


        CommonTree string_literal152_tree=null;
        CommonTree string_literal153_tree=null;
        CommonTree string_literal155_tree=null;
        CommonTree string_literal160_tree=null;
        CommonTree string_literal162_tree=null;
        CommonTree string_literal165_tree=null;
        CommonTree string_literal168_tree=null;
        CommonTree string_literal170_tree=null;
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
        RewriteRuleTokenStream stream_136=new RewriteRuleTokenStream(adaptor,"token 136");
        RewriteRuleSubtreeStream stream_time=new RewriteRuleSubtreeStream(adaptor,"rule time");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_join=new RewriteRuleSubtreeStream(adaptor,"rule join");
        RewriteRuleSubtreeStream stream_rightStream=new RewriteRuleSubtreeStream(adaptor,"rule rightStream");
        RewriteRuleSubtreeStream stream_leftStream=new RewriteRuleSubtreeStream(adaptor,"rule leftStream");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:2: ( leftStream join rightStream 'unidirectional' ( 'on' condition )? ( 'within' time )? -> leftStream join rightStream 'unidirectional' ( condition )? ( time )? | leftStream join rightStream ( 'on' condition )? ( 'within' time )? -> leftStream join rightStream ( condition )? ( time )? | leftStream 'unidirectional' join rightStream ( 'on' condition )? ( 'within' time )? -> leftStream 'unidirectional' join rightStream ( condition )? ( time )? )
            int alt53=3;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                int LA53_1 = input.LA(2);

                if ( (synpred61_SiddhiQLGrammar()) ) {
                    alt53=1;
                }
                else if ( (synpred64_SiddhiQLGrammar()) ) {
                    alt53=2;
                }
                else if ( (true) ) {
                    alt53=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;

                }
                }
                break;
            case 71:
                {
                int LA53_2 = input.LA(2);

                if ( (synpred61_SiddhiQLGrammar()) ) {
                    alt53=1;
                }
                else if ( (synpred64_SiddhiQLGrammar()) ) {
                    alt53=2;
                }
                else if ( (true) ) {
                    alt53=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }

            switch (alt53) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:3: leftStream join rightStream 'unidirectional' ( 'on' condition )? ( 'within' time )?
                    {
                    pushFollow(FOLLOW_leftStream_in_joinStream1476);
                    leftStream149=leftStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_leftStream.add(leftStream149.getTree());

                    pushFollow(FOLLOW_join_in_joinStream1478);
                    join150=join();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_join.add(join150.getTree());

                    pushFollow(FOLLOW_rightStream_in_joinStream1480);
                    rightStream151=rightStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rightStream.add(rightStream151.getTree());

                    string_literal152=(Token)match(input,136,FOLLOW_136_in_joinStream1482); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_136.add(string_literal152);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:48: ( 'on' condition )?
                    int alt47=2;
                    switch ( input.LA(1) ) {
                        case 122:
                            {
                            alt47=1;
                            }
                            break;
                    }

                    switch (alt47) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:49: 'on' condition
                            {
                            string_literal153=(Token)match(input,122,FOLLOW_122_in_joinStream1485); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_122.add(string_literal153);


                            pushFollow(FOLLOW_condition_in_joinStream1487);
                            condition154=condition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_condition.add(condition154.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:66: ( 'within' time )?
                    int alt48=2;
                    switch ( input.LA(1) ) {
                        case 139:
                            {
                            alt48=1;
                            }
                            break;
                    }

                    switch (alt48) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:67: 'within' time
                            {
                            string_literal155=(Token)match(input,139,FOLLOW_139_in_joinStream1492); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_139.add(string_literal155);


                            pushFollow(FOLLOW_time_in_joinStream1494);
                            time156=time();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_time.add(time156.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 136, join, time, rightStream, condition, leftStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 194:83: -> leftStream join rightStream 'unidirectional' ( condition )? ( time )?
                    {
                        adaptor.addChild(root_0, stream_leftStream.nextTree());

                        adaptor.addChild(root_0, stream_join.nextTree());

                        adaptor.addChild(root_0, stream_rightStream.nextTree());

                        adaptor.addChild(root_0, 
                        stream_136.nextNode()
                        );

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:132: ( condition )?
                        if ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_0, stream_condition.nextTree());

                        }
                        stream_condition.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:143: ( time )?
                        if ( stream_time.hasNext() ) {
                            adaptor.addChild(root_0, stream_time.nextTree());

                        }
                        stream_time.reset();

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:3: leftStream join rightStream ( 'on' condition )? ( 'within' time )?
                    {
                    pushFollow(FOLLOW_leftStream_in_joinStream1517);
                    leftStream157=leftStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_leftStream.add(leftStream157.getTree());

                    pushFollow(FOLLOW_join_in_joinStream1519);
                    join158=join();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_join.add(join158.getTree());

                    pushFollow(FOLLOW_rightStream_in_joinStream1521);
                    rightStream159=rightStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rightStream.add(rightStream159.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:31: ( 'on' condition )?
                    int alt49=2;
                    switch ( input.LA(1) ) {
                        case 122:
                            {
                            alt49=1;
                            }
                            break;
                    }

                    switch (alt49) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:32: 'on' condition
                            {
                            string_literal160=(Token)match(input,122,FOLLOW_122_in_joinStream1524); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_122.add(string_literal160);


                            pushFollow(FOLLOW_condition_in_joinStream1526);
                            condition161=condition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_condition.add(condition161.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:49: ( 'within' time )?
                    int alt50=2;
                    switch ( input.LA(1) ) {
                        case 139:
                            {
                            alt50=1;
                            }
                            break;
                    }

                    switch (alt50) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:50: 'within' time
                            {
                            string_literal162=(Token)match(input,139,FOLLOW_139_in_joinStream1531); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_139.add(string_literal162);


                            pushFollow(FOLLOW_time_in_joinStream1533);
                            time163=time();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_time.add(time163.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: join, rightStream, condition, time, leftStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 195:66: -> leftStream join rightStream ( condition )? ( time )?
                    {
                        adaptor.addChild(root_0, stream_leftStream.nextTree());

                        adaptor.addChild(root_0, stream_join.nextTree());

                        adaptor.addChild(root_0, stream_rightStream.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:99: ( condition )?
                        if ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_0, stream_condition.nextTree());

                        }
                        stream_condition.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:110: ( time )?
                        if ( stream_time.hasNext() ) {
                            adaptor.addChild(root_0, stream_time.nextTree());

                        }
                        stream_time.reset();

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:196:3: leftStream 'unidirectional' join rightStream ( 'on' condition )? ( 'within' time )?
                    {
                    pushFollow(FOLLOW_leftStream_in_joinStream1555);
                    leftStream164=leftStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_leftStream.add(leftStream164.getTree());

                    string_literal165=(Token)match(input,136,FOLLOW_136_in_joinStream1557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_136.add(string_literal165);


                    pushFollow(FOLLOW_join_in_joinStream1559);
                    join166=join();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_join.add(join166.getTree());

                    pushFollow(FOLLOW_rightStream_in_joinStream1561);
                    rightStream167=rightStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rightStream.add(rightStream167.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:196:48: ( 'on' condition )?
                    int alt51=2;
                    switch ( input.LA(1) ) {
                        case 122:
                            {
                            alt51=1;
                            }
                            break;
                    }

                    switch (alt51) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:196:49: 'on' condition
                            {
                            string_literal168=(Token)match(input,122,FOLLOW_122_in_joinStream1564); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_122.add(string_literal168);


                            pushFollow(FOLLOW_condition_in_joinStream1566);
                            condition169=condition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_condition.add(condition169.getTree());

                            }
                            break;

                    }


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:196:66: ( 'within' time )?
                    int alt52=2;
                    switch ( input.LA(1) ) {
                        case 139:
                            {
                            alt52=1;
                            }
                            break;
                    }

                    switch (alt52) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:196:67: 'within' time
                            {
                            string_literal170=(Token)match(input,139,FOLLOW_139_in_joinStream1571); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_139.add(string_literal170);


                            pushFollow(FOLLOW_time_in_joinStream1573);
                            time171=time();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_time.add(time171.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 136, time, join, rightStream, condition, leftStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 196:83: -> leftStream 'unidirectional' join rightStream ( condition )? ( time )?
                    {
                        adaptor.addChild(root_0, stream_leftStream.nextTree());

                        adaptor.addChild(root_0, 
                        stream_136.nextNode()
                        );

                        adaptor.addChild(root_0, stream_join.nextTree());

                        adaptor.addChild(root_0, stream_rightStream.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:196:133: ( condition )?
                        if ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_0, stream_condition.nextTree());

                        }
                        stream_condition.reset();

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:196:144: ( time )?
                        if ( stream_time.hasNext() ) {
                            adaptor.addChild(root_0, stream_time.nextTree());

                        }
                        stream_time.reset();

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "joinStream"


    public static class leftStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "leftStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:199:1: leftStream : ( windowStream | basicStream );
    public final SiddhiQLGrammarParser.leftStream_return leftStream() throws RecognitionException {
        SiddhiQLGrammarParser.leftStream_return retval = new SiddhiQLGrammarParser.leftStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.windowStream_return windowStream172 =null;

        SiddhiQLGrammarParser.basicStream_return basicStream173 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:200:5: ( windowStream | basicStream )
            int alt54=2;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                int LA54_1 = input.LA(2);

                if ( (synpred67_SiddhiQLGrammar()) ) {
                    alt54=1;
                }
                else if ( (true) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;

                }
                }
                break;
            case 71:
                {
                int LA54_2 = input.LA(2);

                if ( (synpred67_SiddhiQLGrammar()) ) {
                    alt54=1;
                }
                else if ( (true) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 2, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:200:8: windowStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_windowStream_in_leftStream1608);
                    windowStream172=windowStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, windowStream172.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:201:7: basicStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_basicStream_in_leftStream1616);
                    basicStream173=basicStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, basicStream173.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "leftStream"


    public static class rightStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rightStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:204:1: rightStream : ( windowStream | basicStream );
    public final SiddhiQLGrammarParser.rightStream_return rightStream() throws RecognitionException {
        SiddhiQLGrammarParser.rightStream_return retval = new SiddhiQLGrammarParser.rightStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.windowStream_return windowStream174 =null;

        SiddhiQLGrammarParser.basicStream_return basicStream175 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:205:5: ( windowStream | basicStream )
            int alt55=2;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                int LA55_1 = input.LA(2);

                if ( (synpred68_SiddhiQLGrammar()) ) {
                    alt55=1;
                }
                else if ( (true) ) {
                    alt55=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;

                }
                }
                break;
            case 71:
                {
                int LA55_2 = input.LA(2);

                if ( (synpred68_SiddhiQLGrammar()) ) {
                    alt55=1;
                }
                else if ( (true) ) {
                    alt55=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 2, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:205:8: windowStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_windowStream_in_rightStream1634);
                    windowStream174=windowStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, windowStream174.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:206:8: basicStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_basicStream_in_rightStream1643);
                    basicStream175=basicStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, basicStream175.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rightStream"


    public static class returnQuery_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "returnQuery"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:209:1: returnQuery : inputStream outputSelection 'return' -> ^( RETURN_QUERY inputStream outputSelection ) ;
    public final SiddhiQLGrammarParser.returnQuery_return returnQuery() throws RecognitionException {
        SiddhiQLGrammarParser.returnQuery_return retval = new SiddhiQLGrammarParser.returnQuery_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal178=null;
        SiddhiQLGrammarParser.inputStream_return inputStream176 =null;

        SiddhiQLGrammarParser.outputSelection_return outputSelection177 =null;


        CommonTree string_literal178_tree=null;
        RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
        RewriteRuleSubtreeStream stream_inputStream=new RewriteRuleSubtreeStream(adaptor,"rule inputStream");
        RewriteRuleSubtreeStream stream_outputSelection=new RewriteRuleSubtreeStream(adaptor,"rule outputSelection");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:210:2: ( inputStream outputSelection 'return' -> ^( RETURN_QUERY inputStream outputSelection ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:210:4: inputStream outputSelection 'return'
            {
            pushFollow(FOLLOW_inputStream_in_returnQuery1657);
            inputStream176=inputStream();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_inputStream.add(inputStream176.getTree());

            pushFollow(FOLLOW_outputSelection_in_returnQuery1659);
            outputSelection177=outputSelection();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_outputSelection.add(outputSelection177.getTree());

            string_literal178=(Token)match(input,128,FOLLOW_128_in_returnQuery1661); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_128.add(string_literal178);


            // AST REWRITE
            // elements: outputSelection, inputStream
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 210:41: -> ^( RETURN_QUERY inputStream outputSelection )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:210:44: ^( RETURN_QUERY inputStream outputSelection )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RETURN_QUERY, "RETURN_QUERY")
                , root_1);

                adaptor.addChild(root_1, stream_inputStream.nextTree());

                adaptor.addChild(root_1, stream_outputSelection.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "returnQuery"


    public static class patternStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "patternStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:213:1: patternStream : ( patternItem ( FOLLOWED_BY patternStream )? -> patternItem ( patternStream )? | 'every' patternItem ( FOLLOWED_BY patternStream )? -> ^( 'every' patternItem ) ( patternStream )? | 'every' '(' nonEveryPatternStream ')' ( FOLLOWED_BY patternStream )? -> ^( 'every' nonEveryPatternStream ) ( patternStream )? );
    public final SiddhiQLGrammarParser.patternStream_return patternStream() throws RecognitionException {
        SiddhiQLGrammarParser.patternStream_return retval = new SiddhiQLGrammarParser.patternStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token FOLLOWED_BY180=null;
        Token string_literal182=null;
        Token FOLLOWED_BY184=null;
        Token string_literal186=null;
        Token char_literal187=null;
        Token char_literal189=null;
        Token FOLLOWED_BY190=null;
        SiddhiQLGrammarParser.patternItem_return patternItem179 =null;

        SiddhiQLGrammarParser.patternStream_return patternStream181 =null;

        SiddhiQLGrammarParser.patternItem_return patternItem183 =null;

        SiddhiQLGrammarParser.patternStream_return patternStream185 =null;

        SiddhiQLGrammarParser.nonEveryPatternStream_return nonEveryPatternStream188 =null;

        SiddhiQLGrammarParser.patternStream_return patternStream191 =null;


        CommonTree FOLLOWED_BY180_tree=null;
        CommonTree string_literal182_tree=null;
        CommonTree FOLLOWED_BY184_tree=null;
        CommonTree string_literal186_tree=null;
        CommonTree char_literal187_tree=null;
        CommonTree char_literal189_tree=null;
        CommonTree FOLLOWED_BY190_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleTokenStream stream_FOLLOWED_BY=new RewriteRuleTokenStream(adaptor,"token FOLLOWED_BY");
        RewriteRuleSubtreeStream stream_nonEveryPatternStream=new RewriteRuleSubtreeStream(adaptor,"rule nonEveryPatternStream");
        RewriteRuleSubtreeStream stream_patternStream=new RewriteRuleSubtreeStream(adaptor,"rule patternStream");
        RewriteRuleSubtreeStream stream_patternItem=new RewriteRuleSubtreeStream(adaptor,"rule patternItem");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:214:2: ( patternItem ( FOLLOWED_BY patternStream )? -> patternItem ( patternStream )? | 'every' patternItem ( FOLLOWED_BY patternStream )? -> ^( 'every' patternItem ) ( patternStream )? | 'every' '(' nonEveryPatternStream ')' ( FOLLOWED_BY patternStream )? -> ^( 'every' nonEveryPatternStream ) ( patternStream )? )
            int alt59=3;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                alt59=1;
                }
                break;
            case 102:
                {
                switch ( input.LA(2) ) {
                case 71:
                    {
                    alt59=3;
                    }
                    break;
                case ID:
                case ID_QUOTES:
                    {
                    alt59=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 2, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:214:4: patternItem ( FOLLOWED_BY patternStream )?
                    {
                    pushFollow(FOLLOW_patternItem_in_patternStream1683);
                    patternItem179=patternItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_patternItem.add(patternItem179.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:214:16: ( FOLLOWED_BY patternStream )?
                    int alt56=2;
                    switch ( input.LA(1) ) {
                        case FOLLOWED_BY:
                            {
                            alt56=1;
                            }
                            break;
                    }

                    switch (alt56) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:214:18: FOLLOWED_BY patternStream
                            {
                            FOLLOWED_BY180=(Token)match(input,FOLLOWED_BY,FOLLOW_FOLLOWED_BY_in_patternStream1687); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FOLLOWED_BY.add(FOLLOWED_BY180);


                            pushFollow(FOLLOW_patternStream_in_patternStream1689);
                            patternStream181=patternStream();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_patternStream.add(patternStream181.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: patternStream, patternItem
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 214:48: -> patternItem ( patternStream )?
                    {
                        adaptor.addChild(root_0, stream_patternItem.nextTree());

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:214:65: ( patternStream )?
                        if ( stream_patternStream.hasNext() ) {
                            adaptor.addChild(root_0, stream_patternStream.nextTree());

                        }
                        stream_patternStream.reset();

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:215:4: 'every' patternItem ( FOLLOWED_BY patternStream )?
                    {
                    string_literal182=(Token)match(input,102,FOLLOW_102_in_patternStream1707); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_102.add(string_literal182);


                    pushFollow(FOLLOW_patternItem_in_patternStream1709);
                    patternItem183=patternItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_patternItem.add(patternItem183.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:215:24: ( FOLLOWED_BY patternStream )?
                    int alt57=2;
                    switch ( input.LA(1) ) {
                        case FOLLOWED_BY:
                            {
                            alt57=1;
                            }
                            break;
                    }

                    switch (alt57) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:215:26: FOLLOWED_BY patternStream
                            {
                            FOLLOWED_BY184=(Token)match(input,FOLLOWED_BY,FOLLOW_FOLLOWED_BY_in_patternStream1713); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FOLLOWED_BY.add(FOLLOWED_BY184);


                            pushFollow(FOLLOW_patternStream_in_patternStream1715);
                            patternStream185=patternStream();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_patternStream.add(patternStream185.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 102, patternStream, patternItem
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 215:56: -> ^( 'every' patternItem ) ( patternStream )?
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:215:60: ^( 'every' patternItem )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_102.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_patternItem.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:215:86: ( patternStream )?
                        if ( stream_patternStream.hasNext() ) {
                            adaptor.addChild(root_0, stream_patternStream.nextTree());

                        }
                        stream_patternStream.reset();

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:216:4: 'every' '(' nonEveryPatternStream ')' ( FOLLOWED_BY patternStream )?
                    {
                    string_literal186=(Token)match(input,102,FOLLOW_102_in_patternStream1739); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_102.add(string_literal186);


                    char_literal187=(Token)match(input,71,FOLLOW_71_in_patternStream1741); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal187);


                    pushFollow(FOLLOW_nonEveryPatternStream_in_patternStream1742);
                    nonEveryPatternStream188=nonEveryPatternStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nonEveryPatternStream.add(nonEveryPatternStream188.getTree());

                    char_literal189=(Token)match(input,72,FOLLOW_72_in_patternStream1743); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal189);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:216:40: ( FOLLOWED_BY patternStream )?
                    int alt58=2;
                    switch ( input.LA(1) ) {
                        case FOLLOWED_BY:
                            {
                            alt58=1;
                            }
                            break;
                    }

                    switch (alt58) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:216:42: FOLLOWED_BY patternStream
                            {
                            FOLLOWED_BY190=(Token)match(input,FOLLOWED_BY,FOLLOW_FOLLOWED_BY_in_patternStream1747); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FOLLOWED_BY.add(FOLLOWED_BY190);


                            pushFollow(FOLLOW_patternStream_in_patternStream1749);
                            patternStream191=patternStream();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_patternStream.add(patternStream191.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: patternStream, 102, nonEveryPatternStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 216:71: -> ^( 'every' nonEveryPatternStream ) ( patternStream )?
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:216:74: ^( 'every' nonEveryPatternStream )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_102.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_nonEveryPatternStream.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:216:111: ( patternStream )?
                        if ( stream_patternStream.hasNext() ) {
                            adaptor.addChild(root_0, stream_patternStream.nextTree());

                        }
                        stream_patternStream.reset();

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "patternStream"


    public static class nonEveryPatternStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nonEveryPatternStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:219:1: nonEveryPatternStream : patternItem ( FOLLOWED_BY nonEveryPatternStream )? -> patternItem ( nonEveryPatternStream )? ;
    public final SiddhiQLGrammarParser.nonEveryPatternStream_return nonEveryPatternStream() throws RecognitionException {
        SiddhiQLGrammarParser.nonEveryPatternStream_return retval = new SiddhiQLGrammarParser.nonEveryPatternStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token FOLLOWED_BY193=null;
        SiddhiQLGrammarParser.patternItem_return patternItem192 =null;

        SiddhiQLGrammarParser.nonEveryPatternStream_return nonEveryPatternStream194 =null;


        CommonTree FOLLOWED_BY193_tree=null;
        RewriteRuleTokenStream stream_FOLLOWED_BY=new RewriteRuleTokenStream(adaptor,"token FOLLOWED_BY");
        RewriteRuleSubtreeStream stream_nonEveryPatternStream=new RewriteRuleSubtreeStream(adaptor,"rule nonEveryPatternStream");
        RewriteRuleSubtreeStream stream_patternItem=new RewriteRuleSubtreeStream(adaptor,"rule patternItem");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:220:2: ( patternItem ( FOLLOWED_BY nonEveryPatternStream )? -> patternItem ( nonEveryPatternStream )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:220:4: patternItem ( FOLLOWED_BY nonEveryPatternStream )?
            {
            pushFollow(FOLLOW_patternItem_in_nonEveryPatternStream1778);
            patternItem192=patternItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_patternItem.add(patternItem192.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:220:17: ( FOLLOWED_BY nonEveryPatternStream )?
            int alt60=2;
            switch ( input.LA(1) ) {
                case FOLLOWED_BY:
                    {
                    alt60=1;
                    }
                    break;
            }

            switch (alt60) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:220:19: FOLLOWED_BY nonEveryPatternStream
                    {
                    FOLLOWED_BY193=(Token)match(input,FOLLOWED_BY,FOLLOW_FOLLOWED_BY_in_nonEveryPatternStream1783); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FOLLOWED_BY.add(FOLLOWED_BY193);


                    pushFollow(FOLLOW_nonEveryPatternStream_in_nonEveryPatternStream1785);
                    nonEveryPatternStream194=nonEveryPatternStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nonEveryPatternStream.add(nonEveryPatternStream194.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: patternItem, nonEveryPatternStream
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 220:57: -> patternItem ( nonEveryPatternStream )?
            {
                adaptor.addChild(root_0, stream_patternItem.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:220:73: ( nonEveryPatternStream )?
                if ( stream_nonEveryPatternStream.hasNext() ) {
                    adaptor.addChild(root_0, stream_nonEveryPatternStream.nextTree());

                }
                stream_nonEveryPatternStream.reset();

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nonEveryPatternStream"


    public static class sequenceFullStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sequenceFullStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:223:1: sequenceFullStream : sequenceStream ( 'within' time )? -> ^( SEQUENCE sequenceStream ( time )? ) ;
    public final SiddhiQLGrammarParser.sequenceFullStream_return sequenceFullStream() throws RecognitionException {
        SiddhiQLGrammarParser.sequenceFullStream_return retval = new SiddhiQLGrammarParser.sequenceFullStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal196=null;
        SiddhiQLGrammarParser.sequenceStream_return sequenceStream195 =null;

        SiddhiQLGrammarParser.time_return time197 =null;


        CommonTree string_literal196_tree=null;
        RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
        RewriteRuleSubtreeStream stream_time=new RewriteRuleSubtreeStream(adaptor,"rule time");
        RewriteRuleSubtreeStream stream_sequenceStream=new RewriteRuleSubtreeStream(adaptor,"rule sequenceStream");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:224:2: ( sequenceStream ( 'within' time )? -> ^( SEQUENCE sequenceStream ( time )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:224:3: sequenceStream ( 'within' time )?
            {
            pushFollow(FOLLOW_sequenceStream_in_sequenceFullStream1807);
            sequenceStream195=sequenceStream();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sequenceStream.add(sequenceStream195.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:224:18: ( 'within' time )?
            int alt61=2;
            switch ( input.LA(1) ) {
                case 139:
                    {
                    alt61=1;
                    }
                    break;
            }

            switch (alt61) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:224:19: 'within' time
                    {
                    string_literal196=(Token)match(input,139,FOLLOW_139_in_sequenceFullStream1810); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_139.add(string_literal196);


                    pushFollow(FOLLOW_time_in_sequenceFullStream1812);
                    time197=time();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_time.add(time197.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: sequenceStream, time
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 224:35: -> ^( SEQUENCE sequenceStream ( time )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:224:39: ^( SEQUENCE sequenceStream ( time )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SEQUENCE, "SEQUENCE")
                , root_1);

                adaptor.addChild(root_1, stream_sequenceStream.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:224:66: ( time )?
                if ( stream_time.hasNext() ) {
                    adaptor.addChild(root_1, stream_time.nextTree());

                }
                stream_time.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sequenceFullStream"


    public static class sequenceStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sequenceStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:227:1: sequenceStream : sequenceItem ',' sequenceItem ( ',' sequenceItem )* -> ( sequenceItem )+ ;
    public final SiddhiQLGrammarParser.sequenceStream_return sequenceStream() throws RecognitionException {
        SiddhiQLGrammarParser.sequenceStream_return retval = new SiddhiQLGrammarParser.sequenceStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal199=null;
        Token char_literal201=null;
        SiddhiQLGrammarParser.sequenceItem_return sequenceItem198 =null;

        SiddhiQLGrammarParser.sequenceItem_return sequenceItem200 =null;

        SiddhiQLGrammarParser.sequenceItem_return sequenceItem202 =null;


        CommonTree char_literal199_tree=null;
        CommonTree char_literal201_tree=null;
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_sequenceItem=new RewriteRuleSubtreeStream(adaptor,"rule sequenceItem");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:228:2: ( sequenceItem ',' sequenceItem ( ',' sequenceItem )* -> ( sequenceItem )+ )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:228:4: sequenceItem ',' sequenceItem ( ',' sequenceItem )*
            {
            pushFollow(FOLLOW_sequenceItem_in_sequenceStream1839);
            sequenceItem198=sequenceItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sequenceItem.add(sequenceItem198.getTree());

            char_literal199=(Token)match(input,75,FOLLOW_75_in_sequenceStream1841); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(char_literal199);


            pushFollow(FOLLOW_sequenceItem_in_sequenceStream1843);
            sequenceItem200=sequenceItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sequenceItem.add(sequenceItem200.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:228:35: ( ',' sequenceItem )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt62=1;
                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:228:36: ',' sequenceItem
            	    {
            	    char_literal201=(Token)match(input,75,FOLLOW_75_in_sequenceStream1847); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_75.add(char_literal201);


            	    pushFollow(FOLLOW_sequenceItem_in_sequenceStream1849);
            	    sequenceItem202=sequenceItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_sequenceItem.add(sequenceItem202.getTree());

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            // AST REWRITE
            // elements: sequenceItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 228:58: -> ( sequenceItem )+
            {
                if ( !(stream_sequenceItem.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_sequenceItem.hasNext() ) {
                    adaptor.addChild(root_0, stream_sequenceItem.nextTree());

                }
                stream_sequenceItem.reset();

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sequenceStream"


    public static class patternItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "patternItem"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:235:1: patternItem : ( itemStream 'and' ^ itemStream | itemStream 'or' ^ itemStream | itemStream '<' collect '>' -> ^( COLLECT itemStream collect ) | itemStream );
    public final SiddhiQLGrammarParser.patternItem_return patternItem() throws RecognitionException {
        SiddhiQLGrammarParser.patternItem_return retval = new SiddhiQLGrammarParser.patternItem_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal204=null;
        Token string_literal207=null;
        Token char_literal210=null;
        Token char_literal212=null;
        SiddhiQLGrammarParser.itemStream_return itemStream203 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream205 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream206 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream208 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream209 =null;

        SiddhiQLGrammarParser.collect_return collect211 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream213 =null;


        CommonTree string_literal204_tree=null;
        CommonTree string_literal207_tree=null;
        CommonTree char_literal210_tree=null;
        CommonTree char_literal212_tree=null;
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_itemStream=new RewriteRuleSubtreeStream(adaptor,"rule itemStream");
        RewriteRuleSubtreeStream stream_collect=new RewriteRuleSubtreeStream(adaptor,"rule collect");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:236:2: ( itemStream 'and' ^ itemStream | itemStream 'or' ^ itemStream | itemStream '<' collect '>' -> ^( COLLECT itemStream collect ) | itemStream )
            int alt63=4;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                int LA63_1 = input.LA(2);

                if ( (synpred77_SiddhiQLGrammar()) ) {
                    alt63=1;
                }
                else if ( (synpred78_SiddhiQLGrammar()) ) {
                    alt63=2;
                }
                else if ( (synpred79_SiddhiQLGrammar()) ) {
                    alt63=3;
                }
                else if ( (true) ) {
                    alt63=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:236:4: itemStream 'and' ^ itemStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_itemStream_in_patternItem1883);
                    itemStream203=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream203.getTree());

                    string_literal204=(Token)match(input,92,FOLLOW_92_in_patternItem1885); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal204_tree = 
                    (CommonTree)adaptor.create(string_literal204)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(string_literal204_tree, root_0);
                    }

                    pushFollow(FOLLOW_itemStream_in_patternItem1888);
                    itemStream205=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream205.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:237:4: itemStream 'or' ^ itemStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_itemStream_in_patternItem1893);
                    itemStream206=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream206.getTree());

                    string_literal207=(Token)match(input,123,FOLLOW_123_in_patternItem1895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal207_tree = 
                    (CommonTree)adaptor.create(string_literal207)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(string_literal207_tree, root_0);
                    }

                    pushFollow(FOLLOW_itemStream_in_patternItem1898);
                    itemStream208=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream208.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:238:4: itemStream '<' collect '>'
                    {
                    pushFollow(FOLLOW_itemStream_in_patternItem1903);
                    itemStream209=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_itemStream.add(itemStream209.getTree());

                    char_literal210=(Token)match(input,81,FOLLOW_81_in_patternItem1905); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_81.add(char_literal210);


                    pushFollow(FOLLOW_collect_in_patternItem1906);
                    collect211=collect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_collect.add(collect211.getTree());

                    char_literal212=(Token)match(input,85,FOLLOW_85_in_patternItem1908); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_85.add(char_literal212);


                    // AST REWRITE
                    // elements: collect, itemStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 238:30: -> ^( COLLECT itemStream collect )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:238:33: ^( COLLECT itemStream collect )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(COLLECT, "COLLECT")
                        , root_1);

                        adaptor.addChild(root_1, stream_itemStream.nextTree());

                        adaptor.addChild(root_1, stream_collect.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:239:4: itemStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_itemStream_in_patternItem1923);
                    itemStream213=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream213.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "patternItem"


    public static class sequenceItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sequenceItem"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:242:1: sequenceItem : ( itemStream 'or' ^ itemStream | itemStream regex -> ^( REGEX itemStream regex ) | itemStream );
    public final SiddhiQLGrammarParser.sequenceItem_return sequenceItem() throws RecognitionException {
        SiddhiQLGrammarParser.sequenceItem_return retval = new SiddhiQLGrammarParser.sequenceItem_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal215=null;
        SiddhiQLGrammarParser.itemStream_return itemStream214 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream216 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream217 =null;

        SiddhiQLGrammarParser.regex_return regex218 =null;

        SiddhiQLGrammarParser.itemStream_return itemStream219 =null;


        CommonTree string_literal215_tree=null;
        RewriteRuleSubtreeStream stream_itemStream=new RewriteRuleSubtreeStream(adaptor,"rule itemStream");
        RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:243:2: ( itemStream 'or' ^ itemStream | itemStream regex -> ^( REGEX itemStream regex ) | itemStream )
            int alt64=3;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                int LA64_1 = input.LA(2);

                if ( (synpred80_SiddhiQLGrammar()) ) {
                    alt64=1;
                }
                else if ( (synpred81_SiddhiQLGrammar()) ) {
                    alt64=2;
                }
                else if ( (true) ) {
                    alt64=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:243:4: itemStream 'or' ^ itemStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_itemStream_in_sequenceItem1934);
                    itemStream214=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream214.getTree());

                    string_literal215=(Token)match(input,123,FOLLOW_123_in_sequenceItem1936); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal215_tree = 
                    (CommonTree)adaptor.create(string_literal215)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(string_literal215_tree, root_0);
                    }

                    pushFollow(FOLLOW_itemStream_in_sequenceItem1939);
                    itemStream216=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream216.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:244:4: itemStream regex
                    {
                    pushFollow(FOLLOW_itemStream_in_sequenceItem1944);
                    itemStream217=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_itemStream.add(itemStream217.getTree());

                    pushFollow(FOLLOW_regex_in_sequenceItem1946);
                    regex218=regex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regex.add(regex218.getTree());

                    // AST REWRITE
                    // elements: regex, itemStream
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 244:21: -> ^( REGEX itemStream regex )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:244:24: ^( REGEX itemStream regex )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(REGEX, "REGEX")
                        , root_1);

                        adaptor.addChild(root_1, stream_itemStream.nextTree());

                        adaptor.addChild(root_1, stream_regex.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:245:4: itemStream
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_itemStream_in_sequenceItem1961);
                    itemStream219=itemStream();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, itemStream219.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sequenceItem"


    public static class itemStream_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "itemStream"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:248:1: itemStream : attributeName '=' rawStream -> ^( STREAM rawStream ( attributeName )? ) ;
    public final SiddhiQLGrammarParser.itemStream_return itemStream() throws RecognitionException {
        SiddhiQLGrammarParser.itemStream_return retval = new SiddhiQLGrammarParser.itemStream_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal221=null;
        SiddhiQLGrammarParser.attributeName_return attributeName220 =null;

        SiddhiQLGrammarParser.rawStream_return rawStream222 =null;


        CommonTree char_literal221_tree=null;
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_rawStream=new RewriteRuleSubtreeStream(adaptor,"rule rawStream");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:249:2: ( attributeName '=' rawStream -> ^( STREAM rawStream ( attributeName )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:249:4: attributeName '=' rawStream
            {
            pushFollow(FOLLOW_attributeName_in_itemStream1972);
            attributeName220=attributeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributeName.add(attributeName220.getTree());

            char_literal221=(Token)match(input,83,FOLLOW_83_in_itemStream1973); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal221);


            pushFollow(FOLLOW_rawStream_in_itemStream1974);
            rawStream222=rawStream();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rawStream.add(rawStream222.getTree());

            // AST REWRITE
            // elements: attributeName, rawStream
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 249:31: -> ^( STREAM rawStream ( attributeName )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:249:36: ^( STREAM rawStream ( attributeName )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STREAM, "STREAM")
                , root_1);

                adaptor.addChild(root_1, stream_rawStream.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:249:55: ( attributeName )?
                if ( stream_attributeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeName.nextTree());

                }
                stream_attributeName.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "itemStream"


    public static class regex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "regex"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:252:1: regex : ( '*' | '+' | '?' ) ( '?' )? ;
    public final SiddhiQLGrammarParser.regex_return regex() throws RecognitionException {
        SiddhiQLGrammarParser.regex_return retval = new SiddhiQLGrammarParser.regex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set223=null;
        Token char_literal224=null;

        CommonTree set223_tree=null;
        CommonTree char_literal224_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:253:2: ( ( '*' | '+' | '?' ) ( '?' )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:253:4: ( '*' | '+' | '?' ) ( '?' )?
            {
            root_0 = (CommonTree)adaptor.nil();


            set223=(Token)input.LT(1);

            if ( (input.LA(1) >= 73 && input.LA(1) <= 74)||input.LA(1)==87 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set223)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:253:18: ( '?' )?
            int alt65=2;
            switch ( input.LA(1) ) {
                case 87:
                    {
                    alt65=1;
                    }
                    break;
            }

            switch (alt65) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:253:18: '?'
                    {
                    char_literal224=(Token)match(input,87,FOLLOW_87_in_regex2007); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal224_tree = 
                    (CommonTree)adaptor.create(char_literal224)
                    ;
                    adaptor.addChild(root_0, char_literal224_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "regex"


    public static class outputSelection_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "outputSelection"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:256:1: outputSelection : outputAttributeList ( groupBy )? ( having )? -> ^( OUT_ATTRIBUTES outputAttributeList ) ( groupBy )? ( having )? ;
    public final SiddhiQLGrammarParser.outputSelection_return outputSelection() throws RecognitionException {
        SiddhiQLGrammarParser.outputSelection_return retval = new SiddhiQLGrammarParser.outputSelection_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.outputAttributeList_return outputAttributeList225 =null;

        SiddhiQLGrammarParser.groupBy_return groupBy226 =null;

        SiddhiQLGrammarParser.having_return having227 =null;


        RewriteRuleSubtreeStream stream_groupBy=new RewriteRuleSubtreeStream(adaptor,"rule groupBy");
        RewriteRuleSubtreeStream stream_outputAttributeList=new RewriteRuleSubtreeStream(adaptor,"rule outputAttributeList");
        RewriteRuleSubtreeStream stream_having=new RewriteRuleSubtreeStream(adaptor,"rule having");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:2: ( outputAttributeList ( groupBy )? ( having )? -> ^( OUT_ATTRIBUTES outputAttributeList ) ( groupBy )? ( having )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:5: outputAttributeList ( groupBy )? ( having )?
            {
            pushFollow(FOLLOW_outputAttributeList_in_outputSelection2020);
            outputAttributeList225=outputAttributeList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_outputAttributeList.add(outputAttributeList225.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:25: ( groupBy )?
            int alt66=2;
            switch ( input.LA(1) ) {
                case 109:
                    {
                    alt66=1;
                    }
                    break;
            }

            switch (alt66) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:25: groupBy
                    {
                    pushFollow(FOLLOW_groupBy_in_outputSelection2022);
                    groupBy226=groupBy();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_groupBy.add(groupBy226.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:34: ( having )?
            int alt67=2;
            switch ( input.LA(1) ) {
                case 110:
                    {
                    alt67=1;
                    }
                    break;
            }

            switch (alt67) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:34: having
                    {
                    pushFollow(FOLLOW_having_in_outputSelection2025);
                    having227=having();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_having.add(having227.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: having, outputAttributeList, groupBy
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 257:42: -> ^( OUT_ATTRIBUTES outputAttributeList ) ( groupBy )? ( having )?
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:46: ^( OUT_ATTRIBUTES outputAttributeList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OUT_ATTRIBUTES, "OUT_ATTRIBUTES")
                , root_1);

                adaptor.addChild(root_1, stream_outputAttributeList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:85: ( groupBy )?
                if ( stream_groupBy.hasNext() ) {
                    adaptor.addChild(root_0, stream_groupBy.nextTree());

                }
                stream_groupBy.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:257:94: ( having )?
                if ( stream_having.hasNext() ) {
                    adaptor.addChild(root_0, stream_having.nextTree());

                }
                stream_having.reset();

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outputSelection"


    public static class outputAttributeList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "outputAttributeList"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:260:1: outputAttributeList : ( 'select' '*' -> '*' | 'select' outputItem ( ',' outputItem )* -> ( ^( OUT_ATTRIBUTE outputItem ) )+ | -> '*' );
    public final SiddhiQLGrammarParser.outputAttributeList_return outputAttributeList() throws RecognitionException {
        SiddhiQLGrammarParser.outputAttributeList_return retval = new SiddhiQLGrammarParser.outputAttributeList_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal228=null;
        Token char_literal229=null;
        Token string_literal230=null;
        Token char_literal232=null;
        SiddhiQLGrammarParser.outputItem_return outputItem231 =null;

        SiddhiQLGrammarParser.outputItem_return outputItem233 =null;


        CommonTree string_literal228_tree=null;
        CommonTree char_literal229_tree=null;
        CommonTree string_literal230_tree=null;
        CommonTree char_literal232_tree=null;
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_outputItem=new RewriteRuleSubtreeStream(adaptor,"rule outputItem");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:261:2: ( 'select' '*' -> '*' | 'select' outputItem ( ',' outputItem )* -> ( ^( OUT_ATTRIBUTE outputItem ) )+ | -> '*' )
            int alt69=3;
            switch ( input.LA(1) ) {
            case 130:
                {
                switch ( input.LA(2) ) {
                case 73:
                    {
                    switch ( input.LA(3) ) {
                    case EOF:
                    case 80:
                    case 99:
                    case 109:
                    case 110:
                    case 113:
                    case 125:
                    case 126:
                    case 128:
                    case 137:
                        {
                        alt69=1;
                        }
                        break;
                    case BOOL_VAL:
                    case ID:
                    case ID_QUOTES:
                    case POSITIVE_DOUBLE_VAL:
                    case POSITIVE_FLOAT_VAL:
                    case POSITIVE_INT_VAL:
                    case POSITIVE_LONG_VAL:
                    case STRING_VAL:
                    case 70:
                    case 71:
                    case 73:
                    case 74:
                    case 76:
                    case 78:
                    case 93:
                    case 94:
                    case 100:
                    case 105:
                    case 115:
                    case 120:
                    case 133:
                        {
                        alt69=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 3, input);

                        throw nvae;

                    }

                    }
                    break;
                case BOOL_VAL:
                case ID:
                case ID_QUOTES:
                case POSITIVE_DOUBLE_VAL:
                case POSITIVE_FLOAT_VAL:
                case POSITIVE_INT_VAL:
                case POSITIVE_LONG_VAL:
                case STRING_VAL:
                case 70:
                case 71:
                case 74:
                case 76:
                case 78:
                case 93:
                case 94:
                case 100:
                case 105:
                case 115:
                case 120:
                case 133:
                    {
                    alt69=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;

                }

                }
                break;
            case EOF:
            case 80:
            case 99:
            case 109:
            case 110:
            case 113:
            case 125:
            case 126:
            case 128:
            case 137:
                {
                alt69=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }

            switch (alt69) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:261:4: 'select' '*'
                    {
                    string_literal228=(Token)match(input,130,FOLLOW_130_in_outputAttributeList2053); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_130.add(string_literal228);


                    char_literal229=(Token)match(input,73,FOLLOW_73_in_outputAttributeList2055); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(char_literal229);


                    // AST REWRITE
                    // elements: 73
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 261:17: -> '*'
                    {
                        adaptor.addChild(root_0, 
                        stream_73.nextNode()
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:262:4: 'select' outputItem ( ',' outputItem )*
                    {
                    string_literal230=(Token)match(input,130,FOLLOW_130_in_outputAttributeList2064); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_130.add(string_literal230);


                    pushFollow(FOLLOW_outputItem_in_outputAttributeList2066);
                    outputItem231=outputItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputItem.add(outputItem231.getTree());

                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:262:24: ( ',' outputItem )*
                    loop68:
                    do {
                        int alt68=2;
                        switch ( input.LA(1) ) {
                        case 75:
                            {
                            alt68=1;
                            }
                            break;

                        }

                        switch (alt68) {
                    	case 1 :
                    	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:262:25: ',' outputItem
                    	    {
                    	    char_literal232=(Token)match(input,75,FOLLOW_75_in_outputAttributeList2069); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_75.add(char_literal232);


                    	    pushFollow(FOLLOW_outputItem_in_outputAttributeList2071);
                    	    outputItem233=outputItem();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_outputItem.add(outputItem233.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    // AST REWRITE
                    // elements: outputItem
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 262:42: -> ( ^( OUT_ATTRIBUTE outputItem ) )+
                    {
                        if ( !(stream_outputItem.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_outputItem.hasNext() ) {
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:262:46: ^( OUT_ATTRIBUTE outputItem )
                            {
                            CommonTree root_1 = (CommonTree)adaptor.nil();
                            root_1 = (CommonTree)adaptor.becomeRoot(
                            (CommonTree)adaptor.create(OUT_ATTRIBUTE, "OUT_ATTRIBUTE")
                            , root_1);

                            adaptor.addChild(root_1, stream_outputItem.nextTree());

                            adaptor.addChild(root_0, root_1);
                            }

                        }
                        stream_outputItem.reset();

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:263:3: 
                    {
                    // AST REWRITE
                    // elements: 73
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 263:3: -> '*'
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(73, "73")
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outputAttributeList"


    public static class outputItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "outputItem"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:266:1: outputItem : ( extensionOutFunction 'as' id -> id extensionOutFunction | outFunction 'as' id -> outFunction id | expression 'as' id -> expression id | attributeVariable );
    public final SiddhiQLGrammarParser.outputItem_return outputItem() throws RecognitionException {
        SiddhiQLGrammarParser.outputItem_return retval = new SiddhiQLGrammarParser.outputItem_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal235=null;
        Token string_literal238=null;
        Token string_literal241=null;
        SiddhiQLGrammarParser.extensionOutFunction_return extensionOutFunction234 =null;

        SiddhiQLGrammarParser.id_return id236 =null;

        SiddhiQLGrammarParser.outFunction_return outFunction237 =null;

        SiddhiQLGrammarParser.id_return id239 =null;

        SiddhiQLGrammarParser.expression_return expression240 =null;

        SiddhiQLGrammarParser.id_return id242 =null;

        SiddhiQLGrammarParser.attributeVariable_return attributeVariable243 =null;


        CommonTree string_literal235_tree=null;
        CommonTree string_literal238_tree=null;
        CommonTree string_literal241_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_extensionOutFunction=new RewriteRuleSubtreeStream(adaptor,"rule extensionOutFunction");
        RewriteRuleSubtreeStream stream_outFunction=new RewriteRuleSubtreeStream(adaptor,"rule outFunction");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:267:2: ( extensionOutFunction 'as' id -> id extensionOutFunction | outFunction 'as' id -> outFunction id | expression 'as' id -> expression id | attributeVariable )
            int alt70=4;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA70_1 = input.LA(2);

                if ( (synpred90_SiddhiQLGrammar()) ) {
                    alt70=1;
                }
                else if ( (synpred91_SiddhiQLGrammar()) ) {
                    alt70=2;
                }
                else if ( (synpred92_SiddhiQLGrammar()) ) {
                    alt70=3;
                }
                else if ( (true) ) {
                    alt70=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;

                }
                }
                break;
            case ID_QUOTES:
                {
                int LA70_2 = input.LA(2);

                if ( (synpred90_SiddhiQLGrammar()) ) {
                    alt70=1;
                }
                else if ( (synpred92_SiddhiQLGrammar()) ) {
                    alt70=3;
                }
                else if ( (true) ) {
                    alt70=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 2, input);

                    throw nvae;

                }
                }
                break;
            case BOOL_VAL:
            case POSITIVE_DOUBLE_VAL:
            case POSITIVE_FLOAT_VAL:
            case POSITIVE_INT_VAL:
            case POSITIVE_LONG_VAL:
            case STRING_VAL:
            case 70:
            case 71:
            case 73:
            case 74:
            case 76:
            case 78:
            case 93:
            case 94:
            case 100:
            case 105:
            case 115:
            case 120:
            case 133:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }

            switch (alt70) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:267:4: extensionOutFunction 'as' id
                    {
                    pushFollow(FOLLOW_extensionOutFunction_in_outputItem2101);
                    extensionOutFunction234=extensionOutFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_extensionOutFunction.add(extensionOutFunction234.getTree());

                    string_literal235=(Token)match(input,93,FOLLOW_93_in_outputItem2103); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_93.add(string_literal235);


                    pushFollow(FOLLOW_id_in_outputItem2105);
                    id236=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id236.getTree());

                    // AST REWRITE
                    // elements: id, extensionOutFunction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 267:33: -> id extensionOutFunction
                    {
                        adaptor.addChild(root_0, stream_id.nextTree());

                        adaptor.addChild(root_0, stream_extensionOutFunction.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:268:4: outFunction 'as' id
                    {
                    pushFollow(FOLLOW_outFunction_in_outputItem2118);
                    outFunction237=outFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outFunction.add(outFunction237.getTree());

                    string_literal238=(Token)match(input,93,FOLLOW_93_in_outputItem2120); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_93.add(string_literal238);


                    pushFollow(FOLLOW_id_in_outputItem2122);
                    id239=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id239.getTree());

                    // AST REWRITE
                    // elements: outFunction, id
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 268:24: -> outFunction id
                    {
                        adaptor.addChild(root_0, stream_outFunction.nextTree());

                        adaptor.addChild(root_0, stream_id.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:269:4: expression 'as' id
                    {
                    pushFollow(FOLLOW_expression_in_outputItem2134);
                    expression240=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression240.getTree());

                    string_literal241=(Token)match(input,93,FOLLOW_93_in_outputItem2137); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_93.add(string_literal241);


                    pushFollow(FOLLOW_id_in_outputItem2139);
                    id242=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id242.getTree());

                    // AST REWRITE
                    // elements: expression, id
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 269:25: -> expression id
                    {
                        adaptor.addChild(root_0, stream_expression.nextTree());

                        adaptor.addChild(root_0, stream_id.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:270:4: attributeVariable
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeVariable_in_outputItem2153);
                    attributeVariable243=attributeVariable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeVariable243.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outputItem"


    public static class extensionOutFunction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "extensionOutFunction"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:273:1: extensionOutFunction : extensionId ':' functionId '(' ( parameters )? ')' -> ^( EXTENSION_FUNCTION extensionId functionId ( parameters )? ) ;
    public final SiddhiQLGrammarParser.extensionOutFunction_return extensionOutFunction() throws RecognitionException {
        SiddhiQLGrammarParser.extensionOutFunction_return retval = new SiddhiQLGrammarParser.extensionOutFunction_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal245=null;
        Token char_literal247=null;
        Token char_literal249=null;
        SiddhiQLGrammarParser.extensionId_return extensionId244 =null;

        SiddhiQLGrammarParser.functionId_return functionId246 =null;

        SiddhiQLGrammarParser.parameters_return parameters248 =null;


        CommonTree char_literal245_tree=null;
        CommonTree char_literal247_tree=null;
        CommonTree char_literal249_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_extensionId=new RewriteRuleSubtreeStream(adaptor,"rule extensionId");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        RewriteRuleSubtreeStream stream_functionId=new RewriteRuleSubtreeStream(adaptor,"rule functionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:2: ( extensionId ':' functionId '(' ( parameters )? ')' -> ^( EXTENSION_FUNCTION extensionId functionId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:4: extensionId ':' functionId '(' ( parameters )? ')'
            {
            pushFollow(FOLLOW_extensionId_in_extensionOutFunction2164);
            extensionId244=extensionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_extensionId.add(extensionId244.getTree());

            char_literal245=(Token)match(input,79,FOLLOW_79_in_extensionOutFunction2166); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal245);


            pushFollow(FOLLOW_functionId_in_extensionOutFunction2168);
            functionId246=functionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionId.add(functionId246.getTree());

            char_literal247=(Token)match(input,71,FOLLOW_71_in_extensionOutFunction2171); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(char_literal247);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:36: ( parameters )?
            int alt71=2;
            switch ( input.LA(1) ) {
                case BOOL_VAL:
                case ID:
                case ID_QUOTES:
                case POSITIVE_DOUBLE_VAL:
                case POSITIVE_FLOAT_VAL:
                case POSITIVE_INT_VAL:
                case POSITIVE_LONG_VAL:
                case STRING_VAL:
                case 70:
                case 71:
                case 73:
                case 74:
                case 75:
                case 76:
                case 78:
                case 94:
                case 100:
                case 105:
                case 115:
                case 120:
                case 133:
                    {
                    alt71=1;
                    }
                    break;
                case 72:
                    {
                    int LA71_2 = input.LA(2);

                    if ( (synpred93_SiddhiQLGrammar()) ) {
                        alt71=1;
                    }
                    }
                    break;
            }

            switch (alt71) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:36: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_extensionOutFunction2173);
                    parameters248=parameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parameters.add(parameters248.getTree());

                    }
                    break;

            }


            char_literal249=(Token)match(input,72,FOLLOW_72_in_extensionOutFunction2176); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal249);


            // AST REWRITE
            // elements: parameters, functionId, extensionId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 274:52: -> ^( EXTENSION_FUNCTION extensionId functionId ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:55: ^( EXTENSION_FUNCTION extensionId functionId ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXTENSION_FUNCTION, "EXTENSION_FUNCTION")
                , root_1);

                adaptor.addChild(root_1, stream_extensionId.nextTree());

                adaptor.addChild(root_1, stream_functionId.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:100: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "extensionOutFunction"


    public static class outFunction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "outFunction"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:277:1: outFunction : ID '(' ( parameters )? ')' -> ^( FUNCTION ID ( parameters )? ) ;
    public final SiddhiQLGrammarParser.outFunction_return outFunction() throws RecognitionException {
        SiddhiQLGrammarParser.outFunction_return retval = new SiddhiQLGrammarParser.outFunction_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID250=null;
        Token char_literal251=null;
        Token char_literal253=null;
        SiddhiQLGrammarParser.parameters_return parameters252 =null;


        CommonTree ID250_tree=null;
        CommonTree char_literal251_tree=null;
        CommonTree char_literal253_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:2: ( ID '(' ( parameters )? ')' -> ^( FUNCTION ID ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:4: ID '(' ( parameters )? ')'
            {
            ID250=(Token)match(input,ID,FOLLOW_ID_in_outFunction2201); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID250);


            char_literal251=(Token)match(input,71,FOLLOW_71_in_outFunction2203); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(char_literal251);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:11: ( parameters )?
            int alt72=2;
            switch ( input.LA(1) ) {
                case BOOL_VAL:
                case ID:
                case ID_QUOTES:
                case POSITIVE_DOUBLE_VAL:
                case POSITIVE_FLOAT_VAL:
                case POSITIVE_INT_VAL:
                case POSITIVE_LONG_VAL:
                case STRING_VAL:
                case 70:
                case 71:
                case 73:
                case 74:
                case 75:
                case 76:
                case 78:
                case 94:
                case 100:
                case 105:
                case 115:
                case 120:
                case 133:
                    {
                    alt72=1;
                    }
                    break;
                case 72:
                    {
                    int LA72_2 = input.LA(2);

                    if ( (synpred94_SiddhiQLGrammar()) ) {
                        alt72=1;
                    }
                    }
                    break;
            }

            switch (alt72) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:11: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_outFunction2205);
                    parameters252=parameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parameters.add(parameters252.getTree());

                    }
                    break;

            }


            char_literal253=(Token)match(input,72,FOLLOW_72_in_outFunction2208); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal253);


            // AST REWRITE
            // elements: parameters, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 278:27: -> ^( FUNCTION ID ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:30: ^( FUNCTION ID ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FUNCTION, "FUNCTION")
                , root_1);

                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:45: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outFunction"


    public static class groupBy_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "groupBy"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:281:1: groupBy : 'group' 'by' attributeVariable ( ',' attributeVariable )* -> ^( 'group' ( attributeVariable )+ ) ;
    public final SiddhiQLGrammarParser.groupBy_return groupBy() throws RecognitionException {
        SiddhiQLGrammarParser.groupBy_return retval = new SiddhiQLGrammarParser.groupBy_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal254=null;
        Token string_literal255=null;
        Token char_literal257=null;
        SiddhiQLGrammarParser.attributeVariable_return attributeVariable256 =null;

        SiddhiQLGrammarParser.attributeVariable_return attributeVariable258 =null;


        CommonTree string_literal254_tree=null;
        CommonTree string_literal255_tree=null;
        CommonTree char_literal257_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_attributeVariable=new RewriteRuleSubtreeStream(adaptor,"rule attributeVariable");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:282:2: ( 'group' 'by' attributeVariable ( ',' attributeVariable )* -> ^( 'group' ( attributeVariable )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:282:4: 'group' 'by' attributeVariable ( ',' attributeVariable )*
            {
            string_literal254=(Token)match(input,109,FOLLOW_109_in_groupBy2231); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(string_literal254);


            string_literal255=(Token)match(input,95,FOLLOW_95_in_groupBy2233); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(string_literal255);


            pushFollow(FOLLOW_attributeVariable_in_groupBy2235);
            attributeVariable256=attributeVariable();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributeVariable.add(attributeVariable256.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:282:35: ( ',' attributeVariable )*
            loop73:
            do {
                int alt73=2;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt73=1;
                    }
                    break;

                }

                switch (alt73) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:282:36: ',' attributeVariable
            	    {
            	    char_literal257=(Token)match(input,75,FOLLOW_75_in_groupBy2238); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_75.add(char_literal257);


            	    pushFollow(FOLLOW_attributeVariable_in_groupBy2240);
            	    attributeVariable258=attributeVariable();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attributeVariable.add(attributeVariable258.getTree());

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);


            // AST REWRITE
            // elements: attributeVariable, 109
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 282:61: -> ^( 'group' ( attributeVariable )+ )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:282:66: ^( 'group' ( attributeVariable )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_109.nextNode()
                , root_1);

                if ( !(stream_attributeVariable.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attributeVariable.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeVariable.nextTree());

                }
                stream_attributeVariable.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "groupBy"


    public static class having_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "having"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:285:1: having : 'having' condition -> ^( 'having' condition ) ;
    public final SiddhiQLGrammarParser.having_return having() throws RecognitionException {
        SiddhiQLGrammarParser.having_return retval = new SiddhiQLGrammarParser.having_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal259=null;
        SiddhiQLGrammarParser.condition_return condition260 =null;


        CommonTree string_literal259_tree=null;
        RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:286:2: ( 'having' condition -> ^( 'having' condition ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:286:4: 'having' condition
            {
            string_literal259=(Token)match(input,110,FOLLOW_110_in_having2265); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_110.add(string_literal259);


            pushFollow(FOLLOW_condition_in_having2267);
            condition260=condition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_condition.add(condition260.getTree());

            // AST REWRITE
            // elements: condition, 110
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 286:24: -> ^( 'having' condition )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:286:27: ^( 'having' condition )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_110.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_condition.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "having"


    public static class filterHandler_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filterHandler"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:289:1: filterHandler : '[' condition ']' -> ^( FILTER condition ) ;
    public final SiddhiQLGrammarParser.filterHandler_return filterHandler() throws RecognitionException {
        SiddhiQLGrammarParser.filterHandler_return retval = new SiddhiQLGrammarParser.filterHandler_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal261=null;
        Token char_literal263=null;
        SiddhiQLGrammarParser.condition_return condition262 =null;


        CommonTree char_literal261_tree=null;
        CommonTree char_literal263_tree=null;
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:290:2: ( '[' condition ']' -> ^( FILTER condition ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:290:4: '[' condition ']'
            {
            char_literal261=(Token)match(input,88,FOLLOW_88_in_filterHandler2287); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(char_literal261);


            pushFollow(FOLLOW_condition_in_filterHandler2289);
            condition262=condition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_condition.add(condition262.getTree());

            char_literal263=(Token)match(input,89,FOLLOW_89_in_filterHandler2291); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal263);


            // AST REWRITE
            // elements: condition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 290:23: -> ^( FILTER condition )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:290:29: ^( FILTER condition )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FILTER, "FILTER")
                , root_1);

                adaptor.addChild(root_1, stream_condition.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filterHandler"


    public static class transformHandler_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "transformHandler"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:293:1: transformHandler : '#' transform '.' extensibleId ( '(' ( parameters )? ')' )? -> ^( TRANSFORM extensibleId ( parameters )? ) ;
    public final SiddhiQLGrammarParser.transformHandler_return transformHandler() throws RecognitionException {
        SiddhiQLGrammarParser.transformHandler_return retval = new SiddhiQLGrammarParser.transformHandler_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal264=null;
        Token char_literal266=null;
        Token char_literal268=null;
        Token char_literal270=null;
        SiddhiQLGrammarParser.transform_return transform265 =null;

        SiddhiQLGrammarParser.extensibleId_return extensibleId267 =null;

        SiddhiQLGrammarParser.parameters_return parameters269 =null;


        CommonTree char_literal264_tree=null;
        CommonTree char_literal266_tree=null;
        CommonTree char_literal268_tree=null;
        CommonTree char_literal270_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_transform=new RewriteRuleSubtreeStream(adaptor,"rule transform");
        RewriteRuleSubtreeStream stream_extensibleId=new RewriteRuleSubtreeStream(adaptor,"rule extensibleId");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:2: ( '#' transform '.' extensibleId ( '(' ( parameters )? ')' )? -> ^( TRANSFORM extensibleId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:4: '#' transform '.' extensibleId ( '(' ( parameters )? ')' )?
            {
            char_literal264=(Token)match(input,69,FOLLOW_69_in_transformHandler2315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(char_literal264);


            pushFollow(FOLLOW_transform_in_transformHandler2317);
            transform265=transform();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_transform.add(transform265.getTree());

            char_literal266=(Token)match(input,77,FOLLOW_77_in_transformHandler2319); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal266);


            pushFollow(FOLLOW_extensibleId_in_transformHandler2321);
            extensibleId267=extensibleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_extensibleId.add(extensibleId267.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:36: ( '(' ( parameters )? ')' )?
            int alt75=2;
            switch ( input.LA(1) ) {
                case 71:
                    {
                    alt75=1;
                    }
                    break;
            }

            switch (alt75) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:37: '(' ( parameters )? ')'
                    {
                    char_literal268=(Token)match(input,71,FOLLOW_71_in_transformHandler2325); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal268);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:41: ( parameters )?
                    int alt74=2;
                    switch ( input.LA(1) ) {
                        case BOOL_VAL:
                        case ID:
                        case ID_QUOTES:
                        case POSITIVE_DOUBLE_VAL:
                        case POSITIVE_FLOAT_VAL:
                        case POSITIVE_INT_VAL:
                        case POSITIVE_LONG_VAL:
                        case STRING_VAL:
                        case 70:
                        case 71:
                        case 73:
                        case 74:
                        case 75:
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
                        case 72:
                            {
                            int LA74_2 = input.LA(2);

                            if ( (synpred96_SiddhiQLGrammar()) ) {
                                alt74=1;
                            }
                            }
                            break;
                    }

                    switch (alt74) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:41: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_transformHandler2327);
                            parameters269=parameters();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameters.add(parameters269.getTree());

                            }
                            break;

                    }


                    char_literal270=(Token)match(input,72,FOLLOW_72_in_transformHandler2330); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal270);


                    }
                    break;

            }


            // AST REWRITE
            // elements: parameters, extensibleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 294:60: -> ^( TRANSFORM extensibleId ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:65: ^( TRANSFORM extensibleId ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TRANSFORM, "TRANSFORM")
                , root_1);

                adaptor.addChild(root_1, stream_extensibleId.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:91: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "transformHandler"


    public static class windowHandler_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "windowHandler"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:297:1: windowHandler : '#' window '.' extensibleId ( '(' ( parameters )? ')' )? -> ^( WINDOW extensibleId ( parameters )? ) ;
    public final SiddhiQLGrammarParser.windowHandler_return windowHandler() throws RecognitionException {
        SiddhiQLGrammarParser.windowHandler_return retval = new SiddhiQLGrammarParser.windowHandler_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal271=null;
        Token char_literal273=null;
        Token char_literal275=null;
        Token char_literal277=null;
        SiddhiQLGrammarParser.window_return window272 =null;

        SiddhiQLGrammarParser.extensibleId_return extensibleId274 =null;

        SiddhiQLGrammarParser.parameters_return parameters276 =null;


        CommonTree char_literal271_tree=null;
        CommonTree char_literal273_tree=null;
        CommonTree char_literal275_tree=null;
        CommonTree char_literal277_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_window=new RewriteRuleSubtreeStream(adaptor,"rule window");
        RewriteRuleSubtreeStream stream_extensibleId=new RewriteRuleSubtreeStream(adaptor,"rule extensibleId");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:2: ( '#' window '.' extensibleId ( '(' ( parameters )? ')' )? -> ^( WINDOW extensibleId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:4: '#' window '.' extensibleId ( '(' ( parameters )? ')' )?
            {
            char_literal271=(Token)match(input,69,FOLLOW_69_in_windowHandler2358); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(char_literal271);


            pushFollow(FOLLOW_window_in_windowHandler2360);
            window272=window();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_window.add(window272.getTree());

            char_literal273=(Token)match(input,77,FOLLOW_77_in_windowHandler2363); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal273);


            pushFollow(FOLLOW_extensibleId_in_windowHandler2365);
            extensibleId274=extensibleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_extensibleId.add(extensibleId274.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:34: ( '(' ( parameters )? ')' )?
            int alt77=2;
            switch ( input.LA(1) ) {
                case 71:
                    {
                    alt77=1;
                    }
                    break;
            }

            switch (alt77) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:35: '(' ( parameters )? ')'
                    {
                    char_literal275=(Token)match(input,71,FOLLOW_71_in_windowHandler2369); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal275);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:39: ( parameters )?
                    int alt76=2;
                    switch ( input.LA(1) ) {
                        case BOOL_VAL:
                        case ID:
                        case ID_QUOTES:
                        case POSITIVE_DOUBLE_VAL:
                        case POSITIVE_FLOAT_VAL:
                        case POSITIVE_INT_VAL:
                        case POSITIVE_LONG_VAL:
                        case STRING_VAL:
                        case 70:
                        case 71:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 78:
                        case 94:
                        case 100:
                        case 105:
                        case 115:
                        case 120:
                        case 133:
                            {
                            alt76=1;
                            }
                            break;
                        case 72:
                            {
                            int LA76_2 = input.LA(2);

                            if ( (synpred98_SiddhiQLGrammar()) ) {
                                alt76=1;
                            }
                            }
                            break;
                    }

                    switch (alt76) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:39: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_windowHandler2371);
                            parameters276=parameters();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameters.add(parameters276.getTree());

                            }
                            break;

                    }


                    char_literal277=(Token)match(input,72,FOLLOW_72_in_windowHandler2374); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal277);


                    }
                    break;

            }


            // AST REWRITE
            // elements: parameters, extensibleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 298:58: -> ^( WINDOW extensibleId ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:63: ^( WINDOW extensibleId ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(WINDOW, "WINDOW")
                , root_1);

                adaptor.addChild(root_1, stream_extensibleId.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:86: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "windowHandler"


    public static class extensibleId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "extensibleId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:301:1: extensibleId : ( extensionId ':' functionId -> ^( EXTENSION extensionId functionId ) | id );
    public final SiddhiQLGrammarParser.extensibleId_return extensibleId() throws RecognitionException {
        SiddhiQLGrammarParser.extensibleId_return retval = new SiddhiQLGrammarParser.extensibleId_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal279=null;
        SiddhiQLGrammarParser.extensionId_return extensionId278 =null;

        SiddhiQLGrammarParser.functionId_return functionId280 =null;

        SiddhiQLGrammarParser.id_return id281 =null;


        CommonTree char_literal279_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleSubtreeStream stream_extensionId=new RewriteRuleSubtreeStream(adaptor,"rule extensionId");
        RewriteRuleSubtreeStream stream_functionId=new RewriteRuleSubtreeStream(adaptor,"rule functionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:302:2: ( extensionId ':' functionId -> ^( EXTENSION extensionId functionId ) | id )
            int alt78=2;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                switch ( input.LA(2) ) {
                case 79:
                    {
                    alt78=1;
                    }
                    break;
                case EOF:
                case 69:
                case 71:
                case 80:
                case 93:
                case 99:
                case 108:
                case 109:
                case 110:
                case 112:
                case 113:
                case 117:
                case 119:
                case 122:
                case 124:
                case 125:
                case 126:
                case 128:
                case 129:
                case 130:
                case 136:
                case 137:
                case 139:
                    {
                    alt78=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }

            switch (alt78) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:302:4: extensionId ':' functionId
                    {
                    pushFollow(FOLLOW_extensionId_in_extensibleId2402);
                    extensionId278=extensionId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_extensionId.add(extensionId278.getTree());

                    char_literal279=(Token)match(input,79,FOLLOW_79_in_extensibleId2404); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_79.add(char_literal279);


                    pushFollow(FOLLOW_functionId_in_extensibleId2406);
                    functionId280=functionId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionId.add(functionId280.getTree());

                    // AST REWRITE
                    // elements: functionId, extensionId
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 302:31: -> ^( EXTENSION extensionId functionId )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:302:35: ^( EXTENSION extensionId functionId )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(EXTENSION, "EXTENSION")
                        , root_1);

                        adaptor.addChild(root_1, stream_extensionId.nextTree());

                        adaptor.addChild(root_1, stream_functionId.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:303:4: id
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_id_in_extensibleId2424);
                    id281=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id281.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "extensibleId"


    public static class parameters_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parameters"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:306:1: parameters : parameter ( ',' parameter )* -> ^( PARAMETERS ( parameter )+ ) ;
    public final SiddhiQLGrammarParser.parameters_return parameters() throws RecognitionException {
        SiddhiQLGrammarParser.parameters_return retval = new SiddhiQLGrammarParser.parameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal283=null;
        SiddhiQLGrammarParser.parameter_return parameter282 =null;

        SiddhiQLGrammarParser.parameter_return parameter284 =null;


        CommonTree char_literal283_tree=null;
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_parameter=new RewriteRuleSubtreeStream(adaptor,"rule parameter");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:307:2: ( parameter ( ',' parameter )* -> ^( PARAMETERS ( parameter )+ ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:307:4: parameter ( ',' parameter )*
            {
            pushFollow(FOLLOW_parameter_in_parameters2435);
            parameter282=parameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_parameter.add(parameter282.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:307:14: ( ',' parameter )*
            loop79:
            do {
                int alt79=2;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt79=1;
                    }
                    break;

                }

                switch (alt79) {
            	case 1 :
            	    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:307:15: ',' parameter
            	    {
            	    char_literal283=(Token)match(input,75,FOLLOW_75_in_parameters2438); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_75.add(char_literal283);


            	    pushFollow(FOLLOW_parameter_in_parameters2440);
            	    parameter284=parameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_parameter.add(parameter284.getTree());

            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            // AST REWRITE
            // elements: parameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 307:32: -> ^( PARAMETERS ( parameter )+ )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:307:36: ^( PARAMETERS ( parameter )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PARAMETERS, "PARAMETERS")
                , root_1);

                if ( !(stream_parameter.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_parameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameter.nextTree());

                }
                stream_parameter.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parameters"


    public static class time_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "time"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:310:1: time : constant ;
    public final SiddhiQLGrammarParser.time_return time() throws RecognitionException {
        SiddhiQLGrammarParser.time_return retval = new SiddhiQLGrammarParser.time_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.constant_return constant285 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:311:2: ( constant )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:311:4: constant
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_constant_in_time2464);
            constant285=constant();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, constant285.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "time"


    public static class parameter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parameter"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:314:1: parameter : expression ;
    public final SiddhiQLGrammarParser.parameter_return parameter() throws RecognitionException {
        SiddhiQLGrammarParser.parameter_return retval = new SiddhiQLGrammarParser.parameter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.expression_return expression286 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:315:2: ( expression )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:315:4: expression
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_parameter2476);
            expression286=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression286.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parameter"


    public static class collect_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "collect"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:318:1: collect : ( countStart ':' countEnd | countStart ':' | ':' countEnd | countStartAndEnd );
    public final SiddhiQLGrammarParser.collect_return collect() throws RecognitionException {
        SiddhiQLGrammarParser.collect_return retval = new SiddhiQLGrammarParser.collect_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal288=null;
        Token char_literal291=null;
        Token char_literal292=null;
        SiddhiQLGrammarParser.countStart_return countStart287 =null;

        SiddhiQLGrammarParser.countEnd_return countEnd289 =null;

        SiddhiQLGrammarParser.countStart_return countStart290 =null;

        SiddhiQLGrammarParser.countEnd_return countEnd293 =null;

        SiddhiQLGrammarParser.countStartAndEnd_return countStartAndEnd294 =null;


        CommonTree char_literal288_tree=null;
        CommonTree char_literal291_tree=null;
        CommonTree char_literal292_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:319:2: ( countStart ':' countEnd | countStart ':' | ':' countEnd | countStartAndEnd )
            int alt80=4;
            switch ( input.LA(1) ) {
            case POSITIVE_INT_VAL:
                {
                switch ( input.LA(2) ) {
                case 79:
                    {
                    switch ( input.LA(3) ) {
                    case POSITIVE_INT_VAL:
                        {
                        alt80=1;
                        }
                        break;
                    case 85:
                        {
                        alt80=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 80, 3, input);

                        throw nvae;

                    }

                    }
                    break;
                case 85:
                    {
                    alt80=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;

                }

                }
                break;
            case 79:
                {
                alt80=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;

            }

            switch (alt80) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:319:4: countStart ':' countEnd
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_countStart_in_collect2487);
                    countStart287=countStart();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countStart287.getTree());

                    char_literal288=(Token)match(input,79,FOLLOW_79_in_collect2489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal288_tree = 
                    (CommonTree)adaptor.create(char_literal288)
                    ;
                    adaptor.addChild(root_0, char_literal288_tree);
                    }

                    pushFollow(FOLLOW_countEnd_in_collect2491);
                    countEnd289=countEnd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countEnd289.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:320:4: countStart ':'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_countStart_in_collect2496);
                    countStart290=countStart();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countStart290.getTree());

                    char_literal291=(Token)match(input,79,FOLLOW_79_in_collect2498); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal291_tree = 
                    (CommonTree)adaptor.create(char_literal291)
                    ;
                    adaptor.addChild(root_0, char_literal291_tree);
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:321:4: ':' countEnd
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal292=(Token)match(input,79,FOLLOW_79_in_collect2503); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal292_tree = 
                    (CommonTree)adaptor.create(char_literal292)
                    ;
                    adaptor.addChild(root_0, char_literal292_tree);
                    }

                    pushFollow(FOLLOW_countEnd_in_collect2505);
                    countEnd293=countEnd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countEnd293.getTree());

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:322:4: countStartAndEnd
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_countStartAndEnd_in_collect2510);
                    countStartAndEnd294=countStartAndEnd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countStartAndEnd294.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "collect"


    public static class countStart_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "countStart"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:325:1: countStart : POSITIVE_INT_VAL ;
    public final SiddhiQLGrammarParser.countStart_return countStart() throws RecognitionException {
        SiddhiQLGrammarParser.countStart_return retval = new SiddhiQLGrammarParser.countStart_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL295=null;

        CommonTree POSITIVE_INT_VAL295_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:325:12: ( POSITIVE_INT_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:325:13: POSITIVE_INT_VAL
            {
            root_0 = (CommonTree)adaptor.nil();


            POSITIVE_INT_VAL295=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_countStart2519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POSITIVE_INT_VAL295_tree = 
            (CommonTree)adaptor.create(POSITIVE_INT_VAL295)
            ;
            adaptor.addChild(root_0, POSITIVE_INT_VAL295_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "countStart"


    public static class countEnd_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "countEnd"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:327:1: countEnd : POSITIVE_INT_VAL ;
    public final SiddhiQLGrammarParser.countEnd_return countEnd() throws RecognitionException {
        SiddhiQLGrammarParser.countEnd_return retval = new SiddhiQLGrammarParser.countEnd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL296=null;

        CommonTree POSITIVE_INT_VAL296_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:327:10: ( POSITIVE_INT_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:327:11: POSITIVE_INT_VAL
            {
            root_0 = (CommonTree)adaptor.nil();


            POSITIVE_INT_VAL296=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_countEnd2526); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POSITIVE_INT_VAL296_tree = 
            (CommonTree)adaptor.create(POSITIVE_INT_VAL296)
            ;
            adaptor.addChild(root_0, POSITIVE_INT_VAL296_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "countEnd"


    public static class countStartAndEnd_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "countStartAndEnd"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:329:1: countStartAndEnd : POSITIVE_INT_VAL ;
    public final SiddhiQLGrammarParser.countStartAndEnd_return countStartAndEnd() throws RecognitionException {
        SiddhiQLGrammarParser.countStartAndEnd_return retval = new SiddhiQLGrammarParser.countStartAndEnd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL297=null;

        CommonTree POSITIVE_INT_VAL297_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:329:18: ( POSITIVE_INT_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:329:19: POSITIVE_INT_VAL
            {
            root_0 = (CommonTree)adaptor.nil();


            POSITIVE_INT_VAL297=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_countStartAndEnd2533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POSITIVE_INT_VAL297_tree = 
            (CommonTree)adaptor.create(POSITIVE_INT_VAL297)
            ;
            adaptor.addChild(root_0, POSITIVE_INT_VAL297_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "countStartAndEnd"


    public static class condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:333:1: condition : conditionExpression -> ^( CONDITION conditionExpression ) ;
    public final SiddhiQLGrammarParser.condition_return condition() throws RecognitionException {
        SiddhiQLGrammarParser.condition_return retval = new SiddhiQLGrammarParser.condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.conditionExpression_return conditionExpression298 =null;


        RewriteRuleSubtreeStream stream_conditionExpression=new RewriteRuleSubtreeStream(adaptor,"rule conditionExpression");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:334:2: ( conditionExpression -> ^( CONDITION conditionExpression ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:334:3: conditionExpression
            {
            pushFollow(FOLLOW_conditionExpression_in_condition2543);
            conditionExpression298=conditionExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_conditionExpression.add(conditionExpression298.getTree());

            // AST REWRITE
            // elements: conditionExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 334:24: -> ^( CONDITION conditionExpression )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:334:27: ^( CONDITION conditionExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONDITION, "CONDITION")
                , root_1);

                adaptor.addChild(root_1, stream_conditionExpression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "condition"


    public static class conditionExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "conditionExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:337:1: conditionExpression : andCondition ( 'or' ^ conditionExpression )? ;
    public final SiddhiQLGrammarParser.conditionExpression_return conditionExpression() throws RecognitionException {
        SiddhiQLGrammarParser.conditionExpression_return retval = new SiddhiQLGrammarParser.conditionExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal300=null;
        SiddhiQLGrammarParser.andCondition_return andCondition299 =null;

        SiddhiQLGrammarParser.conditionExpression_return conditionExpression301 =null;


        CommonTree string_literal300_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:338:5: ( andCondition ( 'or' ^ conditionExpression )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:338:7: andCondition ( 'or' ^ conditionExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_andCondition_in_conditionExpression2566);
            andCondition299=andCondition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andCondition299.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:338:20: ( 'or' ^ conditionExpression )?
            int alt81=2;
            switch ( input.LA(1) ) {
                case 123:
                    {
                    int LA81_1 = input.LA(2);

                    if ( (synpred105_SiddhiQLGrammar()) ) {
                        alt81=1;
                    }
                    }
                    break;
            }

            switch (alt81) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:338:21: 'or' ^ conditionExpression
                    {
                    string_literal300=(Token)match(input,123,FOLLOW_123_in_conditionExpression2569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal300_tree = 
                    (CommonTree)adaptor.create(string_literal300)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(string_literal300_tree, root_0);
                    }

                    pushFollow(FOLLOW_conditionExpression_in_conditionExpression2572);
                    conditionExpression301=conditionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionExpression301.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "conditionExpression"


    public static class andCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "andCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:341:1: andCondition : inCondition ( 'and' ^ conditionExpression )? ;
    public final SiddhiQLGrammarParser.andCondition_return andCondition() throws RecognitionException {
        SiddhiQLGrammarParser.andCondition_return retval = new SiddhiQLGrammarParser.andCondition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal303=null;
        SiddhiQLGrammarParser.inCondition_return inCondition302 =null;

        SiddhiQLGrammarParser.conditionExpression_return conditionExpression304 =null;


        CommonTree string_literal303_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:342:2: ( inCondition ( 'and' ^ conditionExpression )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:342:4: inCondition ( 'and' ^ conditionExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_inCondition_in_andCondition2586);
            inCondition302=inCondition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, inCondition302.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:342:16: ( 'and' ^ conditionExpression )?
            int alt82=2;
            switch ( input.LA(1) ) {
                case 92:
                    {
                    int LA82_1 = input.LA(2);

                    if ( (synpred106_SiddhiQLGrammar()) ) {
                        alt82=1;
                    }
                    }
                    break;
            }

            switch (alt82) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:342:17: 'and' ^ conditionExpression
                    {
                    string_literal303=(Token)match(input,92,FOLLOW_92_in_andCondition2589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal303_tree = 
                    (CommonTree)adaptor.create(string_literal303)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(string_literal303_tree, root_0);
                    }

                    pushFollow(FOLLOW_conditionExpression_in_andCondition2592);
                    conditionExpression304=conditionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionExpression304.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "andCondition"


    public static class inCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:345:1: inCondition : compareCondition ( 'in' ^ streamId )? ;
    public final SiddhiQLGrammarParser.inCondition_return inCondition() throws RecognitionException {
        SiddhiQLGrammarParser.inCondition_return retval = new SiddhiQLGrammarParser.inCondition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal306=null;
        SiddhiQLGrammarParser.compareCondition_return compareCondition305 =null;

        SiddhiQLGrammarParser.streamId_return streamId307 =null;


        CommonTree string_literal306_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:346:5: ( compareCondition ( 'in' ^ streamId )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:346:7: compareCondition ( 'in' ^ streamId )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_compareCondition_in_inCondition2609);
            compareCondition305=compareCondition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compareCondition305.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:346:24: ( 'in' ^ streamId )?
            int alt83=2;
            switch ( input.LA(1) ) {
                case 111:
                    {
                    int LA83_1 = input.LA(2);

                    if ( (synpred107_SiddhiQLGrammar()) ) {
                        alt83=1;
                    }
                    }
                    break;
            }

            switch (alt83) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:346:25: 'in' ^ streamId
                    {
                    string_literal306=(Token)match(input,111,FOLLOW_111_in_inCondition2612); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal306_tree = 
                    (CommonTree)adaptor.create(string_literal306)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(string_literal306_tree, root_0);
                    }

                    pushFollow(FOLLOW_streamId_in_inCondition2615);
                    streamId307=streamId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, streamId307.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inCondition"


    public static class compareCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "compareCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:349:1: compareCondition : ( expression compareOperation ^ expression | boolVal | '(' conditionExpression ')' -> conditionExpression | notCondition | extensionCondition | functionCondition );
    public final SiddhiQLGrammarParser.compareCondition_return compareCondition() throws RecognitionException {
        SiddhiQLGrammarParser.compareCondition_return retval = new SiddhiQLGrammarParser.compareCondition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal312=null;
        Token char_literal314=null;
        SiddhiQLGrammarParser.expression_return expression308 =null;

        SiddhiQLGrammarParser.compareOperation_return compareOperation309 =null;

        SiddhiQLGrammarParser.expression_return expression310 =null;

        SiddhiQLGrammarParser.boolVal_return boolVal311 =null;

        SiddhiQLGrammarParser.conditionExpression_return conditionExpression313 =null;

        SiddhiQLGrammarParser.notCondition_return notCondition315 =null;

        SiddhiQLGrammarParser.extensionCondition_return extensionCondition316 =null;

        SiddhiQLGrammarParser.functionCondition_return functionCondition317 =null;


        CommonTree char_literal312_tree=null;
        CommonTree char_literal314_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_conditionExpression=new RewriteRuleSubtreeStream(adaptor,"rule conditionExpression");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:350:2: ( expression compareOperation ^ expression | boolVal | '(' conditionExpression ')' -> conditionExpression | notCondition | extensionCondition | functionCondition )
            int alt84=6;
            switch ( input.LA(1) ) {
            case POSITIVE_DOUBLE_VAL:
            case POSITIVE_FLOAT_VAL:
            case POSITIVE_INT_VAL:
            case POSITIVE_LONG_VAL:
            case STRING_VAL:
            case 68:
            case 70:
            case 73:
            case 74:
            case 76:
            case 78:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 94:
            case 96:
            case 100:
            case 105:
            case 114:
            case 115:
            case 120:
            case 133:
                {
                alt84=1;
                }
                break;
            case BOOL_VAL:
                {
                int LA84_6 = input.LA(2);

                if ( (synpred108_SiddhiQLGrammar()) ) {
                    alt84=1;
                }
                else if ( (synpred109_SiddhiQLGrammar()) ) {
                    alt84=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 84, 6, input);

                    throw nvae;

                }
                }
                break;
            case ID:
            case ID_QUOTES:
                {
                int LA84_13 = input.LA(2);

                if ( (synpred108_SiddhiQLGrammar()) ) {
                    alt84=1;
                }
                else if ( (synpred112_SiddhiQLGrammar()) ) {
                    alt84=5;
                }
                else if ( (true) ) {
                    alt84=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 84, 13, input);

                    throw nvae;

                }
                }
                break;
            case 71:
                {
                int LA84_15 = input.LA(2);

                if ( (synpred108_SiddhiQLGrammar()) ) {
                    alt84=1;
                }
                else if ( (synpred110_SiddhiQLGrammar()) ) {
                    alt84=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 84, 15, input);

                    throw nvae;

                }
                }
                break;
            case 121:
                {
                alt84=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }

            switch (alt84) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:350:3: expression compareOperation ^ expression
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_expression_in_compareCondition2628);
                    expression308=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression308.getTree());

                    pushFollow(FOLLOW_compareOperation_in_compareCondition2630);
                    compareOperation309=compareOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(compareOperation309.getTree(), root_0);

                    pushFollow(FOLLOW_expression_in_compareCondition2633);
                    expression310=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression310.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:351:3: boolVal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_boolVal_in_compareCondition2637);
                    boolVal311=boolVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, boolVal311.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:352:6: '(' conditionExpression ')'
                    {
                    char_literal312=(Token)match(input,71,FOLLOW_71_in_compareCondition2644); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal312);


                    pushFollow(FOLLOW_conditionExpression_in_compareCondition2645);
                    conditionExpression313=conditionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_conditionExpression.add(conditionExpression313.getTree());

                    char_literal314=(Token)match(input,72,FOLLOW_72_in_compareCondition2647); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal314);


                    // AST REWRITE
                    // elements: conditionExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 352:33: -> conditionExpression
                    {
                        adaptor.addChild(root_0, stream_conditionExpression.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:353:6: notCondition
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_notCondition_in_compareCondition2658);
                    notCondition315=notCondition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, notCondition315.getTree());

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:354:6: extensionCondition
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_extensionCondition_in_compareCondition2665);
                    extensionCondition316=extensionCondition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extensionCondition316.getTree());

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:355:6: functionCondition
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCondition_in_compareCondition2672);
                    functionCondition317=functionCondition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCondition317.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "compareCondition"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:358:1: expression : minusExpression ( '+' ^ expression )? ;
    public final SiddhiQLGrammarParser.expression_return expression() throws RecognitionException {
        SiddhiQLGrammarParser.expression_return retval = new SiddhiQLGrammarParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal319=null;
        SiddhiQLGrammarParser.minusExpression_return minusExpression318 =null;

        SiddhiQLGrammarParser.expression_return expression320 =null;


        CommonTree char_literal319_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:359:5: ( minusExpression ( '+' ^ expression )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:359:6: minusExpression ( '+' ^ expression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_minusExpression_in_expression2685);
            minusExpression318=minusExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, minusExpression318.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:359:22: ( '+' ^ expression )?
            int alt85=2;
            switch ( input.LA(1) ) {
                case 74:
                    {
                    alt85=1;
                    }
                    break;
            }

            switch (alt85) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:359:23: '+' ^ expression
                    {
                    char_literal319=(Token)match(input,74,FOLLOW_74_in_expression2688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal319_tree = 
                    (CommonTree)adaptor.create(char_literal319)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal319_tree, root_0);
                    }

                    pushFollow(FOLLOW_expression_in_expression2691);
                    expression320=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression320.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class minusExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "minusExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:362:1: minusExpression : multiplyExpression ( '-' ^ minusExpression )? ;
    public final SiddhiQLGrammarParser.minusExpression_return minusExpression() throws RecognitionException {
        SiddhiQLGrammarParser.minusExpression_return retval = new SiddhiQLGrammarParser.minusExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal322=null;
        SiddhiQLGrammarParser.multiplyExpression_return multiplyExpression321 =null;

        SiddhiQLGrammarParser.minusExpression_return minusExpression323 =null;


        CommonTree char_literal322_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:363:5: ( multiplyExpression ( '-' ^ minusExpression )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:363:6: multiplyExpression ( '-' ^ minusExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_multiplyExpression_in_minusExpression2709);
            multiplyExpression321=multiplyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplyExpression321.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:363:25: ( '-' ^ minusExpression )?
            int alt86=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt86=1;
                    }
                    break;
            }

            switch (alt86) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:363:26: '-' ^ minusExpression
                    {
                    char_literal322=(Token)match(input,76,FOLLOW_76_in_minusExpression2712); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal322_tree = 
                    (CommonTree)adaptor.create(char_literal322)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal322_tree, root_0);
                    }

                    pushFollow(FOLLOW_minusExpression_in_minusExpression2715);
                    minusExpression323=minusExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, minusExpression323.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "minusExpression"


    public static class multiplyExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multiplyExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:366:1: multiplyExpression : divisionExpression ( '*' ^ multiplyExpression )? ;
    public final SiddhiQLGrammarParser.multiplyExpression_return multiplyExpression() throws RecognitionException {
        SiddhiQLGrammarParser.multiplyExpression_return retval = new SiddhiQLGrammarParser.multiplyExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal325=null;
        SiddhiQLGrammarParser.divisionExpression_return divisionExpression324 =null;

        SiddhiQLGrammarParser.multiplyExpression_return multiplyExpression326 =null;


        CommonTree char_literal325_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:367:5: ( divisionExpression ( '*' ^ multiplyExpression )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:367:6: divisionExpression ( '*' ^ multiplyExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_divisionExpression_in_multiplyExpression2733);
            divisionExpression324=divisionExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, divisionExpression324.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:367:25: ( '*' ^ multiplyExpression )?
            int alt87=2;
            switch ( input.LA(1) ) {
                case 73:
                    {
                    alt87=1;
                    }
                    break;
            }

            switch (alt87) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:367:26: '*' ^ multiplyExpression
                    {
                    char_literal325=(Token)match(input,73,FOLLOW_73_in_multiplyExpression2736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal325_tree = 
                    (CommonTree)adaptor.create(char_literal325)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal325_tree, root_0);
                    }

                    pushFollow(FOLLOW_multiplyExpression_in_multiplyExpression2739);
                    multiplyExpression326=multiplyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplyExpression326.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "multiplyExpression"


    public static class divisionExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "divisionExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:370:1: divisionExpression : modExpression ( '/' ^ divisionExpression )? ;
    public final SiddhiQLGrammarParser.divisionExpression_return divisionExpression() throws RecognitionException {
        SiddhiQLGrammarParser.divisionExpression_return retval = new SiddhiQLGrammarParser.divisionExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal328=null;
        SiddhiQLGrammarParser.modExpression_return modExpression327 =null;

        SiddhiQLGrammarParser.divisionExpression_return divisionExpression329 =null;


        CommonTree char_literal328_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:371:5: ( modExpression ( '/' ^ divisionExpression )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:371:6: modExpression ( '/' ^ divisionExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_modExpression_in_divisionExpression2757);
            modExpression327=modExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, modExpression327.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:371:20: ( '/' ^ divisionExpression )?
            int alt88=2;
            switch ( input.LA(1) ) {
                case 78:
                    {
                    alt88=1;
                    }
                    break;
            }

            switch (alt88) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:371:21: '/' ^ divisionExpression
                    {
                    char_literal328=(Token)match(input,78,FOLLOW_78_in_divisionExpression2760); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal328_tree = 
                    (CommonTree)adaptor.create(char_literal328)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal328_tree, root_0);
                    }

                    pushFollow(FOLLOW_divisionExpression_in_divisionExpression2763);
                    divisionExpression329=divisionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, divisionExpression329.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "divisionExpression"


    public static class modExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "modExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:374:1: modExpression : valueExpression ( '%' ^ modExpression )? ;
    public final SiddhiQLGrammarParser.modExpression_return modExpression() throws RecognitionException {
        SiddhiQLGrammarParser.modExpression_return retval = new SiddhiQLGrammarParser.modExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal331=null;
        SiddhiQLGrammarParser.valueExpression_return valueExpression330 =null;

        SiddhiQLGrammarParser.modExpression_return modExpression332 =null;


        CommonTree char_literal331_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:375:5: ( valueExpression ( '%' ^ modExpression )? )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:375:6: valueExpression ( '%' ^ modExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_valueExpression_in_modExpression2781);
            valueExpression330=valueExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, valueExpression330.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:375:22: ( '%' ^ modExpression )?
            int alt89=2;
            switch ( input.LA(1) ) {
                case 70:
                    {
                    alt89=1;
                    }
                    break;
            }

            switch (alt89) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:375:23: '%' ^ modExpression
                    {
                    char_literal331=(Token)match(input,70,FOLLOW_70_in_modExpression2784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal331_tree = 
                    (CommonTree)adaptor.create(char_literal331)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal331_tree, root_0);
                    }

                    pushFollow(FOLLOW_modExpression_in_modExpression2787);
                    modExpression332=modExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modExpression332.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "modExpression"


    public static class valueExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "valueExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:378:1: valueExpression : ( constant | attributeVariable | type | '(' expression ')' -> expression | extensionExpression | functionExpression );
    public final SiddhiQLGrammarParser.valueExpression_return valueExpression() throws RecognitionException {
        SiddhiQLGrammarParser.valueExpression_return retval = new SiddhiQLGrammarParser.valueExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal336=null;
        Token char_literal338=null;
        SiddhiQLGrammarParser.constant_return constant333 =null;

        SiddhiQLGrammarParser.attributeVariable_return attributeVariable334 =null;

        SiddhiQLGrammarParser.type_return type335 =null;

        SiddhiQLGrammarParser.expression_return expression337 =null;

        SiddhiQLGrammarParser.extensionExpression_return extensionExpression339 =null;

        SiddhiQLGrammarParser.functionExpression_return functionExpression340 =null;


        CommonTree char_literal336_tree=null;
        CommonTree char_literal338_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:379:5: ( constant | attributeVariable | type | '(' expression ')' -> expression | extensionExpression | functionExpression )
            int alt90=6;
            switch ( input.LA(1) ) {
            case EOF:
            case BOOL_VAL:
            case POSITIVE_DOUBLE_VAL:
            case POSITIVE_FLOAT_VAL:
            case POSITIVE_INT_VAL:
            case POSITIVE_LONG_VAL:
            case STRING_VAL:
            case 68:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 78:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 89:
            case 92:
            case 93:
            case 96:
            case 99:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 123:
            case 125:
            case 126:
            case 128:
            case 130:
            case 137:
            case 139:
                {
                alt90=1;
                }
                break;
            case ID:
            case ID_QUOTES:
                {
                int LA90_2 = input.LA(2);

                if ( (LA90_2==79) ) {
                    alt90=5;
                }
                else if ( (synpred119_SiddhiQLGrammar()) ) {
                    alt90=2;
                }
                else if ( (true) ) {
                    alt90=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 2, input);

                    throw nvae;

                }
                }
                break;
            case 94:
            case 100:
            case 105:
            case 115:
            case 120:
            case 133:
                {
                alt90=3;
                }
                break;
            case 71:
                {
                alt90=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }

            switch (alt90) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:379:7: constant
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_constant_in_valueExpression2806);
                    constant333=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant333.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:380:7: attributeVariable
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeVariable_in_valueExpression2814);
                    attributeVariable334=attributeVariable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeVariable334.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:381:7: type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_type_in_valueExpression2822);
                    type335=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type335.getTree());

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:382:7: '(' expression ')'
                    {
                    char_literal336=(Token)match(input,71,FOLLOW_71_in_valueExpression2830); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal336);


                    pushFollow(FOLLOW_expression_in_valueExpression2831);
                    expression337=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression337.getTree());

                    char_literal338=(Token)match(input,72,FOLLOW_72_in_valueExpression2833); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal338);


                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 382:25: -> expression
                    {
                        adaptor.addChild(root_0, stream_expression.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:383:7: extensionExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_extensionExpression_in_valueExpression2845);
                    extensionExpression339=extensionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extensionExpression339.getTree());

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:384:7: functionExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionExpression_in_valueExpression2853);
                    functionExpression340=functionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionExpression340.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "valueExpression"


    public static class notCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "notCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:387:1: notCondition : ( 'not' '(' conditionExpression ')' -> ^( 'not' conditionExpression ) | 'not' conditionExpression -> ^( 'not' conditionExpression ) );
    public final SiddhiQLGrammarParser.notCondition_return notCondition() throws RecognitionException {
        SiddhiQLGrammarParser.notCondition_return retval = new SiddhiQLGrammarParser.notCondition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal341=null;
        Token char_literal342=null;
        Token char_literal344=null;
        Token string_literal345=null;
        SiddhiQLGrammarParser.conditionExpression_return conditionExpression343 =null;

        SiddhiQLGrammarParser.conditionExpression_return conditionExpression346 =null;


        CommonTree string_literal341_tree=null;
        CommonTree char_literal342_tree=null;
        CommonTree char_literal344_tree=null;
        CommonTree string_literal345_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_conditionExpression=new RewriteRuleSubtreeStream(adaptor,"rule conditionExpression");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:388:2: ( 'not' '(' conditionExpression ')' -> ^( 'not' conditionExpression ) | 'not' conditionExpression -> ^( 'not' conditionExpression ) )
            int alt91=2;
            switch ( input.LA(1) ) {
            case 121:
                {
                int LA91_1 = input.LA(2);

                if ( (synpred123_SiddhiQLGrammar()) ) {
                    alt91=1;
                }
                else if ( (true) ) {
                    alt91=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }

            switch (alt91) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:388:3: 'not' '(' conditionExpression ')'
                    {
                    string_literal341=(Token)match(input,121,FOLLOW_121_in_notCondition2866); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(string_literal341);


                    char_literal342=(Token)match(input,71,FOLLOW_71_in_notCondition2868); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal342);


                    pushFollow(FOLLOW_conditionExpression_in_notCondition2869);
                    conditionExpression343=conditionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_conditionExpression.add(conditionExpression343.getTree());

                    char_literal344=(Token)match(input,72,FOLLOW_72_in_notCondition2870); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal344);


                    // AST REWRITE
                    // elements: 121, conditionExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 388:35: -> ^( 'not' conditionExpression )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:388:39: ^( 'not' conditionExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_121.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_conditionExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:389:3: 'not' conditionExpression
                    {
                    string_literal345=(Token)match(input,121,FOLLOW_121_in_notCondition2883); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(string_literal345);


                    pushFollow(FOLLOW_conditionExpression_in_notCondition2885);
                    conditionExpression346=conditionExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_conditionExpression.add(conditionExpression346.getTree());

                    // AST REWRITE
                    // elements: conditionExpression, 121
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 389:29: -> ^( 'not' conditionExpression )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:389:33: ^( 'not' conditionExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_121.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_conditionExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "notCondition"


    public static class extensionCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "extensionCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:392:1: extensionCondition : extensionId ':' functionId ( '(' ( parameters )? ')' )? -> ^( CONDITION_FUNCTION functionId extensionId ( parameters )? ) ;
    public final SiddhiQLGrammarParser.extensionCondition_return extensionCondition() throws RecognitionException {
        SiddhiQLGrammarParser.extensionCondition_return retval = new SiddhiQLGrammarParser.extensionCondition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal348=null;
        Token char_literal350=null;
        Token char_literal352=null;
        SiddhiQLGrammarParser.extensionId_return extensionId347 =null;

        SiddhiQLGrammarParser.functionId_return functionId349 =null;

        SiddhiQLGrammarParser.parameters_return parameters351 =null;


        CommonTree char_literal348_tree=null;
        CommonTree char_literal350_tree=null;
        CommonTree char_literal352_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_extensionId=new RewriteRuleSubtreeStream(adaptor,"rule extensionId");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        RewriteRuleSubtreeStream stream_functionId=new RewriteRuleSubtreeStream(adaptor,"rule functionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:5: ( extensionId ':' functionId ( '(' ( parameters )? ')' )? -> ^( CONDITION_FUNCTION functionId extensionId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:6: extensionId ':' functionId ( '(' ( parameters )? ')' )?
            {
            pushFollow(FOLLOW_extensionId_in_extensionCondition2907);
            extensionId347=extensionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_extensionId.add(extensionId347.getTree());

            char_literal348=(Token)match(input,79,FOLLOW_79_in_extensionCondition2909); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal348);


            pushFollow(FOLLOW_functionId_in_extensionCondition2911);
            functionId349=functionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionId.add(functionId349.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:34: ( '(' ( parameters )? ')' )?
            int alt93=2;
            switch ( input.LA(1) ) {
                case 71:
                    {
                    alt93=1;
                    }
                    break;
            }

            switch (alt93) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:35: '(' ( parameters )? ')'
                    {
                    char_literal350=(Token)match(input,71,FOLLOW_71_in_extensionCondition2915); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal350);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:39: ( parameters )?
                    int alt92=2;
                    switch ( input.LA(1) ) {
                        case BOOL_VAL:
                        case ID:
                        case ID_QUOTES:
                        case POSITIVE_DOUBLE_VAL:
                        case POSITIVE_FLOAT_VAL:
                        case POSITIVE_INT_VAL:
                        case POSITIVE_LONG_VAL:
                        case STRING_VAL:
                        case 70:
                        case 71:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 78:
                        case 94:
                        case 100:
                        case 105:
                        case 115:
                        case 120:
                        case 133:
                            {
                            alt92=1;
                            }
                            break;
                        case 72:
                            {
                            int LA92_2 = input.LA(2);

                            if ( (synpred124_SiddhiQLGrammar()) ) {
                                alt92=1;
                            }
                            }
                            break;
                    }

                    switch (alt92) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:39: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_extensionCondition2917);
                            parameters351=parameters();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameters.add(parameters351.getTree());

                            }
                            break;

                    }


                    char_literal352=(Token)match(input,72,FOLLOW_72_in_extensionCondition2920); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal352);


                    }
                    break;

            }


            // AST REWRITE
            // elements: extensionId, parameters, functionId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 393:58: -> ^( CONDITION_FUNCTION functionId extensionId ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:63: ^( CONDITION_FUNCTION functionId extensionId ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONDITION_FUNCTION, "CONDITION_FUNCTION")
                , root_1);

                adaptor.addChild(root_1, stream_functionId.nextTree());

                adaptor.addChild(root_1, stream_extensionId.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:108: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "extensionCondition"


    public static class functionCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCondition"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:396:1: functionCondition : functionId ( '(' ( parameters )? ')' )? -> ^( CONDITION_FUNCTION functionId ( parameters )? ) ;
    public final SiddhiQLGrammarParser.functionCondition_return functionCondition() throws RecognitionException {
        SiddhiQLGrammarParser.functionCondition_return retval = new SiddhiQLGrammarParser.functionCondition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal354=null;
        Token char_literal356=null;
        SiddhiQLGrammarParser.functionId_return functionId353 =null;

        SiddhiQLGrammarParser.parameters_return parameters355 =null;


        CommonTree char_literal354_tree=null;
        CommonTree char_literal356_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        RewriteRuleSubtreeStream stream_functionId=new RewriteRuleSubtreeStream(adaptor,"rule functionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:5: ( functionId ( '(' ( parameters )? ')' )? -> ^( CONDITION_FUNCTION functionId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:6: functionId ( '(' ( parameters )? ')' )?
            {
            pushFollow(FOLLOW_functionId_in_functionCondition2955);
            functionId353=functionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionId.add(functionId353.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:18: ( '(' ( parameters )? ')' )?
            int alt95=2;
            switch ( input.LA(1) ) {
                case 71:
                    {
                    alt95=1;
                    }
                    break;
            }

            switch (alt95) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:19: '(' ( parameters )? ')'
                    {
                    char_literal354=(Token)match(input,71,FOLLOW_71_in_functionCondition2959); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal354);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:23: ( parameters )?
                    int alt94=2;
                    switch ( input.LA(1) ) {
                        case BOOL_VAL:
                        case ID:
                        case ID_QUOTES:
                        case POSITIVE_DOUBLE_VAL:
                        case POSITIVE_FLOAT_VAL:
                        case POSITIVE_INT_VAL:
                        case POSITIVE_LONG_VAL:
                        case STRING_VAL:
                        case 70:
                        case 71:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 78:
                        case 94:
                        case 100:
                        case 105:
                        case 115:
                        case 120:
                        case 133:
                            {
                            alt94=1;
                            }
                            break;
                        case 72:
                            {
                            int LA94_2 = input.LA(2);

                            if ( (synpred126_SiddhiQLGrammar()) ) {
                                alt94=1;
                            }
                            }
                            break;
                    }

                    switch (alt94) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:23: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_functionCondition2961);
                            parameters355=parameters();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameters.add(parameters355.getTree());

                            }
                            break;

                    }


                    char_literal356=(Token)match(input,72,FOLLOW_72_in_functionCondition2964); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal356);


                    }
                    break;

            }


            // AST REWRITE
            // elements: parameters, functionId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 397:42: -> ^( CONDITION_FUNCTION functionId ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:47: ^( CONDITION_FUNCTION functionId ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONDITION_FUNCTION, "CONDITION_FUNCTION")
                , root_1);

                adaptor.addChild(root_1, stream_functionId.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:80: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionCondition"


    public static class extensionExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "extensionExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:400:1: extensionExpression : extensionId ':' functionId ( '(' ( parameters )? ')' )? -> ^( EXTENSION_FUNCTION functionId extensionId ( parameters )? ) ;
    public final SiddhiQLGrammarParser.extensionExpression_return extensionExpression() throws RecognitionException {
        SiddhiQLGrammarParser.extensionExpression_return retval = new SiddhiQLGrammarParser.extensionExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal358=null;
        Token char_literal360=null;
        Token char_literal362=null;
        SiddhiQLGrammarParser.extensionId_return extensionId357 =null;

        SiddhiQLGrammarParser.functionId_return functionId359 =null;

        SiddhiQLGrammarParser.parameters_return parameters361 =null;


        CommonTree char_literal358_tree=null;
        CommonTree char_literal360_tree=null;
        CommonTree char_literal362_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_extensionId=new RewriteRuleSubtreeStream(adaptor,"rule extensionId");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        RewriteRuleSubtreeStream stream_functionId=new RewriteRuleSubtreeStream(adaptor,"rule functionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:5: ( extensionId ':' functionId ( '(' ( parameters )? ')' )? -> ^( EXTENSION_FUNCTION functionId extensionId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:6: extensionId ':' functionId ( '(' ( parameters )? ')' )?
            {
            pushFollow(FOLLOW_extensionId_in_extensionExpression2997);
            extensionId357=extensionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_extensionId.add(extensionId357.getTree());

            char_literal358=(Token)match(input,79,FOLLOW_79_in_extensionExpression2999); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal358);


            pushFollow(FOLLOW_functionId_in_extensionExpression3001);
            functionId359=functionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionId.add(functionId359.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:34: ( '(' ( parameters )? ')' )?
            int alt97=2;
            switch ( input.LA(1) ) {
                case 71:
                    {
                    alt97=1;
                    }
                    break;
            }

            switch (alt97) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:35: '(' ( parameters )? ')'
                    {
                    char_literal360=(Token)match(input,71,FOLLOW_71_in_extensionExpression3005); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal360);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:39: ( parameters )?
                    int alt96=2;
                    switch ( input.LA(1) ) {
                        case BOOL_VAL:
                        case ID:
                        case ID_QUOTES:
                        case POSITIVE_DOUBLE_VAL:
                        case POSITIVE_FLOAT_VAL:
                        case POSITIVE_INT_VAL:
                        case POSITIVE_LONG_VAL:
                        case STRING_VAL:
                        case 70:
                        case 71:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 78:
                        case 94:
                        case 100:
                        case 105:
                        case 115:
                        case 120:
                        case 133:
                            {
                            alt96=1;
                            }
                            break;
                        case 72:
                            {
                            int LA96_2 = input.LA(2);

                            if ( (synpred128_SiddhiQLGrammar()) ) {
                                alt96=1;
                            }
                            }
                            break;
                    }

                    switch (alt96) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:39: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_extensionExpression3007);
                            parameters361=parameters();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameters.add(parameters361.getTree());

                            }
                            break;

                    }


                    char_literal362=(Token)match(input,72,FOLLOW_72_in_extensionExpression3010); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal362);


                    }
                    break;

            }


            // AST REWRITE
            // elements: parameters, extensionId, functionId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 401:58: -> ^( EXTENSION_FUNCTION functionId extensionId ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:63: ^( EXTENSION_FUNCTION functionId extensionId ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXTENSION_FUNCTION, "EXTENSION_FUNCTION")
                , root_1);

                adaptor.addChild(root_1, stream_functionId.nextTree());

                adaptor.addChild(root_1, stream_extensionId.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:108: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "extensionExpression"


    public static class functionExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionExpression"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:404:1: functionExpression : functionId ( '(' ( parameters )? ')' )? -> ^( EXTENSION_FUNCTION functionId ( parameters )? ) ;
    public final SiddhiQLGrammarParser.functionExpression_return functionExpression() throws RecognitionException {
        SiddhiQLGrammarParser.functionExpression_return retval = new SiddhiQLGrammarParser.functionExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal364=null;
        Token char_literal366=null;
        SiddhiQLGrammarParser.functionId_return functionId363 =null;

        SiddhiQLGrammarParser.parameters_return parameters365 =null;


        CommonTree char_literal364_tree=null;
        CommonTree char_literal366_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_parameters=new RewriteRuleSubtreeStream(adaptor,"rule parameters");
        RewriteRuleSubtreeStream stream_functionId=new RewriteRuleSubtreeStream(adaptor,"rule functionId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:5: ( functionId ( '(' ( parameters )? ')' )? -> ^( EXTENSION_FUNCTION functionId ( parameters )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:6: functionId ( '(' ( parameters )? ')' )?
            {
            pushFollow(FOLLOW_functionId_in_functionExpression3045);
            functionId363=functionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionId.add(functionId363.getTree());

            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:18: ( '(' ( parameters )? ')' )?
            int alt99=2;
            switch ( input.LA(1) ) {
                case 71:
                    {
                    alt99=1;
                    }
                    break;
            }

            switch (alt99) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:19: '(' ( parameters )? ')'
                    {
                    char_literal364=(Token)match(input,71,FOLLOW_71_in_functionExpression3049); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(char_literal364);


                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:23: ( parameters )?
                    int alt98=2;
                    switch ( input.LA(1) ) {
                        case BOOL_VAL:
                        case ID:
                        case ID_QUOTES:
                        case POSITIVE_DOUBLE_VAL:
                        case POSITIVE_FLOAT_VAL:
                        case POSITIVE_INT_VAL:
                        case POSITIVE_LONG_VAL:
                        case STRING_VAL:
                        case 70:
                        case 71:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 78:
                        case 94:
                        case 100:
                        case 105:
                        case 115:
                        case 120:
                        case 133:
                            {
                            alt98=1;
                            }
                            break;
                        case 72:
                            {
                            int LA98_2 = input.LA(2);

                            if ( (synpred130_SiddhiQLGrammar()) ) {
                                alt98=1;
                            }
                            }
                            break;
                    }

                    switch (alt98) {
                        case 1 :
                            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:23: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_functionExpression3051);
                            parameters365=parameters();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameters.add(parameters365.getTree());

                            }
                            break;

                    }


                    char_literal366=(Token)match(input,72,FOLLOW_72_in_functionExpression3054); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(char_literal366);


                    }
                    break;

            }


            // AST REWRITE
            // elements: functionId, parameters
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 405:42: -> ^( EXTENSION_FUNCTION functionId ( parameters )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:47: ^( EXTENSION_FUNCTION functionId ( parameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXTENSION_FUNCTION, "EXTENSION_FUNCTION")
                , root_1);

                adaptor.addChild(root_1, stream_functionId.nextTree());

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:80: ( parameters )?
                if ( stream_parameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameters.nextTree());

                }
                stream_parameters.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionExpression"


    public static class constant_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constant"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:410:1: constant : ( intVal -> ^( CONSTANT intVal ) | longVal -> ^( CONSTANT longVal ) | floatVal -> ^( CONSTANT floatVal ) | doubleVal -> ^( CONSTANT doubleVal ) | boolVal -> ^( CONSTANT boolVal ) | stringVal -> ^( CONSTANT stringVal ) | timeExpr -> ^( CONSTANT timeExpr ) );
    public final SiddhiQLGrammarParser.constant_return constant() throws RecognitionException {
        SiddhiQLGrammarParser.constant_return retval = new SiddhiQLGrammarParser.constant_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.intVal_return intVal367 =null;

        SiddhiQLGrammarParser.longVal_return longVal368 =null;

        SiddhiQLGrammarParser.floatVal_return floatVal369 =null;

        SiddhiQLGrammarParser.doubleVal_return doubleVal370 =null;

        SiddhiQLGrammarParser.boolVal_return boolVal371 =null;

        SiddhiQLGrammarParser.stringVal_return stringVal372 =null;

        SiddhiQLGrammarParser.timeExpr_return timeExpr373 =null;


        RewriteRuleSubtreeStream stream_timeExpr=new RewriteRuleSubtreeStream(adaptor,"rule timeExpr");
        RewriteRuleSubtreeStream stream_boolVal=new RewriteRuleSubtreeStream(adaptor,"rule boolVal");
        RewriteRuleSubtreeStream stream_floatVal=new RewriteRuleSubtreeStream(adaptor,"rule floatVal");
        RewriteRuleSubtreeStream stream_longVal=new RewriteRuleSubtreeStream(adaptor,"rule longVal");
        RewriteRuleSubtreeStream stream_doubleVal=new RewriteRuleSubtreeStream(adaptor,"rule doubleVal");
        RewriteRuleSubtreeStream stream_intVal=new RewriteRuleSubtreeStream(adaptor,"rule intVal");
        RewriteRuleSubtreeStream stream_stringVal=new RewriteRuleSubtreeStream(adaptor,"rule stringVal");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:411:2: ( intVal -> ^( CONSTANT intVal ) | longVal -> ^( CONSTANT longVal ) | floatVal -> ^( CONSTANT floatVal ) | doubleVal -> ^( CONSTANT doubleVal ) | boolVal -> ^( CONSTANT boolVal ) | stringVal -> ^( CONSTANT stringVal ) | timeExpr -> ^( CONSTANT timeExpr ) )
            int alt100=7;
            switch ( input.LA(1) ) {
            case 76:
                {
                int LA100_1 = input.LA(2);

                if ( (synpred132_SiddhiQLGrammar()) ) {
                    alt100=1;
                }
                else if ( (synpred133_SiddhiQLGrammar()) ) {
                    alt100=2;
                }
                else if ( (synpred134_SiddhiQLGrammar()) ) {
                    alt100=3;
                }
                else if ( (synpred135_SiddhiQLGrammar()) ) {
                    alt100=4;
                }
                else if ( (true) ) {
                    alt100=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 1, input);

                    throw nvae;

                }
                }
                break;
            case POSITIVE_INT_VAL:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case 68:
                case 70:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 78:
                case 80:
                case 81:
                case 82:
                case 84:
                case 85:
                case 86:
                case 89:
                case 92:
                case 93:
                case 96:
                case 99:
                case 109:
                case 110:
                case 111:
                case 113:
                case 114:
                case 123:
                case 125:
                case 126:
                case 128:
                case 130:
                case 137:
                case 139:
                    {
                    alt100=1;
                    }
                    break;
                case ID:
                    {
                    alt100=7;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 2, input);

                    throw nvae;

                }

                }
                break;
            case POSITIVE_LONG_VAL:
                {
                alt100=2;
                }
                break;
            case POSITIVE_FLOAT_VAL:
                {
                alt100=3;
                }
                break;
            case POSITIVE_DOUBLE_VAL:
                {
                alt100=4;
                }
                break;
            case BOOL_VAL:
                {
                alt100=5;
                }
                break;
            case STRING_VAL:
                {
                alt100=6;
                }
                break;
            case EOF:
            case 68:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 78:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 89:
            case 92:
            case 93:
            case 96:
            case 99:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 123:
            case 125:
            case 126:
            case 128:
            case 130:
            case 137:
            case 139:
                {
                alt100=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }

            switch (alt100) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:411:3: intVal
                    {
                    pushFollow(FOLLOW_intVal_in_constant3086);
                    intVal367=intVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_intVal.add(intVal367.getTree());

                    // AST REWRITE
                    // elements: intVal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 411:10: -> ^( CONSTANT intVal )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:411:13: ^( CONSTANT intVal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, stream_intVal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:412:3: longVal
                    {
                    pushFollow(FOLLOW_longVal_in_constant3099);
                    longVal368=longVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_longVal.add(longVal368.getTree());

                    // AST REWRITE
                    // elements: longVal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 412:11: -> ^( CONSTANT longVal )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:412:14: ^( CONSTANT longVal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, stream_longVal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:413:3: floatVal
                    {
                    pushFollow(FOLLOW_floatVal_in_constant3112);
                    floatVal369=floatVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_floatVal.add(floatVal369.getTree());

                    // AST REWRITE
                    // elements: floatVal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 413:13: -> ^( CONSTANT floatVal )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:413:16: ^( CONSTANT floatVal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, stream_floatVal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:414:3: doubleVal
                    {
                    pushFollow(FOLLOW_doubleVal_in_constant3126);
                    doubleVal370=doubleVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_doubleVal.add(doubleVal370.getTree());

                    // AST REWRITE
                    // elements: doubleVal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 414:13: -> ^( CONSTANT doubleVal )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:414:16: ^( CONSTANT doubleVal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, stream_doubleVal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:415:3: boolVal
                    {
                    pushFollow(FOLLOW_boolVal_in_constant3139);
                    boolVal371=boolVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_boolVal.add(boolVal371.getTree());

                    // AST REWRITE
                    // elements: boolVal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 415:11: -> ^( CONSTANT boolVal )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:415:14: ^( CONSTANT boolVal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, stream_boolVal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:416:3: stringVal
                    {
                    pushFollow(FOLLOW_stringVal_in_constant3152);
                    stringVal372=stringVal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringVal.add(stringVal372.getTree());

                    // AST REWRITE
                    // elements: stringVal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 416:13: -> ^( CONSTANT stringVal )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:416:16: ^( CONSTANT stringVal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, stream_stringVal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 7 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:417:3: timeExpr
                    {
                    pushFollow(FOLLOW_timeExpr_in_constant3165);
                    timeExpr373=timeExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_timeExpr.add(timeExpr373.getTree());

                    // AST REWRITE
                    // elements: timeExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 417:14: -> ^( CONSTANT timeExpr )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:417:17: ^( CONSTANT timeExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, stream_timeExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constant"


    public static class partitionId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partitionId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:420:1: partitionId : id ;
    public final SiddhiQLGrammarParser.partitionId_return partitionId() throws RecognitionException {
        SiddhiQLGrammarParser.partitionId_return retval = new SiddhiQLGrammarParser.partitionId_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id374 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:420:12: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:420:14: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_partitionId3185);
            id374=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id374.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partitionId"


    public static class streamId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "streamId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:422:1: streamId : id ;
    public final SiddhiQLGrammarParser.streamId_return streamId() throws RecognitionException {
        SiddhiQLGrammarParser.streamId_return retval = new SiddhiQLGrammarParser.streamId_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id375 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:422:9: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:422:11: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_streamId3192);
            id375=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id375.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "streamId"


    public static class attributeVariable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeVariable"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:424:1: attributeVariable : ( streamPositionAttributeName | streamAttributeName | attributeName );
    public final SiddhiQLGrammarParser.attributeVariable_return attributeVariable() throws RecognitionException {
        SiddhiQLGrammarParser.attributeVariable_return retval = new SiddhiQLGrammarParser.attributeVariable_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.streamPositionAttributeName_return streamPositionAttributeName376 =null;

        SiddhiQLGrammarParser.streamAttributeName_return streamAttributeName377 =null;

        SiddhiQLGrammarParser.attributeName_return attributeName378 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:425:2: ( streamPositionAttributeName | streamAttributeName | attributeName )
            int alt101=3;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                switch ( input.LA(2) ) {
                case 88:
                    {
                    alt101=1;
                    }
                    break;
                case 77:
                    {
                    alt101=2;
                    }
                    break;
                case EOF:
                case 68:
                case 70:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 78:
                case 80:
                case 81:
                case 82:
                case 84:
                case 85:
                case 86:
                case 89:
                case 92:
                case 93:
                case 96:
                case 99:
                case 109:
                case 110:
                case 111:
                case 113:
                case 114:
                case 123:
                case 125:
                case 126:
                case 128:
                case 130:
                case 137:
                case 139:
                    {
                    alt101=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }

            switch (alt101) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:425:3: streamPositionAttributeName
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_streamPositionAttributeName_in_attributeVariable3200);
                    streamPositionAttributeName376=streamPositionAttributeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, streamPositionAttributeName376.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:425:31: streamAttributeName
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_streamAttributeName_in_attributeVariable3202);
                    streamAttributeName377=streamAttributeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, streamAttributeName377.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:425:51: attributeName
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeName_in_attributeVariable3204);
                    attributeName378=attributeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeName378.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "attributeVariable"


    public static class streamPositionAttributeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "streamPositionAttributeName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:427:1: streamPositionAttributeName : ( streamId '[' POSITIVE_INT_VAL ']' '.' id -> ^( ATTRIBUTE ^( streamId POSITIVE_INT_VAL ) id ) | streamId '[' 'last' ']' '.' id -> ^( ATTRIBUTE ^( streamId LAST ) id ) );
    public final SiddhiQLGrammarParser.streamPositionAttributeName_return streamPositionAttributeName() throws RecognitionException {
        SiddhiQLGrammarParser.streamPositionAttributeName_return retval = new SiddhiQLGrammarParser.streamPositionAttributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal380=null;
        Token POSITIVE_INT_VAL381=null;
        Token char_literal382=null;
        Token char_literal383=null;
        Token char_literal386=null;
        Token string_literal387=null;
        Token char_literal388=null;
        Token char_literal389=null;
        SiddhiQLGrammarParser.streamId_return streamId379 =null;

        SiddhiQLGrammarParser.id_return id384 =null;

        SiddhiQLGrammarParser.streamId_return streamId385 =null;

        SiddhiQLGrammarParser.id_return id390 =null;


        CommonTree char_literal380_tree=null;
        CommonTree POSITIVE_INT_VAL381_tree=null;
        CommonTree char_literal382_tree=null;
        CommonTree char_literal383_tree=null;
        CommonTree char_literal386_tree=null;
        CommonTree string_literal387_tree=null;
        CommonTree char_literal388_tree=null;
        CommonTree char_literal389_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_118=new RewriteRuleTokenStream(adaptor,"token 118");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_streamId=new RewriteRuleSubtreeStream(adaptor,"rule streamId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:428:2: ( streamId '[' POSITIVE_INT_VAL ']' '.' id -> ^( ATTRIBUTE ^( streamId POSITIVE_INT_VAL ) id ) | streamId '[' 'last' ']' '.' id -> ^( ATTRIBUTE ^( streamId LAST ) id ) )
            int alt102=2;
            switch ( input.LA(1) ) {
            case ID:
            case ID_QUOTES:
                {
                switch ( input.LA(2) ) {
                case 88:
                    {
                    switch ( input.LA(3) ) {
                    case POSITIVE_INT_VAL:
                        {
                        alt102=1;
                        }
                        break;
                    case 118:
                        {
                        alt102=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 102, 2, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }

            switch (alt102) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:428:3: streamId '[' POSITIVE_INT_VAL ']' '.' id
                    {
                    pushFollow(FOLLOW_streamId_in_streamPositionAttributeName3212);
                    streamId379=streamId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_streamId.add(streamId379.getTree());

                    char_literal380=(Token)match(input,88,FOLLOW_88_in_streamPositionAttributeName3214); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_88.add(char_literal380);


                    POSITIVE_INT_VAL381=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_streamPositionAttributeName3215); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL381);


                    char_literal382=(Token)match(input,89,FOLLOW_89_in_streamPositionAttributeName3216); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_89.add(char_literal382);


                    char_literal383=(Token)match(input,77,FOLLOW_77_in_streamPositionAttributeName3217); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_77.add(char_literal383);


                    pushFollow(FOLLOW_id_in_streamPositionAttributeName3219);
                    id384=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id384.getTree());

                    // AST REWRITE
                    // elements: POSITIVE_INT_VAL, id, streamId
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 428:41: -> ^( ATTRIBUTE ^( streamId POSITIVE_INT_VAL ) id )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:428:45: ^( ATTRIBUTE ^( streamId POSITIVE_INT_VAL ) id )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:428:58: ^( streamId POSITIVE_INT_VAL )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_streamId.nextNode(), root_2);

                        adaptor.addChild(root_2, 
                        stream_POSITIVE_INT_VAL.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:429:3: streamId '[' 'last' ']' '.' id
                    {
                    pushFollow(FOLLOW_streamId_in_streamPositionAttributeName3239);
                    streamId385=streamId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_streamId.add(streamId385.getTree());

                    char_literal386=(Token)match(input,88,FOLLOW_88_in_streamPositionAttributeName3241); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_88.add(char_literal386);


                    string_literal387=(Token)match(input,118,FOLLOW_118_in_streamPositionAttributeName3243); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_118.add(string_literal387);


                    char_literal388=(Token)match(input,89,FOLLOW_89_in_streamPositionAttributeName3245); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_89.add(char_literal388);


                    char_literal389=(Token)match(input,77,FOLLOW_77_in_streamPositionAttributeName3246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_77.add(char_literal389);


                    pushFollow(FOLLOW_id_in_streamPositionAttributeName3248);
                    id390=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id390.getTree());

                    // AST REWRITE
                    // elements: streamId, id
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 429:33: -> ^( ATTRIBUTE ^( streamId LAST ) id )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:429:37: ^( ATTRIBUTE ^( streamId LAST ) id )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:429:50: ^( streamId LAST )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_streamId.nextNode(), root_2);

                        adaptor.addChild(root_2, 
                        (CommonTree)adaptor.create(LAST, "LAST")
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "streamPositionAttributeName"


    public static class streamAttributeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "streamAttributeName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:432:1: streamAttributeName : streamId '.' id -> ^( ATTRIBUTE streamId id ) ;
    public final SiddhiQLGrammarParser.streamAttributeName_return streamAttributeName() throws RecognitionException {
        SiddhiQLGrammarParser.streamAttributeName_return retval = new SiddhiQLGrammarParser.streamAttributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal392=null;
        SiddhiQLGrammarParser.streamId_return streamId391 =null;

        SiddhiQLGrammarParser.id_return id393 =null;


        CommonTree char_literal392_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_streamId=new RewriteRuleSubtreeStream(adaptor,"rule streamId");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:433:2: ( streamId '.' id -> ^( ATTRIBUTE streamId id ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:433:4: streamId '.' id
            {
            pushFollow(FOLLOW_streamId_in_streamAttributeName3275);
            streamId391=streamId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_streamId.add(streamId391.getTree());

            char_literal392=(Token)match(input,77,FOLLOW_77_in_streamAttributeName3277); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal392);


            pushFollow(FOLLOW_id_in_streamAttributeName3279);
            id393=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id393.getTree());

            // AST REWRITE
            // elements: streamId, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 433:21: -> ^( ATTRIBUTE streamId id )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:433:25: ^( ATTRIBUTE streamId id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_streamId.nextTree());

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "streamAttributeName"


    public static class attributeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:436:1: attributeName : id -> ^( ATTRIBUTE id ) ;
    public final SiddhiQLGrammarParser.attributeName_return attributeName() throws RecognitionException {
        SiddhiQLGrammarParser.attributeName_return retval = new SiddhiQLGrammarParser.attributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id394 =null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:437:2: ( id -> ^( ATTRIBUTE id ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:437:4: id
            {
            pushFollow(FOLLOW_id_in_attributeName3303);
            id394=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id394.getTree());

            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 437:8: -> ^( ATTRIBUTE id )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:437:12: ^( ATTRIBUTE id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "attributeName"


    public static class join_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:440:1: join : ( 'left' 'outer' 'join' -> ^( 'join' ^( 'outer' 'left' ) ) | 'right' 'outer' 'join' -> ^( 'join' ^( 'outer' 'right' ) ) | 'full' 'outer' 'join' -> ^( 'join' ^( 'outer' 'full' ) ) | 'outer' 'join' -> ^( 'join' ^( 'outer' 'full' ) ) | 'inner' 'join' -> ^( 'join' 'inner' ) | 'join' -> ^( 'join' 'inner' ) );
    public final SiddhiQLGrammarParser.join_return join() throws RecognitionException {
        SiddhiQLGrammarParser.join_return retval = new SiddhiQLGrammarParser.join_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal395=null;
        Token string_literal396=null;
        Token string_literal397=null;
        Token string_literal398=null;
        Token string_literal399=null;
        Token string_literal400=null;
        Token string_literal401=null;
        Token string_literal402=null;
        Token string_literal403=null;
        Token string_literal404=null;
        Token string_literal405=null;
        Token string_literal406=null;
        Token string_literal407=null;
        Token string_literal408=null;

        CommonTree string_literal395_tree=null;
        CommonTree string_literal396_tree=null;
        CommonTree string_literal397_tree=null;
        CommonTree string_literal398_tree=null;
        CommonTree string_literal399_tree=null;
        CommonTree string_literal400_tree=null;
        CommonTree string_literal401_tree=null;
        CommonTree string_literal402_tree=null;
        CommonTree string_literal403_tree=null;
        CommonTree string_literal404_tree=null;
        CommonTree string_literal405_tree=null;
        CommonTree string_literal406_tree=null;
        CommonTree string_literal407_tree=null;
        CommonTree string_literal408_tree=null;
        RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
        RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_129=new RewriteRuleTokenStream(adaptor,"token 129");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:441:2: ( 'left' 'outer' 'join' -> ^( 'join' ^( 'outer' 'left' ) ) | 'right' 'outer' 'join' -> ^( 'join' ^( 'outer' 'right' ) ) | 'full' 'outer' 'join' -> ^( 'join' ^( 'outer' 'full' ) ) | 'outer' 'join' -> ^( 'join' ^( 'outer' 'full' ) ) | 'inner' 'join' -> ^( 'join' 'inner' ) | 'join' -> ^( 'join' 'inner' ) )
            int alt103=6;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt103=1;
                }
                break;
            case 129:
                {
                alt103=2;
                }
                break;
            case 108:
                {
                alt103=3;
                }
                break;
            case 124:
                {
                alt103=4;
                }
                break;
            case 112:
                {
                alt103=5;
                }
                break;
            case 117:
                {
                alt103=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }

            switch (alt103) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:441:4: 'left' 'outer' 'join'
                    {
                    string_literal395=(Token)match(input,119,FOLLOW_119_in_join3325); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_119.add(string_literal395);


                    string_literal396=(Token)match(input,124,FOLLOW_124_in_join3326); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(string_literal396);


                    string_literal397=(Token)match(input,117,FOLLOW_117_in_join3328); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_117.add(string_literal397);


                    // AST REWRITE
                    // elements: 117, 124, 119
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 441:25: -> ^( 'join' ^( 'outer' 'left' ) )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:441:29: ^( 'join' ^( 'outer' 'left' ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_117.nextNode()
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:441:38: ^( 'outer' 'left' )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        stream_124.nextNode()
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_119.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:442:4: 'right' 'outer' 'join'
                    {
                    string_literal398=(Token)match(input,129,FOLLOW_129_in_join3346); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_129.add(string_literal398);


                    string_literal399=(Token)match(input,124,FOLLOW_124_in_join3348); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(string_literal399);


                    string_literal400=(Token)match(input,117,FOLLOW_117_in_join3350); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_117.add(string_literal400);


                    // AST REWRITE
                    // elements: 124, 117, 129
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 442:27: -> ^( 'join' ^( 'outer' 'right' ) )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:442:30: ^( 'join' ^( 'outer' 'right' ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_117.nextNode()
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:442:39: ^( 'outer' 'right' )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        stream_124.nextNode()
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_129.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:443:4: 'full' 'outer' 'join'
                    {
                    string_literal401=(Token)match(input,108,FOLLOW_108_in_join3367); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_108.add(string_literal401);


                    string_literal402=(Token)match(input,124,FOLLOW_124_in_join3368); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(string_literal402);


                    string_literal403=(Token)match(input,117,FOLLOW_117_in_join3370); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_117.add(string_literal403);


                    // AST REWRITE
                    // elements: 124, 108, 117
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 443:25: -> ^( 'join' ^( 'outer' 'full' ) )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:443:28: ^( 'join' ^( 'outer' 'full' ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_117.nextNode()
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:443:37: ^( 'outer' 'full' )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        stream_124.nextNode()
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_108.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:444:4: 'outer' 'join'
                    {
                    string_literal404=(Token)match(input,124,FOLLOW_124_in_join3387); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(string_literal404);


                    string_literal405=(Token)match(input,117,FOLLOW_117_in_join3389); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_117.add(string_literal405);


                    // AST REWRITE
                    // elements: 117, 108, 124
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 444:20: -> ^( 'join' ^( 'outer' 'full' ) )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:444:23: ^( 'join' ^( 'outer' 'full' ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_117.nextNode()
                        , root_1);

                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:444:32: ^( 'outer' 'full' )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        stream_124.nextNode()
                        , root_2);

                        adaptor.addChild(root_2, 
                        (CommonTree)adaptor.create(108, "108")
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:445:4: 'inner' 'join'
                    {
                    string_literal406=(Token)match(input,112,FOLLOW_112_in_join3407); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_112.add(string_literal406);


                    string_literal407=(Token)match(input,117,FOLLOW_117_in_join3409); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_117.add(string_literal407);


                    // AST REWRITE
                    // elements: 117, 112
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 445:20: -> ^( 'join' 'inner' )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:445:23: ^( 'join' 'inner' )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_117.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_112.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:446:4: 'join'
                    {
                    string_literal408=(Token)match(input,117,FOLLOW_117_in_join3423); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_117.add(string_literal408);


                    // AST REWRITE
                    // elements: 112, 117
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 446:11: -> ^( 'join' 'inner' )
                    {
                        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:446:14: ^( 'join' 'inner' )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_117.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        (CommonTree)adaptor.create(112, "112")
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join"


    public static class window_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "window"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:449:1: window : 'window' ;
    public final SiddhiQLGrammarParser.window_return window() throws RecognitionException {
        SiddhiQLGrammarParser.window_return retval = new SiddhiQLGrammarParser.window_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal409=null;

        CommonTree string_literal409_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:450:5: ( 'window' )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:450:7: 'window'
            {
            root_0 = (CommonTree)adaptor.nil();


            string_literal409=(Token)match(input,138,FOLLOW_138_in_window3445); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal409_tree = 
            (CommonTree)adaptor.create(string_literal409)
            ;
            adaptor.addChild(root_0, string_literal409_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "window"


    public static class transform_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "transform"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:453:1: transform : 'transform' ;
    public final SiddhiQLGrammarParser.transform_return transform() throws RecognitionException {
        SiddhiQLGrammarParser.transform_return retval = new SiddhiQLGrammarParser.transform_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal410=null;

        CommonTree string_literal410_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:454:5: ( 'transform' )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:454:7: 'transform'
            {
            root_0 = (CommonTree)adaptor.nil();


            string_literal410=(Token)match(input,135,FOLLOW_135_in_transform3462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal410_tree = 
            (CommonTree)adaptor.create(string_literal410)
            ;
            adaptor.addChild(root_0, string_literal410_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "transform"


    public static class compareOperation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "compareOperation"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:457:1: compareOperation : ( '==' | '!=' | '<=' | '>=' | '<' | '>' | 'contains' | 'instanceof' );
    public final SiddhiQLGrammarParser.compareOperation_return compareOperation() throws RecognitionException {
        SiddhiQLGrammarParser.compareOperation_return retval = new SiddhiQLGrammarParser.compareOperation_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set411=null;

        CommonTree set411_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:458:2: ( '==' | '!=' | '<=' | '>=' | '<' | '>' | 'contains' | 'instanceof' )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set411=(Token)input.LT(1);

            if ( input.LA(1)==68||(input.LA(1) >= 81 && input.LA(1) <= 82)||(input.LA(1) >= 84 && input.LA(1) <= 86)||input.LA(1)==96||input.LA(1)==114 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set411)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "compareOperation"


    public static class id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "id"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:461:1: id : ( ID | ID_QUOTES );
    public final SiddhiQLGrammarParser.id_return id() throws RecognitionException {
        SiddhiQLGrammarParser.id_return retval = new SiddhiQLGrammarParser.id_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set412=null;

        CommonTree set412_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:461:3: ( ID | ID_QUOTES )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set412=(Token)input.LT(1);

            if ( (input.LA(1) >= ID && input.LA(1) <= ID_QUOTES) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set412)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "id"


    public static class timeExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "timeExpr"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:463:1: timeExpr : ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? -> ^( TIME_EXP ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? ) ;
    public final SiddhiQLGrammarParser.timeExpr_return timeExpr() throws RecognitionException {
        SiddhiQLGrammarParser.timeExpr_return retval = new SiddhiQLGrammarParser.timeExpr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.yearValue_return yearValue413 =null;

        SiddhiQLGrammarParser.monthValue_return monthValue414 =null;

        SiddhiQLGrammarParser.weekValue_return weekValue415 =null;

        SiddhiQLGrammarParser.dayValue_return dayValue416 =null;

        SiddhiQLGrammarParser.hourValue_return hourValue417 =null;

        SiddhiQLGrammarParser.minuteValue_return minuteValue418 =null;

        SiddhiQLGrammarParser.secondValue_return secondValue419 =null;

        SiddhiQLGrammarParser.milliSecondValue_return milliSecondValue420 =null;


        RewriteRuleSubtreeStream stream_monthValue=new RewriteRuleSubtreeStream(adaptor,"rule monthValue");
        RewriteRuleSubtreeStream stream_minuteValue=new RewriteRuleSubtreeStream(adaptor,"rule minuteValue");
        RewriteRuleSubtreeStream stream_weekValue=new RewriteRuleSubtreeStream(adaptor,"rule weekValue");
        RewriteRuleSubtreeStream stream_dayValue=new RewriteRuleSubtreeStream(adaptor,"rule dayValue");
        RewriteRuleSubtreeStream stream_yearValue=new RewriteRuleSubtreeStream(adaptor,"rule yearValue");
        RewriteRuleSubtreeStream stream_milliSecondValue=new RewriteRuleSubtreeStream(adaptor,"rule milliSecondValue");
        RewriteRuleSubtreeStream stream_secondValue=new RewriteRuleSubtreeStream(adaptor,"rule secondValue");
        RewriteRuleSubtreeStream stream_hourValue=new RewriteRuleSubtreeStream(adaptor,"rule hourValue");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:5: ( ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? -> ^( TIME_EXP ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:7: ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )?
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:7: ( yearValue )?
            int alt104=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    switch ( input.LA(2) ) {
                        case ID:
                            {
                            int LA104_3 = input.LA(3);

                            if ( (synpred154_SiddhiQLGrammar()) ) {
                                alt104=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt104) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:8: yearValue
                    {
                    pushFollow(FOLLOW_yearValue_in_timeExpr3522);
                    yearValue413=yearValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_yearValue.add(yearValue413.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:20: ( monthValue )?
            int alt105=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    switch ( input.LA(2) ) {
                        case ID:
                            {
                            int LA105_3 = input.LA(3);

                            if ( (synpred155_SiddhiQLGrammar()) ) {
                                alt105=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt105) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:21: monthValue
                    {
                    pushFollow(FOLLOW_monthValue_in_timeExpr3527);
                    monthValue414=monthValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_monthValue.add(monthValue414.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:34: ( weekValue )?
            int alt106=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    switch ( input.LA(2) ) {
                        case ID:
                            {
                            int LA106_3 = input.LA(3);

                            if ( (synpred156_SiddhiQLGrammar()) ) {
                                alt106=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt106) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:35: weekValue
                    {
                    pushFollow(FOLLOW_weekValue_in_timeExpr3532);
                    weekValue415=weekValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_weekValue.add(weekValue415.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:47: ( dayValue )?
            int alt107=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    switch ( input.LA(2) ) {
                        case ID:
                            {
                            int LA107_3 = input.LA(3);

                            if ( (synpred157_SiddhiQLGrammar()) ) {
                                alt107=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt107) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:48: dayValue
                    {
                    pushFollow(FOLLOW_dayValue_in_timeExpr3537);
                    dayValue416=dayValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_dayValue.add(dayValue416.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:59: ( hourValue )?
            int alt108=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    switch ( input.LA(2) ) {
                        case ID:
                            {
                            int LA108_3 = input.LA(3);

                            if ( (synpred158_SiddhiQLGrammar()) ) {
                                alt108=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt108) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:60: hourValue
                    {
                    pushFollow(FOLLOW_hourValue_in_timeExpr3542);
                    hourValue417=hourValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_hourValue.add(hourValue417.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:72: ( minuteValue )?
            int alt109=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    switch ( input.LA(2) ) {
                        case ID:
                            {
                            int LA109_3 = input.LA(3);

                            if ( (synpred159_SiddhiQLGrammar()) ) {
                                alt109=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt109) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:73: minuteValue
                    {
                    pushFollow(FOLLOW_minuteValue_in_timeExpr3547);
                    minuteValue418=minuteValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_minuteValue.add(minuteValue418.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:87: ( secondValue )?
            int alt110=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    switch ( input.LA(2) ) {
                        case ID:
                            {
                            int LA110_3 = input.LA(3);

                            if ( (synpred160_SiddhiQLGrammar()) ) {
                                alt110=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt110) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:88: secondValue
                    {
                    pushFollow(FOLLOW_secondValue_in_timeExpr3552);
                    secondValue419=secondValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_secondValue.add(secondValue419.getTree());

                    }
                    break;

            }


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:103: ( milliSecondValue )?
            int alt111=2;
            switch ( input.LA(1) ) {
                case POSITIVE_INT_VAL:
                    {
                    alt111=1;
                    }
                    break;
            }

            switch (alt111) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:104: milliSecondValue
                    {
                    pushFollow(FOLLOW_milliSecondValue_in_timeExpr3558);
                    milliSecondValue420=milliSecondValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_milliSecondValue.add(milliSecondValue420.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: hourValue, secondValue, dayValue, milliSecondValue, weekValue, minuteValue, monthValue, yearValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 465:2: -> ^( TIME_EXP ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:5: ^( TIME_EXP ( yearValue )? ( monthValue )? ( weekValue )? ( dayValue )? ( hourValue )? ( minuteValue )? ( secondValue )? ( milliSecondValue )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TIME_EXP, "TIME_EXP")
                , root_1);

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:16: ( yearValue )?
                if ( stream_yearValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_yearValue.nextTree());

                }
                stream_yearValue.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:27: ( monthValue )?
                if ( stream_monthValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_monthValue.nextTree());

                }
                stream_monthValue.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:39: ( weekValue )?
                if ( stream_weekValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_weekValue.nextTree());

                }
                stream_weekValue.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:50: ( dayValue )?
                if ( stream_dayValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_dayValue.nextTree());

                }
                stream_dayValue.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:60: ( hourValue )?
                if ( stream_hourValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_hourValue.nextTree());

                }
                stream_hourValue.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:71: ( minuteValue )?
                if ( stream_minuteValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_minuteValue.nextTree());

                }
                stream_minuteValue.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:84: ( secondValue )?
                if ( stream_secondValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_secondValue.nextTree());

                }
                stream_secondValue.reset();

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:465:97: ( milliSecondValue )?
                if ( stream_milliSecondValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_milliSecondValue.nextTree());

                }
                stream_milliSecondValue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timeExpr"


    public static class yearValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "yearValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:468:1: yearValue : POSITIVE_INT_VAL ( years | year ) -> ^( YEAR POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.yearValue_return yearValue() throws RecognitionException {
        SiddhiQLGrammarParser.yearValue_return retval = new SiddhiQLGrammarParser.yearValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL421=null;
        SiddhiQLGrammarParser.years_return years422 =null;

        SiddhiQLGrammarParser.year_return year423 =null;


        CommonTree POSITIVE_INT_VAL421_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_year=new RewriteRuleSubtreeStream(adaptor,"rule year");
        RewriteRuleSubtreeStream stream_years=new RewriteRuleSubtreeStream(adaptor,"rule years");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:2: ( POSITIVE_INT_VAL ( years | year ) -> ^( YEAR POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:4: POSITIVE_INT_VAL ( years | year )
            {
            POSITIVE_INT_VAL421=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_yearValue3604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL421);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:21: ( years | year )
            int alt112=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA112_1 = input.LA(2);

                if ( (((synpred162_SiddhiQLGrammar()&&synpred162_SiddhiQLGrammar())&&(input.LT(1).getText().equals("years")))) ) {
                    alt112=1;
                }
                else if ( ((input.LT(1).getText().equals("year"))) ) {
                    alt112=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 112, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;

            }

            switch (alt112) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:23: years
                    {
                    pushFollow(FOLLOW_years_in_yearValue3608);
                    years422=years();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_years.add(years422.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:31: year
                    {
                    pushFollow(FOLLOW_year_in_yearValue3612);
                    year423=year();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_year.add(year423.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 469:38: -> ^( YEAR POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:42: ^( YEAR POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(YEAR, "YEAR")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "yearValue"


    public static class monthValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "monthValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:472:1: monthValue : POSITIVE_INT_VAL ( months | month ) -> ^( MONTH POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.monthValue_return monthValue() throws RecognitionException {
        SiddhiQLGrammarParser.monthValue_return retval = new SiddhiQLGrammarParser.monthValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL424=null;
        SiddhiQLGrammarParser.months_return months425 =null;

        SiddhiQLGrammarParser.month_return month426 =null;


        CommonTree POSITIVE_INT_VAL424_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_months=new RewriteRuleSubtreeStream(adaptor,"rule months");
        RewriteRuleSubtreeStream stream_month=new RewriteRuleSubtreeStream(adaptor,"rule month");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:2: ( POSITIVE_INT_VAL ( months | month ) -> ^( MONTH POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:4: POSITIVE_INT_VAL ( months | month )
            {
            POSITIVE_INT_VAL424=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_monthValue3634); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL424);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:21: ( months | month )
            int alt113=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA113_1 = input.LA(2);

                if ( ((((input.LT(1).getText().equals("months"))&&(input.LT(1).getText().equals("months")))&&synpred163_SiddhiQLGrammar())) ) {
                    alt113=1;
                }
                else if ( ((input.LT(1).getText().equals("month"))) ) {
                    alt113=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 113, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }

            switch (alt113) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:23: months
                    {
                    pushFollow(FOLLOW_months_in_monthValue3638);
                    months425=months();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_months.add(months425.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:32: month
                    {
                    pushFollow(FOLLOW_month_in_monthValue3642);
                    month426=month();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_month.add(month426.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 473:40: -> ^( MONTH POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:45: ^( MONTH POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MONTH, "MONTH")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "monthValue"


    public static class weekValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "weekValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:476:1: weekValue : POSITIVE_INT_VAL ( weeks | week ) -> ^( WEEK POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.weekValue_return weekValue() throws RecognitionException {
        SiddhiQLGrammarParser.weekValue_return retval = new SiddhiQLGrammarParser.weekValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL427=null;
        SiddhiQLGrammarParser.weeks_return weeks428 =null;

        SiddhiQLGrammarParser.week_return week429 =null;


        CommonTree POSITIVE_INT_VAL427_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_weeks=new RewriteRuleSubtreeStream(adaptor,"rule weeks");
        RewriteRuleSubtreeStream stream_week=new RewriteRuleSubtreeStream(adaptor,"rule week");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:2: ( POSITIVE_INT_VAL ( weeks | week ) -> ^( WEEK POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:4: POSITIVE_INT_VAL ( weeks | week )
            {
            POSITIVE_INT_VAL427=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_weekValue3665); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL427);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:21: ( weeks | week )
            int alt114=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA114_1 = input.LA(2);

                if ( (((synpred164_SiddhiQLGrammar()&&synpred164_SiddhiQLGrammar())&&(input.LT(1).getText().equals("weeks")))) ) {
                    alt114=1;
                }
                else if ( ((input.LT(1).getText().equals("week"))) ) {
                    alt114=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 114, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;

            }

            switch (alt114) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:23: weeks
                    {
                    pushFollow(FOLLOW_weeks_in_weekValue3669);
                    weeks428=weeks();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_weeks.add(weeks428.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:31: week
                    {
                    pushFollow(FOLLOW_week_in_weekValue3673);
                    week429=week();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_week.add(week429.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 477:37: -> ^( WEEK POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:42: ^( WEEK POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(WEEK, "WEEK")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "weekValue"


    public static class dayValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dayValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:480:1: dayValue : POSITIVE_INT_VAL ( days | day ) -> ^( DAY POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.dayValue_return dayValue() throws RecognitionException {
        SiddhiQLGrammarParser.dayValue_return retval = new SiddhiQLGrammarParser.dayValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL430=null;
        SiddhiQLGrammarParser.days_return days431 =null;

        SiddhiQLGrammarParser.day_return day432 =null;


        CommonTree POSITIVE_INT_VAL430_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_days=new RewriteRuleSubtreeStream(adaptor,"rule days");
        RewriteRuleSubtreeStream stream_day=new RewriteRuleSubtreeStream(adaptor,"rule day");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:2: ( POSITIVE_INT_VAL ( days | day ) -> ^( DAY POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:4: POSITIVE_INT_VAL ( days | day )
            {
            POSITIVE_INT_VAL430=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_dayValue3695); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL430);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:21: ( days | day )
            int alt115=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA115_1 = input.LA(2);

                if ( (((synpred165_SiddhiQLGrammar()&&synpred165_SiddhiQLGrammar())&&(input.LT(1).getText().equals("days")))) ) {
                    alt115=1;
                }
                else if ( ((input.LT(1).getText().equals("day"))) ) {
                    alt115=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 115, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;

            }

            switch (alt115) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:23: days
                    {
                    pushFollow(FOLLOW_days_in_dayValue3699);
                    days431=days();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_days.add(days431.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:30: day
                    {
                    pushFollow(FOLLOW_day_in_dayValue3703);
                    day432=day();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_day.add(day432.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 481:36: -> ^( DAY POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:41: ^( DAY POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DAY, "DAY")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dayValue"


    public static class hourValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hourValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:484:1: hourValue : POSITIVE_INT_VAL ( hours | hour ) -> ^( HOUR POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.hourValue_return hourValue() throws RecognitionException {
        SiddhiQLGrammarParser.hourValue_return retval = new SiddhiQLGrammarParser.hourValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL433=null;
        SiddhiQLGrammarParser.hours_return hours434 =null;

        SiddhiQLGrammarParser.hour_return hour435 =null;


        CommonTree POSITIVE_INT_VAL433_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_hours=new RewriteRuleSubtreeStream(adaptor,"rule hours");
        RewriteRuleSubtreeStream stream_hour=new RewriteRuleSubtreeStream(adaptor,"rule hour");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:2: ( POSITIVE_INT_VAL ( hours | hour ) -> ^( HOUR POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:4: POSITIVE_INT_VAL ( hours | hour )
            {
            POSITIVE_INT_VAL433=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_hourValue3726); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL433);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:21: ( hours | hour )
            int alt116=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA116_1 = input.LA(2);

                if ( (((synpred166_SiddhiQLGrammar()&&synpred166_SiddhiQLGrammar())&&(input.LT(1).getText().equals("hours")))) ) {
                    alt116=1;
                }
                else if ( ((input.LT(1).getText().equals("hour"))) ) {
                    alt116=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 116, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }

            switch (alt116) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:23: hours
                    {
                    pushFollow(FOLLOW_hours_in_hourValue3730);
                    hours434=hours();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_hours.add(hours434.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:33: hour
                    {
                    pushFollow(FOLLOW_hour_in_hourValue3736);
                    hour435=hour();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_hour.add(hour435.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 485:40: -> ^( HOUR POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:45: ^( HOUR POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HOUR, "HOUR")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "hourValue"


    public static class minuteValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "minuteValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:488:1: minuteValue : POSITIVE_INT_VAL ( minutes | min | minute ) -> ^( MIN POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.minuteValue_return minuteValue() throws RecognitionException {
        SiddhiQLGrammarParser.minuteValue_return retval = new SiddhiQLGrammarParser.minuteValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL436=null;
        SiddhiQLGrammarParser.minutes_return minutes437 =null;

        SiddhiQLGrammarParser.min_return min438 =null;

        SiddhiQLGrammarParser.minute_return minute439 =null;


        CommonTree POSITIVE_INT_VAL436_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_min=new RewriteRuleSubtreeStream(adaptor,"rule min");
        RewriteRuleSubtreeStream stream_minute=new RewriteRuleSubtreeStream(adaptor,"rule minute");
        RewriteRuleSubtreeStream stream_minutes=new RewriteRuleSubtreeStream(adaptor,"rule minutes");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:2: ( POSITIVE_INT_VAL ( minutes | min | minute ) -> ^( MIN POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:4: POSITIVE_INT_VAL ( minutes | min | minute )
            {
            POSITIVE_INT_VAL436=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_minuteValue3759); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL436);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:21: ( minutes | min | minute )
            int alt117=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA117_1 = input.LA(2);

                if ( ((((input.LT(1).getText().equals("minutes"))&&(input.LT(1).getText().equals("minutes")))&&synpred167_SiddhiQLGrammar())) ) {
                    alt117=1;
                }
                else if ( ((((input.LT(1).getText().equals("min"))&&(input.LT(1).getText().equals("min")))&&synpred168_SiddhiQLGrammar())) ) {
                    alt117=2;
                }
                else if ( ((input.LT(1).getText().equals("minute"))) ) {
                    alt117=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 117, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }

            switch (alt117) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:23: minutes
                    {
                    pushFollow(FOLLOW_minutes_in_minuteValue3763);
                    minutes437=minutes();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_minutes.add(minutes437.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:34: min
                    {
                    pushFollow(FOLLOW_min_in_minuteValue3768);
                    min438=min();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_min.add(min438.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:41: minute
                    {
                    pushFollow(FOLLOW_minute_in_minuteValue3773);
                    minute439=minute();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_minute.add(minute439.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 489:51: -> ^( MIN POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:56: ^( MIN POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MIN, "MIN")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "minuteValue"


    public static class secondValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "secondValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:492:1: secondValue : POSITIVE_INT_VAL ( seconds | second | sec ) -> ^( SEC POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.secondValue_return secondValue() throws RecognitionException {
        SiddhiQLGrammarParser.secondValue_return retval = new SiddhiQLGrammarParser.secondValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL440=null;
        SiddhiQLGrammarParser.seconds_return seconds441 =null;

        SiddhiQLGrammarParser.second_return second442 =null;

        SiddhiQLGrammarParser.sec_return sec443 =null;


        CommonTree POSITIVE_INT_VAL440_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_second=new RewriteRuleSubtreeStream(adaptor,"rule second");
        RewriteRuleSubtreeStream stream_seconds=new RewriteRuleSubtreeStream(adaptor,"rule seconds");
        RewriteRuleSubtreeStream stream_sec=new RewriteRuleSubtreeStream(adaptor,"rule sec");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:2: ( POSITIVE_INT_VAL ( seconds | second | sec ) -> ^( SEC POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:4: POSITIVE_INT_VAL ( seconds | second | sec )
            {
            POSITIVE_INT_VAL440=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_secondValue3797); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL440);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:21: ( seconds | second | sec )
            int alt118=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA118_1 = input.LA(2);

                if ( ((((input.LT(1).getText().equals("seconds"))&&(input.LT(1).getText().equals("seconds")))&&synpred169_SiddhiQLGrammar())) ) {
                    alt118=1;
                }
                else if ( (((synpred170_SiddhiQLGrammar()&&synpred170_SiddhiQLGrammar())&&(input.LT(1).getText().equals("second")))) ) {
                    alt118=2;
                }
                else if ( ((input.LT(1).getText().equals("sec"))) ) {
                    alt118=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;

            }

            switch (alt118) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:22: seconds
                    {
                    pushFollow(FOLLOW_seconds_in_secondValue3800);
                    seconds441=seconds();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_seconds.add(seconds441.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:32: second
                    {
                    pushFollow(FOLLOW_second_in_secondValue3804);
                    second442=second();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_second.add(second442.getTree());

                    }
                    break;
                case 3 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:41: sec
                    {
                    pushFollow(FOLLOW_sec_in_secondValue3808);
                    sec443=sec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_sec.add(sec443.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 493:49: -> ^( SEC POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:54: ^( SEC POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SEC, "SEC")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "secondValue"


    public static class milliSecondValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "milliSecondValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:496:1: milliSecondValue : POSITIVE_INT_VAL ( milliseconds | millisecond ) -> ^( MILLI_SEC POSITIVE_INT_VAL ) ;
    public final SiddhiQLGrammarParser.milliSecondValue_return milliSecondValue() throws RecognitionException {
        SiddhiQLGrammarParser.milliSecondValue_return retval = new SiddhiQLGrammarParser.milliSecondValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token POSITIVE_INT_VAL444=null;
        SiddhiQLGrammarParser.milliseconds_return milliseconds445 =null;

        SiddhiQLGrammarParser.millisecond_return millisecond446 =null;


        CommonTree POSITIVE_INT_VAL444_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleSubtreeStream stream_millisecond=new RewriteRuleSubtreeStream(adaptor,"rule millisecond");
        RewriteRuleSubtreeStream stream_milliseconds=new RewriteRuleSubtreeStream(adaptor,"rule milliseconds");
        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:2: ( POSITIVE_INT_VAL ( milliseconds | millisecond ) -> ^( MILLI_SEC POSITIVE_INT_VAL ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:4: POSITIVE_INT_VAL ( milliseconds | millisecond )
            {
            POSITIVE_INT_VAL444=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_milliSecondValue3833); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL444);


            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:21: ( milliseconds | millisecond )
            int alt119=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA119_1 = input.LA(2);

                if ( ((((input.LT(1).getText().equals("milliseconds"))&&(input.LT(1).getText().equals("milliseconds")))&&synpred171_SiddhiQLGrammar())) ) {
                    alt119=1;
                }
                else if ( ((input.LT(1).getText().equals("millisecond"))) ) {
                    alt119=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 119, 1, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;

            }

            switch (alt119) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:23: milliseconds
                    {
                    pushFollow(FOLLOW_milliseconds_in_milliSecondValue3837);
                    milliseconds445=milliseconds();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_milliseconds.add(milliseconds445.getTree());

                    }
                    break;
                case 2 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:39: millisecond
                    {
                    pushFollow(FOLLOW_millisecond_in_milliSecondValue3842);
                    millisecond446=millisecond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_millisecond.add(millisecond446.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 497:55: -> ^( MILLI_SEC POSITIVE_INT_VAL )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:60: ^( MILLI_SEC POSITIVE_INT_VAL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MILLI_SEC, "MILLI_SEC")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "milliSecondValue"


    public static class intVal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "intVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:500:1: intVal : ( '-' )? POSITIVE_INT_VAL -> ^( SIGNED_VAL POSITIVE_INT_VAL ( '-' )? ) ;
    public final SiddhiQLGrammarParser.intVal_return intVal() throws RecognitionException {
        SiddhiQLGrammarParser.intVal_return retval = new SiddhiQLGrammarParser.intVal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal447=null;
        Token POSITIVE_INT_VAL448=null;

        CommonTree char_literal447_tree=null;
        CommonTree POSITIVE_INT_VAL448_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_INT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_INT_VAL");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:500:7: ( ( '-' )? POSITIVE_INT_VAL -> ^( SIGNED_VAL POSITIVE_INT_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:500:9: ( '-' )? POSITIVE_INT_VAL
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:500:9: ( '-' )?
            int alt120=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt120=1;
                    }
                    break;
            }

            switch (alt120) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:500:9: '-'
                    {
                    char_literal447=(Token)match(input,76,FOLLOW_76_in_intVal3865); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(char_literal447);


                    }
                    break;

            }


            POSITIVE_INT_VAL448=(Token)match(input,POSITIVE_INT_VAL,FOLLOW_POSITIVE_INT_VAL_in_intVal3868); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_INT_VAL.add(POSITIVE_INT_VAL448);


            // AST REWRITE
            // elements: 76, POSITIVE_INT_VAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 500:31: -> ^( SIGNED_VAL POSITIVE_INT_VAL ( '-' )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:500:34: ^( SIGNED_VAL POSITIVE_INT_VAL ( '-' )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SIGNED_VAL, "SIGNED_VAL")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_INT_VAL.nextNode()
                );

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:500:65: ( '-' )?
                if ( stream_76.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_76.nextNode()
                    );

                }
                stream_76.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "intVal"


    public static class longVal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "longVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:502:1: longVal : ( '-' )? POSITIVE_LONG_VAL -> ^( SIGNED_VAL POSITIVE_LONG_VAL ( '-' )? ) ;
    public final SiddhiQLGrammarParser.longVal_return longVal() throws RecognitionException {
        SiddhiQLGrammarParser.longVal_return retval = new SiddhiQLGrammarParser.longVal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal449=null;
        Token POSITIVE_LONG_VAL450=null;

        CommonTree char_literal449_tree=null;
        CommonTree POSITIVE_LONG_VAL450_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_LONG_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_LONG_VAL");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:502:8: ( ( '-' )? POSITIVE_LONG_VAL -> ^( SIGNED_VAL POSITIVE_LONG_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:502:10: ( '-' )? POSITIVE_LONG_VAL
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:502:10: ( '-' )?
            int alt121=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt121=1;
                    }
                    break;
            }

            switch (alt121) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:502:10: '-'
                    {
                    char_literal449=(Token)match(input,76,FOLLOW_76_in_longVal3887); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(char_literal449);


                    }
                    break;

            }


            POSITIVE_LONG_VAL450=(Token)match(input,POSITIVE_LONG_VAL,FOLLOW_POSITIVE_LONG_VAL_in_longVal3890); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_LONG_VAL.add(POSITIVE_LONG_VAL450);


            // AST REWRITE
            // elements: POSITIVE_LONG_VAL, 76
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 502:33: -> ^( SIGNED_VAL POSITIVE_LONG_VAL ( '-' )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:502:36: ^( SIGNED_VAL POSITIVE_LONG_VAL ( '-' )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SIGNED_VAL, "SIGNED_VAL")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_LONG_VAL.nextNode()
                );

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:502:68: ( '-' )?
                if ( stream_76.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_76.nextNode()
                    );

                }
                stream_76.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "longVal"


    public static class floatVal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "floatVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:504:1: floatVal : ( '-' )? POSITIVE_FLOAT_VAL -> ^( SIGNED_VAL POSITIVE_FLOAT_VAL ( '-' )? ) ;
    public final SiddhiQLGrammarParser.floatVal_return floatVal() throws RecognitionException {
        SiddhiQLGrammarParser.floatVal_return retval = new SiddhiQLGrammarParser.floatVal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal451=null;
        Token POSITIVE_FLOAT_VAL452=null;

        CommonTree char_literal451_tree=null;
        CommonTree POSITIVE_FLOAT_VAL452_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_FLOAT_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_FLOAT_VAL");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:504:9: ( ( '-' )? POSITIVE_FLOAT_VAL -> ^( SIGNED_VAL POSITIVE_FLOAT_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:504:11: ( '-' )? POSITIVE_FLOAT_VAL
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:504:11: ( '-' )?
            int alt122=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt122=1;
                    }
                    break;
            }

            switch (alt122) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:504:11: '-'
                    {
                    char_literal451=(Token)match(input,76,FOLLOW_76_in_floatVal3909); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(char_literal451);


                    }
                    break;

            }


            POSITIVE_FLOAT_VAL452=(Token)match(input,POSITIVE_FLOAT_VAL,FOLLOW_POSITIVE_FLOAT_VAL_in_floatVal3912); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_FLOAT_VAL.add(POSITIVE_FLOAT_VAL452);


            // AST REWRITE
            // elements: POSITIVE_FLOAT_VAL, 76
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 504:35: -> ^( SIGNED_VAL POSITIVE_FLOAT_VAL ( '-' )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:504:38: ^( SIGNED_VAL POSITIVE_FLOAT_VAL ( '-' )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SIGNED_VAL, "SIGNED_VAL")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_FLOAT_VAL.nextNode()
                );

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:504:71: ( '-' )?
                if ( stream_76.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_76.nextNode()
                    );

                }
                stream_76.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "floatVal"


    public static class doubleVal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "doubleVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:506:1: doubleVal : ( '-' )? POSITIVE_DOUBLE_VAL -> ^( SIGNED_VAL POSITIVE_DOUBLE_VAL ( '-' )? ) ;
    public final SiddhiQLGrammarParser.doubleVal_return doubleVal() throws RecognitionException {
        SiddhiQLGrammarParser.doubleVal_return retval = new SiddhiQLGrammarParser.doubleVal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal453=null;
        Token POSITIVE_DOUBLE_VAL454=null;

        CommonTree char_literal453_tree=null;
        CommonTree POSITIVE_DOUBLE_VAL454_tree=null;
        RewriteRuleTokenStream stream_POSITIVE_DOUBLE_VAL=new RewriteRuleTokenStream(adaptor,"token POSITIVE_DOUBLE_VAL");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:506:10: ( ( '-' )? POSITIVE_DOUBLE_VAL -> ^( SIGNED_VAL POSITIVE_DOUBLE_VAL ( '-' )? ) )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:506:12: ( '-' )? POSITIVE_DOUBLE_VAL
            {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:506:12: ( '-' )?
            int alt123=2;
            switch ( input.LA(1) ) {
                case 76:
                    {
                    alt123=1;
                    }
                    break;
            }

            switch (alt123) {
                case 1 :
                    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:506:12: '-'
                    {
                    char_literal453=(Token)match(input,76,FOLLOW_76_in_doubleVal3931); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(char_literal453);


                    }
                    break;

            }


            POSITIVE_DOUBLE_VAL454=(Token)match(input,POSITIVE_DOUBLE_VAL,FOLLOW_POSITIVE_DOUBLE_VAL_in_doubleVal3934); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POSITIVE_DOUBLE_VAL.add(POSITIVE_DOUBLE_VAL454);


            // AST REWRITE
            // elements: POSITIVE_DOUBLE_VAL, 76
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 506:37: -> ^( SIGNED_VAL POSITIVE_DOUBLE_VAL ( '-' )? )
            {
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:506:40: ^( SIGNED_VAL POSITIVE_DOUBLE_VAL ( '-' )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SIGNED_VAL, "SIGNED_VAL")
                , root_1);

                adaptor.addChild(root_1, 
                stream_POSITIVE_DOUBLE_VAL.nextNode()
                );

                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:506:74: ( '-' )?
                if ( stream_76.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_76.nextNode()
                    );

                }
                stream_76.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "doubleVal"


    public static class boolVal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:508:1: boolVal : BOOL_VAL ;
    public final SiddhiQLGrammarParser.boolVal_return boolVal() throws RecognitionException {
        SiddhiQLGrammarParser.boolVal_return retval = new SiddhiQLGrammarParser.boolVal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token BOOL_VAL455=null;

        CommonTree BOOL_VAL455_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:508:8: ( BOOL_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:508:10: BOOL_VAL
            {
            root_0 = (CommonTree)adaptor.nil();


            BOOL_VAL455=(Token)match(input,BOOL_VAL,FOLLOW_BOOL_VAL_in_boolVal3953); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BOOL_VAL455_tree = 
            (CommonTree)adaptor.create(BOOL_VAL455)
            ;
            adaptor.addChild(root_0, BOOL_VAL455_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "boolVal"


    public static class extensionId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "extensionId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:510:1: extensionId : id ;
    public final SiddhiQLGrammarParser.extensionId_return extensionId() throws RecognitionException {
        SiddhiQLGrammarParser.extensionId_return retval = new SiddhiQLGrammarParser.extensionId_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id456 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:510:12: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:510:14: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_extensionId3960);
            id456=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id456.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "extensionId"


    public static class functionId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionId"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:512:1: functionId : id ;
    public final SiddhiQLGrammarParser.functionId_return functionId() throws RecognitionException {
        SiddhiQLGrammarParser.functionId_return retval = new SiddhiQLGrammarParser.functionId_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id457 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:512:11: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:512:13: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_functionId3967);
            id457=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id457.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionId"


    public static class tableType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tableType"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:514:1: tableType : id ;
    public final SiddhiQLGrammarParser.tableType_return tableType() throws RecognitionException {
        SiddhiQLGrammarParser.tableType_return retval = new SiddhiQLGrammarParser.tableType_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id458 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:514:10: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:514:12: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_tableType3974);
            id458=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id458.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tableType"


    public static class databaseName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "databaseName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:516:1: databaseName : id ;
    public final SiddhiQLGrammarParser.databaseName_return databaseName() throws RecognitionException {
        SiddhiQLGrammarParser.databaseName_return retval = new SiddhiQLGrammarParser.databaseName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id459 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:516:13: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:516:15: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_databaseName3981);
            id459=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id459.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "databaseName"


    public static class tableName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tableName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:518:1: tableName : id ;
    public final SiddhiQLGrammarParser.tableName_return tableName() throws RecognitionException {
        SiddhiQLGrammarParser.tableName_return retval = new SiddhiQLGrammarParser.tableName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id460 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:518:10: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:518:12: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_tableName3988);
            id460=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id460.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tableName"


    public static class dataSourceName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dataSourceName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:520:1: dataSourceName : id ;
    public final SiddhiQLGrammarParser.dataSourceName_return dataSourceName() throws RecognitionException {
        SiddhiQLGrammarParser.dataSourceName_return retval = new SiddhiQLGrammarParser.dataSourceName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.id_return id461 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:520:16: ( id )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:520:18: id
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_id_in_dataSourceName3996);
            id461=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id461.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dataSourceName"


    public static class stringVal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stringVal"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:522:1: stringVal : STRING_VAL ;
    public final SiddhiQLGrammarParser.stringVal_return stringVal() throws RecognitionException {
        SiddhiQLGrammarParser.stringVal_return retval = new SiddhiQLGrammarParser.stringVal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token STRING_VAL462=null;

        CommonTree STRING_VAL462_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:522:10: ( STRING_VAL )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:522:12: STRING_VAL
            {
            root_0 = (CommonTree)adaptor.nil();


            STRING_VAL462=(Token)match(input,STRING_VAL,FOLLOW_STRING_VAL_in_stringVal4003); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING_VAL462_tree = 
            (CommonTree)adaptor.create(STRING_VAL462)
            ;
            adaptor.addChild(root_0, STRING_VAL462_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stringVal"


    public static class tableParamName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tableParamName"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:524:1: tableParamName : stringVal ;
    public final SiddhiQLGrammarParser.tableParamName_return tableParamName() throws RecognitionException {
        SiddhiQLGrammarParser.tableParamName_return retval = new SiddhiQLGrammarParser.tableParamName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.stringVal_return stringVal463 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:524:16: ( stringVal )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:524:18: stringVal
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_stringVal_in_tableParamName4011);
            stringVal463=stringVal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, stringVal463.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tableParamName"


    public static class tableParamValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tableParamValue"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:526:1: tableParamValue : stringVal ;
    public final SiddhiQLGrammarParser.tableParamValue_return tableParamValue() throws RecognitionException {
        SiddhiQLGrammarParser.tableParamValue_return retval = new SiddhiQLGrammarParser.tableParamValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SiddhiQLGrammarParser.stringVal_return stringVal464 =null;



        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:526:17: ( stringVal )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:526:19: stringVal
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_stringVal_in_tableParamValue4019);
            stringVal464=stringVal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, stringVal464.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tableParamValue"


    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:528:1: type : ( 'string' | 'int' | 'long' | 'float' | 'double' | 'bool' );
    public final SiddhiQLGrammarParser.type_return type() throws RecognitionException {
        SiddhiQLGrammarParser.type_return retval = new SiddhiQLGrammarParser.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set465=null;

        CommonTree set465_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:528:5: ( 'string' | 'int' | 'long' | 'float' | 'double' | 'bool' )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set465=(Token)input.LT(1);

            if ( input.LA(1)==94||input.LA(1)==100||input.LA(1)==105||input.LA(1)==115||input.LA(1)==120||input.LA(1)==133 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set465)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class years_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "years"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:547:1: years :{...}? ID ;
    public final SiddhiQLGrammarParser.years_return years() throws RecognitionException {
        SiddhiQLGrammarParser.years_return retval = new SiddhiQLGrammarParser.years_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID466=null;

        CommonTree ID466_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:547:7: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:547:10: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("years"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "years", "input.LT(1).getText().equals(\"years\")");
            }

            ID466=(Token)match(input,ID,FOLLOW_ID_in_years4227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID466_tree = 
            (CommonTree)adaptor.create(ID466)
            ;
            adaptor.addChild(root_0, ID466_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "years"


    public static class year_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "year"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:549:1: year :{...}? ID ;
    public final SiddhiQLGrammarParser.year_return year() throws RecognitionException {
        SiddhiQLGrammarParser.year_return retval = new SiddhiQLGrammarParser.year_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID467=null;

        CommonTree ID467_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:549:6: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:549:9: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("year"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "year", "input.LT(1).getText().equals(\"year\")");
            }

            ID467=(Token)match(input,ID,FOLLOW_ID_in_year4239); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID467_tree = 
            (CommonTree)adaptor.create(ID467)
            ;
            adaptor.addChild(root_0, ID467_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "year"


    public static class months_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "months"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:551:1: months :{...}? ID ;
    public final SiddhiQLGrammarParser.months_return months() throws RecognitionException {
        SiddhiQLGrammarParser.months_return retval = new SiddhiQLGrammarParser.months_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID468=null;

        CommonTree ID468_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:551:8: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:551:11: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("months"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "months", "input.LT(1).getText().equals(\"months\")");
            }

            ID468=(Token)match(input,ID,FOLLOW_ID_in_months4251); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID468_tree = 
            (CommonTree)adaptor.create(ID468)
            ;
            adaptor.addChild(root_0, ID468_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "months"


    public static class month_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "month"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:553:1: month :{...}? ID ;
    public final SiddhiQLGrammarParser.month_return month() throws RecognitionException {
        SiddhiQLGrammarParser.month_return retval = new SiddhiQLGrammarParser.month_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID469=null;

        CommonTree ID469_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:553:7: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:553:10: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("month"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "month", "input.LT(1).getText().equals(\"month\")");
            }

            ID469=(Token)match(input,ID,FOLLOW_ID_in_month4263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID469_tree = 
            (CommonTree)adaptor.create(ID469)
            ;
            adaptor.addChild(root_0, ID469_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "month"


    public static class weeks_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "weeks"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:555:1: weeks :{...}? ID ;
    public final SiddhiQLGrammarParser.weeks_return weeks() throws RecognitionException {
        SiddhiQLGrammarParser.weeks_return retval = new SiddhiQLGrammarParser.weeks_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID470=null;

        CommonTree ID470_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:555:7: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:555:10: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("weeks"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "weeks", "input.LT(1).getText().equals(\"weeks\")");
            }

            ID470=(Token)match(input,ID,FOLLOW_ID_in_weeks4275); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID470_tree = 
            (CommonTree)adaptor.create(ID470)
            ;
            adaptor.addChild(root_0, ID470_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "weeks"


    public static class week_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "week"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:557:1: week :{...}? ID ;
    public final SiddhiQLGrammarParser.week_return week() throws RecognitionException {
        SiddhiQLGrammarParser.week_return retval = new SiddhiQLGrammarParser.week_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID471=null;

        CommonTree ID471_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:557:6: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:557:9: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("week"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "week", "input.LT(1).getText().equals(\"week\")");
            }

            ID471=(Token)match(input,ID,FOLLOW_ID_in_week4287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID471_tree = 
            (CommonTree)adaptor.create(ID471)
            ;
            adaptor.addChild(root_0, ID471_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "week"


    public static class days_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "days"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:559:1: days :{...}? ID ;
    public final SiddhiQLGrammarParser.days_return days() throws RecognitionException {
        SiddhiQLGrammarParser.days_return retval = new SiddhiQLGrammarParser.days_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID472=null;

        CommonTree ID472_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:559:6: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:559:9: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("days"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "days", "input.LT(1).getText().equals(\"days\")");
            }

            ID472=(Token)match(input,ID,FOLLOW_ID_in_days4299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID472_tree = 
            (CommonTree)adaptor.create(ID472)
            ;
            adaptor.addChild(root_0, ID472_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "days"


    public static class day_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "day"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:561:1: day :{...}? ID ;
    public final SiddhiQLGrammarParser.day_return day() throws RecognitionException {
        SiddhiQLGrammarParser.day_return retval = new SiddhiQLGrammarParser.day_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID473=null;

        CommonTree ID473_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:561:5: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:561:8: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("day"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "day", "input.LT(1).getText().equals(\"day\")");
            }

            ID473=(Token)match(input,ID,FOLLOW_ID_in_day4311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID473_tree = 
            (CommonTree)adaptor.create(ID473)
            ;
            adaptor.addChild(root_0, ID473_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "day"


    public static class hours_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hours"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:563:1: hours :{...}? ID ;
    public final SiddhiQLGrammarParser.hours_return hours() throws RecognitionException {
        SiddhiQLGrammarParser.hours_return retval = new SiddhiQLGrammarParser.hours_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID474=null;

        CommonTree ID474_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:563:7: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:563:10: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("hours"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "hours", "input.LT(1).getText().equals(\"hours\")");
            }

            ID474=(Token)match(input,ID,FOLLOW_ID_in_hours4323); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID474_tree = 
            (CommonTree)adaptor.create(ID474)
            ;
            adaptor.addChild(root_0, ID474_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "hours"


    public static class hour_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hour"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:565:1: hour :{...}? ID ;
    public final SiddhiQLGrammarParser.hour_return hour() throws RecognitionException {
        SiddhiQLGrammarParser.hour_return retval = new SiddhiQLGrammarParser.hour_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID475=null;

        CommonTree ID475_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:565:6: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:565:9: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("hour"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "hour", "input.LT(1).getText().equals(\"hour\")");
            }

            ID475=(Token)match(input,ID,FOLLOW_ID_in_hour4335); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID475_tree = 
            (CommonTree)adaptor.create(ID475)
            ;
            adaptor.addChild(root_0, ID475_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "hour"


    public static class minutes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "minutes"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:567:1: minutes :{...}? ID ;
    public final SiddhiQLGrammarParser.minutes_return minutes() throws RecognitionException {
        SiddhiQLGrammarParser.minutes_return retval = new SiddhiQLGrammarParser.minutes_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID476=null;

        CommonTree ID476_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:567:9: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:567:12: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("minutes"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "minutes", "input.LT(1).getText().equals(\"minutes\")");
            }

            ID476=(Token)match(input,ID,FOLLOW_ID_in_minutes4347); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID476_tree = 
            (CommonTree)adaptor.create(ID476)
            ;
            adaptor.addChild(root_0, ID476_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "minutes"


    public static class min_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "min"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:569:1: min :{...}? ID ;
    public final SiddhiQLGrammarParser.min_return min() throws RecognitionException {
        SiddhiQLGrammarParser.min_return retval = new SiddhiQLGrammarParser.min_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID477=null;

        CommonTree ID477_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:569:5: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:569:8: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("min"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "min", "input.LT(1).getText().equals(\"min\")");
            }

            ID477=(Token)match(input,ID,FOLLOW_ID_in_min4359); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID477_tree = 
            (CommonTree)adaptor.create(ID477)
            ;
            adaptor.addChild(root_0, ID477_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "min"


    public static class minute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "minute"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:571:1: minute :{...}? ID ;
    public final SiddhiQLGrammarParser.minute_return minute() throws RecognitionException {
        SiddhiQLGrammarParser.minute_return retval = new SiddhiQLGrammarParser.minute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID478=null;

        CommonTree ID478_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:571:8: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:571:11: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("minute"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "minute", "input.LT(1).getText().equals(\"minute\")");
            }

            ID478=(Token)match(input,ID,FOLLOW_ID_in_minute4371); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID478_tree = 
            (CommonTree)adaptor.create(ID478)
            ;
            adaptor.addChild(root_0, ID478_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "minute"


    public static class seconds_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "seconds"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:573:1: seconds :{...}? ID ;
    public final SiddhiQLGrammarParser.seconds_return seconds() throws RecognitionException {
        SiddhiQLGrammarParser.seconds_return retval = new SiddhiQLGrammarParser.seconds_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID479=null;

        CommonTree ID479_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:573:9: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:573:12: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("seconds"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "seconds", "input.LT(1).getText().equals(\"seconds\")");
            }

            ID479=(Token)match(input,ID,FOLLOW_ID_in_seconds4383); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID479_tree = 
            (CommonTree)adaptor.create(ID479)
            ;
            adaptor.addChild(root_0, ID479_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "seconds"


    public static class second_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "second"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:575:1: second :{...}? ID ;
    public final SiddhiQLGrammarParser.second_return second() throws RecognitionException {
        SiddhiQLGrammarParser.second_return retval = new SiddhiQLGrammarParser.second_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID480=null;

        CommonTree ID480_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:575:8: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:575:11: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("second"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "second", "input.LT(1).getText().equals(\"second\")");
            }

            ID480=(Token)match(input,ID,FOLLOW_ID_in_second4395); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID480_tree = 
            (CommonTree)adaptor.create(ID480)
            ;
            adaptor.addChild(root_0, ID480_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "second"


    public static class sec_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sec"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:577:1: sec :{...}? ID ;
    public final SiddhiQLGrammarParser.sec_return sec() throws RecognitionException {
        SiddhiQLGrammarParser.sec_return retval = new SiddhiQLGrammarParser.sec_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID481=null;

        CommonTree ID481_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:577:5: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:577:8: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("sec"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "sec", "input.LT(1).getText().equals(\"sec\")");
            }

            ID481=(Token)match(input,ID,FOLLOW_ID_in_sec4407); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID481_tree = 
            (CommonTree)adaptor.create(ID481)
            ;
            adaptor.addChild(root_0, ID481_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sec"


    public static class milliseconds_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "milliseconds"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:579:1: milliseconds :{...}? ID ;
    public final SiddhiQLGrammarParser.milliseconds_return milliseconds() throws RecognitionException {
        SiddhiQLGrammarParser.milliseconds_return retval = new SiddhiQLGrammarParser.milliseconds_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID482=null;

        CommonTree ID482_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:579:14: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:579:17: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("milliseconds"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "milliseconds", "input.LT(1).getText().equals(\"milliseconds\")");
            }

            ID482=(Token)match(input,ID,FOLLOW_ID_in_milliseconds4419); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID482_tree = 
            (CommonTree)adaptor.create(ID482)
            ;
            adaptor.addChild(root_0, ID482_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "milliseconds"


    public static class millisecond_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "millisecond"
    // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:581:1: millisecond :{...}? ID ;
    public final SiddhiQLGrammarParser.millisecond_return millisecond() throws RecognitionException {
        SiddhiQLGrammarParser.millisecond_return retval = new SiddhiQLGrammarParser.millisecond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID483=null;

        CommonTree ID483_tree=null;

        try {
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:581:13: ({...}? ID )
            // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:581:16: {...}? ID
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( !((input.LT(1).getText().equals("millisecond"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "millisecond", "input.LT(1).getText().equals(\"millisecond\")");
            }

            ID483=(Token)match(input,ID,FOLLOW_ID_in_millisecond4431); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID483_tree = 
            (CommonTree)adaptor.create(ID483)
            ;
            adaptor.addChild(root_0, ID483_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "millisecond"

    // $ANTLR start synpred22_SiddhiQLGrammar
    public final void synpred22_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:3: ( inputStream outputSelection ( output )? outputStream ( partition )? )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:3: inputStream outputSelection ( output )? outputStream ( partition )?
        {
        pushFollow(FOLLOW_inputStream_in_synpred22_SiddhiQLGrammar780);
        inputStream();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_outputSelection_in_synpred22_SiddhiQLGrammar782);
        outputSelection();

        state._fsp--;
        if (state.failed) return ;

        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:31: ( output )?
        int alt126=2;
        switch ( input.LA(1) ) {
            case 125:
                {
                alt126=1;
                }
                break;
        }

        switch (alt126) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:31: output
                {
                pushFollow(FOLLOW_output_in_synpred22_SiddhiQLGrammar784);
                output();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_outputStream_in_synpred22_SiddhiQLGrammar787);
        outputStream();

        state._fsp--;
        if (state.failed) return ;

        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:52: ( partition )?
        int alt127=2;
        switch ( input.LA(1) ) {
            case 126:
                {
                alt127=1;
                }
                break;
        }

        switch (alt127) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:134:52: partition
                {
                pushFollow(FOLLOW_partition_in_synpred22_SiddhiQLGrammar789);
                partition();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred22_SiddhiQLGrammar

    // $ANTLR start synpred35_SiddhiQLGrammar
    public final void synpred35_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:149:12: ( sequenceFullStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:149:12: sequenceFullStream
        {
        pushFollow(FOLLOW_sequenceFullStream_in_synpred35_SiddhiQLGrammar974);
        sequenceFullStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred35_SiddhiQLGrammar

    // $ANTLR start synpred36_SiddhiQLGrammar
    public final void synpred36_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:150:5: ( patternFullStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:150:5: patternFullStream
        {
        pushFollow(FOLLOW_patternFullStream_in_synpred36_SiddhiQLGrammar988);
        patternFullStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred36_SiddhiQLGrammar

    // $ANTLR start synpred37_SiddhiQLGrammar
    public final void synpred37_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:151:5: ( joinStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:151:5: joinStream
        {
        pushFollow(FOLLOW_joinStream_in_synpred37_SiddhiQLGrammar1005);
        joinStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred37_SiddhiQLGrammar

    // $ANTLR start synpred38_SiddhiQLGrammar
    public final void synpred38_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:152:5: ( windowStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:152:5: windowStream
        {
        pushFollow(FOLLOW_windowStream_in_synpred38_SiddhiQLGrammar1020);
        windowStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred38_SiddhiQLGrammar

    // $ANTLR start synpred61_SiddhiQLGrammar
    public final void synpred61_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:3: ( leftStream join rightStream 'unidirectional' ( 'on' condition )? ( 'within' time )? )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:3: leftStream join rightStream 'unidirectional' ( 'on' condition )? ( 'within' time )?
        {
        pushFollow(FOLLOW_leftStream_in_synpred61_SiddhiQLGrammar1476);
        leftStream();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_join_in_synpred61_SiddhiQLGrammar1478);
        join();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_rightStream_in_synpred61_SiddhiQLGrammar1480);
        rightStream();

        state._fsp--;
        if (state.failed) return ;

        match(input,136,FOLLOW_136_in_synpred61_SiddhiQLGrammar1482); if (state.failed) return ;

        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:48: ( 'on' condition )?
        int alt138=2;
        switch ( input.LA(1) ) {
            case 122:
                {
                alt138=1;
                }
                break;
        }

        switch (alt138) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:49: 'on' condition
                {
                match(input,122,FOLLOW_122_in_synpred61_SiddhiQLGrammar1485); if (state.failed) return ;

                pushFollow(FOLLOW_condition_in_synpred61_SiddhiQLGrammar1487);
                condition();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:66: ( 'within' time )?
        int alt139=2;
        switch ( input.LA(1) ) {
            case 139:
                {
                alt139=1;
                }
                break;
        }

        switch (alt139) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:194:67: 'within' time
                {
                match(input,139,FOLLOW_139_in_synpred61_SiddhiQLGrammar1492); if (state.failed) return ;

                pushFollow(FOLLOW_time_in_synpred61_SiddhiQLGrammar1494);
                time();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred61_SiddhiQLGrammar

    // $ANTLR start synpred64_SiddhiQLGrammar
    public final void synpred64_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:3: ( leftStream join rightStream ( 'on' condition )? ( 'within' time )? )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:3: leftStream join rightStream ( 'on' condition )? ( 'within' time )?
        {
        pushFollow(FOLLOW_leftStream_in_synpred64_SiddhiQLGrammar1517);
        leftStream();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_join_in_synpred64_SiddhiQLGrammar1519);
        join();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_rightStream_in_synpred64_SiddhiQLGrammar1521);
        rightStream();

        state._fsp--;
        if (state.failed) return ;

        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:31: ( 'on' condition )?
        int alt140=2;
        switch ( input.LA(1) ) {
            case 122:
                {
                alt140=1;
                }
                break;
        }

        switch (alt140) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:32: 'on' condition
                {
                match(input,122,FOLLOW_122_in_synpred64_SiddhiQLGrammar1524); if (state.failed) return ;

                pushFollow(FOLLOW_condition_in_synpred64_SiddhiQLGrammar1526);
                condition();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:49: ( 'within' time )?
        int alt141=2;
        switch ( input.LA(1) ) {
            case 139:
                {
                alt141=1;
                }
                break;
        }

        switch (alt141) {
            case 1 :
                // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:195:50: 'within' time
                {
                match(input,139,FOLLOW_139_in_synpred64_SiddhiQLGrammar1531); if (state.failed) return ;

                pushFollow(FOLLOW_time_in_synpred64_SiddhiQLGrammar1533);
                time();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred64_SiddhiQLGrammar

    // $ANTLR start synpred67_SiddhiQLGrammar
    public final void synpred67_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:200:8: ( windowStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:200:8: windowStream
        {
        pushFollow(FOLLOW_windowStream_in_synpred67_SiddhiQLGrammar1608);
        windowStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred67_SiddhiQLGrammar

    // $ANTLR start synpred68_SiddhiQLGrammar
    public final void synpred68_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:205:8: ( windowStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:205:8: windowStream
        {
        pushFollow(FOLLOW_windowStream_in_synpred68_SiddhiQLGrammar1634);
        windowStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred68_SiddhiQLGrammar

    // $ANTLR start synpred77_SiddhiQLGrammar
    public final void synpred77_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:236:4: ( itemStream 'and' itemStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:236:4: itemStream 'and' itemStream
        {
        pushFollow(FOLLOW_itemStream_in_synpred77_SiddhiQLGrammar1883);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        match(input,92,FOLLOW_92_in_synpred77_SiddhiQLGrammar1885); if (state.failed) return ;

        pushFollow(FOLLOW_itemStream_in_synpred77_SiddhiQLGrammar1888);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred77_SiddhiQLGrammar

    // $ANTLR start synpred78_SiddhiQLGrammar
    public final void synpred78_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:237:4: ( itemStream 'or' itemStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:237:4: itemStream 'or' itemStream
        {
        pushFollow(FOLLOW_itemStream_in_synpred78_SiddhiQLGrammar1893);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        match(input,123,FOLLOW_123_in_synpred78_SiddhiQLGrammar1895); if (state.failed) return ;

        pushFollow(FOLLOW_itemStream_in_synpred78_SiddhiQLGrammar1898);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred78_SiddhiQLGrammar

    // $ANTLR start synpred79_SiddhiQLGrammar
    public final void synpred79_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:238:4: ( itemStream '<' collect '>' )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:238:4: itemStream '<' collect '>'
        {
        pushFollow(FOLLOW_itemStream_in_synpred79_SiddhiQLGrammar1903);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        match(input,81,FOLLOW_81_in_synpred79_SiddhiQLGrammar1905); if (state.failed) return ;

        pushFollow(FOLLOW_collect_in_synpred79_SiddhiQLGrammar1906);
        collect();

        state._fsp--;
        if (state.failed) return ;

        match(input,85,FOLLOW_85_in_synpred79_SiddhiQLGrammar1908); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred79_SiddhiQLGrammar

    // $ANTLR start synpred80_SiddhiQLGrammar
    public final void synpred80_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:243:4: ( itemStream 'or' itemStream )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:243:4: itemStream 'or' itemStream
        {
        pushFollow(FOLLOW_itemStream_in_synpred80_SiddhiQLGrammar1934);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        match(input,123,FOLLOW_123_in_synpred80_SiddhiQLGrammar1936); if (state.failed) return ;

        pushFollow(FOLLOW_itemStream_in_synpred80_SiddhiQLGrammar1939);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred80_SiddhiQLGrammar

    // $ANTLR start synpred81_SiddhiQLGrammar
    public final void synpred81_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:244:4: ( itemStream regex )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:244:4: itemStream regex
        {
        pushFollow(FOLLOW_itemStream_in_synpred81_SiddhiQLGrammar1944);
        itemStream();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_regex_in_synpred81_SiddhiQLGrammar1946);
        regex();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred81_SiddhiQLGrammar

    // $ANTLR start synpred90_SiddhiQLGrammar
    public final void synpred90_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:267:4: ( extensionOutFunction 'as' id )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:267:4: extensionOutFunction 'as' id
        {
        pushFollow(FOLLOW_extensionOutFunction_in_synpred90_SiddhiQLGrammar2101);
        extensionOutFunction();

        state._fsp--;
        if (state.failed) return ;

        match(input,93,FOLLOW_93_in_synpred90_SiddhiQLGrammar2103); if (state.failed) return ;

        pushFollow(FOLLOW_id_in_synpred90_SiddhiQLGrammar2105);
        id();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred90_SiddhiQLGrammar

    // $ANTLR start synpred91_SiddhiQLGrammar
    public final void synpred91_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:268:4: ( outFunction 'as' id )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:268:4: outFunction 'as' id
        {
        pushFollow(FOLLOW_outFunction_in_synpred91_SiddhiQLGrammar2118);
        outFunction();

        state._fsp--;
        if (state.failed) return ;

        match(input,93,FOLLOW_93_in_synpred91_SiddhiQLGrammar2120); if (state.failed) return ;

        pushFollow(FOLLOW_id_in_synpred91_SiddhiQLGrammar2122);
        id();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred91_SiddhiQLGrammar

    // $ANTLR start synpred92_SiddhiQLGrammar
    public final void synpred92_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:269:4: ( expression 'as' id )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:269:4: expression 'as' id
        {
        pushFollow(FOLLOW_expression_in_synpred92_SiddhiQLGrammar2134);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,93,FOLLOW_93_in_synpred92_SiddhiQLGrammar2137); if (state.failed) return ;

        pushFollow(FOLLOW_id_in_synpred92_SiddhiQLGrammar2139);
        id();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred92_SiddhiQLGrammar

    // $ANTLR start synpred93_SiddhiQLGrammar
    public final void synpred93_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:36: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:274:36: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred93_SiddhiQLGrammar2173);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred93_SiddhiQLGrammar

    // $ANTLR start synpred94_SiddhiQLGrammar
    public final void synpred94_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:11: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:278:11: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred94_SiddhiQLGrammar2205);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred94_SiddhiQLGrammar

    // $ANTLR start synpred96_SiddhiQLGrammar
    public final void synpred96_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:41: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:294:41: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred96_SiddhiQLGrammar2327);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_SiddhiQLGrammar

    // $ANTLR start synpred98_SiddhiQLGrammar
    public final void synpred98_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:39: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:298:39: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred98_SiddhiQLGrammar2371);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred98_SiddhiQLGrammar

    // $ANTLR start synpred105_SiddhiQLGrammar
    public final void synpred105_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:338:21: ( 'or' conditionExpression )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:338:21: 'or' conditionExpression
        {
        match(input,123,FOLLOW_123_in_synpred105_SiddhiQLGrammar2569); if (state.failed) return ;

        pushFollow(FOLLOW_conditionExpression_in_synpred105_SiddhiQLGrammar2572);
        conditionExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred105_SiddhiQLGrammar

    // $ANTLR start synpred106_SiddhiQLGrammar
    public final void synpred106_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:342:17: ( 'and' conditionExpression )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:342:17: 'and' conditionExpression
        {
        match(input,92,FOLLOW_92_in_synpred106_SiddhiQLGrammar2589); if (state.failed) return ;

        pushFollow(FOLLOW_conditionExpression_in_synpred106_SiddhiQLGrammar2592);
        conditionExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred106_SiddhiQLGrammar

    // $ANTLR start synpred107_SiddhiQLGrammar
    public final void synpred107_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:346:25: ( 'in' streamId )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:346:25: 'in' streamId
        {
        match(input,111,FOLLOW_111_in_synpred107_SiddhiQLGrammar2612); if (state.failed) return ;

        pushFollow(FOLLOW_streamId_in_synpred107_SiddhiQLGrammar2615);
        streamId();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred107_SiddhiQLGrammar

    // $ANTLR start synpred108_SiddhiQLGrammar
    public final void synpred108_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:350:3: ( expression compareOperation expression )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:350:3: expression compareOperation expression
        {
        pushFollow(FOLLOW_expression_in_synpred108_SiddhiQLGrammar2628);
        expression();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_compareOperation_in_synpred108_SiddhiQLGrammar2630);
        compareOperation();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred108_SiddhiQLGrammar2633);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred108_SiddhiQLGrammar

    // $ANTLR start synpred109_SiddhiQLGrammar
    public final void synpred109_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:351:3: ( boolVal )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:351:3: boolVal
        {
        pushFollow(FOLLOW_boolVal_in_synpred109_SiddhiQLGrammar2637);
        boolVal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred109_SiddhiQLGrammar

    // $ANTLR start synpred110_SiddhiQLGrammar
    public final void synpred110_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:352:6: ( '(' conditionExpression ')' )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:352:6: '(' conditionExpression ')'
        {
        match(input,71,FOLLOW_71_in_synpred110_SiddhiQLGrammar2644); if (state.failed) return ;

        pushFollow(FOLLOW_conditionExpression_in_synpred110_SiddhiQLGrammar2645);
        conditionExpression();

        state._fsp--;
        if (state.failed) return ;

        match(input,72,FOLLOW_72_in_synpred110_SiddhiQLGrammar2647); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred110_SiddhiQLGrammar

    // $ANTLR start synpred112_SiddhiQLGrammar
    public final void synpred112_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:354:6: ( extensionCondition )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:354:6: extensionCondition
        {
        pushFollow(FOLLOW_extensionCondition_in_synpred112_SiddhiQLGrammar2665);
        extensionCondition();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred112_SiddhiQLGrammar

    // $ANTLR start synpred119_SiddhiQLGrammar
    public final void synpred119_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:380:7: ( attributeVariable )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:380:7: attributeVariable
        {
        pushFollow(FOLLOW_attributeVariable_in_synpred119_SiddhiQLGrammar2814);
        attributeVariable();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_SiddhiQLGrammar

    // $ANTLR start synpred123_SiddhiQLGrammar
    public final void synpred123_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:388:3: ( 'not' '(' conditionExpression ')' )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:388:3: 'not' '(' conditionExpression ')'
        {
        match(input,121,FOLLOW_121_in_synpred123_SiddhiQLGrammar2866); if (state.failed) return ;

        match(input,71,FOLLOW_71_in_synpred123_SiddhiQLGrammar2868); if (state.failed) return ;

        pushFollow(FOLLOW_conditionExpression_in_synpred123_SiddhiQLGrammar2869);
        conditionExpression();

        state._fsp--;
        if (state.failed) return ;

        match(input,72,FOLLOW_72_in_synpred123_SiddhiQLGrammar2870); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred123_SiddhiQLGrammar

    // $ANTLR start synpred124_SiddhiQLGrammar
    public final void synpred124_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:39: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:393:39: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred124_SiddhiQLGrammar2917);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred124_SiddhiQLGrammar

    // $ANTLR start synpred126_SiddhiQLGrammar
    public final void synpred126_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:23: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:397:23: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred126_SiddhiQLGrammar2961);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_SiddhiQLGrammar

    // $ANTLR start synpred128_SiddhiQLGrammar
    public final void synpred128_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:39: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:401:39: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred128_SiddhiQLGrammar3007);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred128_SiddhiQLGrammar

    // $ANTLR start synpred130_SiddhiQLGrammar
    public final void synpred130_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:23: ( parameters )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:405:23: parameters
        {
        pushFollow(FOLLOW_parameters_in_synpred130_SiddhiQLGrammar3051);
        parameters();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_SiddhiQLGrammar

    // $ANTLR start synpred132_SiddhiQLGrammar
    public final void synpred132_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:411:3: ( intVal )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:411:3: intVal
        {
        pushFollow(FOLLOW_intVal_in_synpred132_SiddhiQLGrammar3086);
        intVal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_SiddhiQLGrammar

    // $ANTLR start synpred133_SiddhiQLGrammar
    public final void synpred133_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:412:3: ( longVal )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:412:3: longVal
        {
        pushFollow(FOLLOW_longVal_in_synpred133_SiddhiQLGrammar3099);
        longVal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_SiddhiQLGrammar

    // $ANTLR start synpred134_SiddhiQLGrammar
    public final void synpred134_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:413:3: ( floatVal )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:413:3: floatVal
        {
        pushFollow(FOLLOW_floatVal_in_synpred134_SiddhiQLGrammar3112);
        floatVal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred134_SiddhiQLGrammar

    // $ANTLR start synpred135_SiddhiQLGrammar
    public final void synpred135_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:414:3: ( doubleVal )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:414:3: doubleVal
        {
        pushFollow(FOLLOW_doubleVal_in_synpred135_SiddhiQLGrammar3126);
        doubleVal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred135_SiddhiQLGrammar

    // $ANTLR start synpred154_SiddhiQLGrammar
    public final void synpred154_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:8: ( yearValue )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:8: yearValue
        {
        pushFollow(FOLLOW_yearValue_in_synpred154_SiddhiQLGrammar3522);
        yearValue();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred154_SiddhiQLGrammar

    // $ANTLR start synpred155_SiddhiQLGrammar
    public final void synpred155_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:21: ( monthValue )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:21: monthValue
        {
        pushFollow(FOLLOW_monthValue_in_synpred155_SiddhiQLGrammar3527);
        monthValue();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred155_SiddhiQLGrammar

    // $ANTLR start synpred156_SiddhiQLGrammar
    public final void synpred156_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:35: ( weekValue )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:35: weekValue
        {
        pushFollow(FOLLOW_weekValue_in_synpred156_SiddhiQLGrammar3532);
        weekValue();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred156_SiddhiQLGrammar

    // $ANTLR start synpred157_SiddhiQLGrammar
    public final void synpred157_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:48: ( dayValue )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:48: dayValue
        {
        pushFollow(FOLLOW_dayValue_in_synpred157_SiddhiQLGrammar3537);
        dayValue();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred157_SiddhiQLGrammar

    // $ANTLR start synpred158_SiddhiQLGrammar
    public final void synpred158_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:60: ( hourValue )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:60: hourValue
        {
        pushFollow(FOLLOW_hourValue_in_synpred158_SiddhiQLGrammar3542);
        hourValue();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred158_SiddhiQLGrammar

    // $ANTLR start synpred159_SiddhiQLGrammar
    public final void synpred159_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:73: ( minuteValue )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:73: minuteValue
        {
        pushFollow(FOLLOW_minuteValue_in_synpred159_SiddhiQLGrammar3547);
        minuteValue();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred159_SiddhiQLGrammar

    // $ANTLR start synpred160_SiddhiQLGrammar
    public final void synpred160_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:88: ( secondValue )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:464:88: secondValue
        {
        pushFollow(FOLLOW_secondValue_in_synpred160_SiddhiQLGrammar3552);
        secondValue();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred160_SiddhiQLGrammar

    // $ANTLR start synpred162_SiddhiQLGrammar
    public final void synpred162_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:23: ( years )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:469:23: years
        {
        pushFollow(FOLLOW_years_in_synpred162_SiddhiQLGrammar3608);
        years();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred162_SiddhiQLGrammar

    // $ANTLR start synpred163_SiddhiQLGrammar
    public final void synpred163_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:23: ( months )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:473:23: months
        {
        pushFollow(FOLLOW_months_in_synpred163_SiddhiQLGrammar3638);
        months();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred163_SiddhiQLGrammar

    // $ANTLR start synpred164_SiddhiQLGrammar
    public final void synpred164_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:23: ( weeks )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:477:23: weeks
        {
        pushFollow(FOLLOW_weeks_in_synpred164_SiddhiQLGrammar3669);
        weeks();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred164_SiddhiQLGrammar

    // $ANTLR start synpred165_SiddhiQLGrammar
    public final void synpred165_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:23: ( days )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:481:23: days
        {
        pushFollow(FOLLOW_days_in_synpred165_SiddhiQLGrammar3699);
        days();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred165_SiddhiQLGrammar

    // $ANTLR start synpred166_SiddhiQLGrammar
    public final void synpred166_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:23: ( hours )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:485:23: hours
        {
        pushFollow(FOLLOW_hours_in_synpred166_SiddhiQLGrammar3730);
        hours();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred166_SiddhiQLGrammar

    // $ANTLR start synpred167_SiddhiQLGrammar
    public final void synpred167_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:23: ( minutes )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:23: minutes
        {
        pushFollow(FOLLOW_minutes_in_synpred167_SiddhiQLGrammar3763);
        minutes();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred167_SiddhiQLGrammar

    // $ANTLR start synpred168_SiddhiQLGrammar
    public final void synpred168_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:34: ( min )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:489:34: min
        {
        pushFollow(FOLLOW_min_in_synpred168_SiddhiQLGrammar3768);
        min();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred168_SiddhiQLGrammar

    // $ANTLR start synpred169_SiddhiQLGrammar
    public final void synpred169_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:22: ( seconds )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:22: seconds
        {
        pushFollow(FOLLOW_seconds_in_synpred169_SiddhiQLGrammar3800);
        seconds();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred169_SiddhiQLGrammar

    // $ANTLR start synpred170_SiddhiQLGrammar
    public final void synpred170_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:32: ( second )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:493:32: second
        {
        pushFollow(FOLLOW_second_in_synpred170_SiddhiQLGrammar3804);
        second();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred170_SiddhiQLGrammar

    // $ANTLR start synpred171_SiddhiQLGrammar
    public final void synpred171_SiddhiQLGrammar_fragment() throws RecognitionException {
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:23: ( milliseconds )
        // org/wso2/siddhi/query/compiler/SiddhiQLGrammar.g:497:23: milliseconds
        {
        pushFollow(FOLLOW_milliseconds_in_synpred171_SiddhiQLGrammar3837);
        milliseconds();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred171_SiddhiQLGrammar

    // Delegated rules

    public final boolean synpred126_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred162_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred162_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred159_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred159_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred164_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred164_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred166_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred166_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred165_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred165_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred79_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred169_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred169_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred154_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred154_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred167_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred167_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred156_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred156_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred163_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred163_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred158_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred158_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred171_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred171_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred130_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred168_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred168_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred155_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred155_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred157_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred157_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred170_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred170_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred123_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred160_SiddhiQLGrammar() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred160_SiddhiQLGrammar_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_definitionPartition_in_executionPlan348 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_definitionStream_in_executionPlan350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_definitionTable_in_executionPlan352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_query_in_executionPlan354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_executionPlan358 = new BitSet(new long[]{0x0000000000000000L,0x0000080400000000L});
    public static final BitSet FOLLOW_definitionPartition_in_executionPlan361 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_definitionStream_in_executionPlan364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_definitionTable_in_executionPlan366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_query_in_executionPlan368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_executionPlan373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_executionPlan376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definitionStream_in_definitionStreamFinal429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_definitionStreamFinal431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_definitionStreamFinal434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_definitionStream452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_definitionStream454 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_streamId_in_definitionStream456 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_definitionStream458 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_attributeName_in_definitionStream460 = new BitSet(new long[]{0x0000000000000000L,0x0108021040000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_definitionStream462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000900L});
    public static final BitSet FOLLOW_75_in_definitionStream465 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_attributeName_in_definitionStream467 = new BitSet(new long[]{0x0000000000000000L,0x0108021040000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_definitionStream469 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000900L});
    public static final BitSet FOLLOW_72_in_definitionStream474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definitionPartition_in_definitionPartitionFinal506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_definitionPartitionFinal508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_definitionPartitionFinal511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_definitionPartition529 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_definitionPartition531 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_partitionId_in_definitionPartition533 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_definitionPartition535 = new BitSet(new long[]{0x0000000000600000L,0x8000000000000000L});
    public static final BitSet FOLLOW_partitionType_in_definitionPartition537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_definitionPartition540 = new BitSet(new long[]{0x0000000000600000L,0x8000000000000000L});
    public static final BitSet FOLLOW_partitionType_in_definitionPartition542 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_streamAttributeName_in_partitionType579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_partitionType591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_partitionType603 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_partitionType605 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_partitionType607 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_stringVal_in_partitionType609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definitionTable_in_definitionTableFinal635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_definitionTableFinal637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_definitionTableFinal640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_definitionTable658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_definitionTable660 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_definitionTable662 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_definitionTable664 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_attributeName_in_definitionTable666 = new BitSet(new long[]{0x0000000000000000L,0x0108021040000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_definitionTable668 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000900L});
    public static final BitSet FOLLOW_75_in_definitionTable671 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_attributeName_in_definitionTable673 = new BitSet(new long[]{0x0000000000000000L,0x0108021040000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_definitionTable675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000900L});
    public static final BitSet FOLLOW_72_in_definitionTable680 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_definitionTable683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_definitionTable685 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_tableParamName_in_definitionTable687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_definitionTable689 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_tableParamValue_in_definitionTable691 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000900L});
    public static final BitSet FOLLOW_75_in_definitionTable694 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_tableParamName_in_definitionTable696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_definitionTable698 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_tableParamValue_in_definitionTable700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000900L});
    public static final BitSet FOLLOW_72_in_definitionTable705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_queryFinal758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_queryFinal760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_queryFinal763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputStream_in_query780 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_outputSelection_in_query782 = new BitSet(new long[]{0x0000000000000000L,0x2002000800000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_output_in_query784 = new BitSet(new long[]{0x0000000000000000L,0x0002000800000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_outputStream_in_query787 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_partition_in_query789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputStream_in_query813 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_outputSelection_in_query815 = new BitSet(new long[]{0x0000000000000002L,0x6000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_output_in_query817 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_query820 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_partition_in_query823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_outputStream852 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_outputStream854 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_streamId_in_outputStream856 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
    public static final BitSet FOLLOW_outputTypeCondition_in_outputStream858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_outputStream874 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_outputStream876 = new BitSet(new long[]{0x0000000000000002L,0x0400040000000000L});
    public static final BitSet FOLLOW_outputTypeCondition_in_outputStream878 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_outputStream882 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_outputStream884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_outputStream905 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_outputStream907 = new BitSet(new long[]{0x0000000000000002L,0x0400040000000000L});
    public static final BitSet FOLLOW_outputTypeCondition_in_outputStream909 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_outputStream913 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_outputStream915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_outputTypeCondition943 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_outputTypeCondition946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_outputTypeCondition950 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_outputTypeCondition953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_outputTypeCondition957 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_outputTypeCondition960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_inputStream970 = new BitSet(new long[]{0x0000000000600000L,0x0000004000000080L});
    public static final BitSet FOLLOW_sequenceFullStream_in_inputStream974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_patternFullStream_in_inputStream988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_joinStream_in_inputStream1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_inputStream1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basicStream_in_inputStream1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_output1052 = new BitSet(new long[]{0x0000000000000000L,0x0040014004000000L});
    public static final BitSet FOLLOW_outputType_in_output1054 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_output1057 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_timeExpr_in_output1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_output1113 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_output1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_output1136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_output1138 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_output1140 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_timeExpr_in_output1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_partition1186 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_partition1188 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_partitionId_in_partition1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_patternFullStream1212 = new BitSet(new long[]{0x0000000000600000L,0x0000004000000000L});
    public static final BitSet FOLLOW_patternStream_in_patternFullStream1214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_patternFullStream1216 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_patternFullStream1219 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_patternFullStream1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_patternStream_in_patternFullStream1243 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_patternFullStream1247 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_patternFullStream1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rawStream_in_basicStream1280 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000020L});
    public static final BitSet FOLLOW_transformHandler_in_basicStream1282 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_basicStream1286 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_basicStream1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamId_in_windowStream1316 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000020L});
    public static final BitSet FOLLOW_filterHandler_in_windowStream1319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_transformHandler_in_windowStream1322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_windowHandler_in_windowStream1325 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_windowStream1328 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_windowStream1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_windowStream1359 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_returnQuery_in_windowStream1361 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_windowStream1363 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000020L});
    public static final BitSet FOLLOW_filterHandler_in_windowStream1366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_transformHandler_in_windowStream1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_windowHandler_in_windowStream1372 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_windowStream1375 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_windowStream1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamId_in_rawStream1419 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_filterHandler_in_rawStream1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_rawStream1443 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_returnQuery_in_rawStream1445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rawStream1447 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_filterHandler_in_rawStream1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_joinStream1476 = new BitSet(new long[]{0x0000000000000000L,0x10A1100000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_join_in_joinStream1478 = new BitSet(new long[]{0x0000000000600000L,0x0000000000000080L});
    public static final BitSet FOLLOW_rightStream_in_joinStream1480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_joinStream1482 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_122_in_joinStream1485 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_joinStream1487 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_joinStream1492 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_joinStream1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_joinStream1517 = new BitSet(new long[]{0x0000000000000000L,0x10A1100000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_join_in_joinStream1519 = new BitSet(new long[]{0x0000000000600000L,0x0000000000000080L});
    public static final BitSet FOLLOW_rightStream_in_joinStream1521 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_122_in_joinStream1524 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_joinStream1526 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_joinStream1531 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_joinStream1533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_joinStream1555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_joinStream1557 = new BitSet(new long[]{0x0000000000000000L,0x10A1100000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_join_in_joinStream1559 = new BitSet(new long[]{0x0000000000600000L,0x0000000000000080L});
    public static final BitSet FOLLOW_rightStream_in_joinStream1561 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_122_in_joinStream1564 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_joinStream1566 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_joinStream1571 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_joinStream1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_leftStream1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basicStream_in_leftStream1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_rightStream1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basicStream_in_rightStream1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputStream_in_returnQuery1657 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_outputSelection_in_returnQuery1659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_returnQuery1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_patternItem_in_patternStream1683 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_FOLLOWED_BY_in_patternStream1687 = new BitSet(new long[]{0x0000000000600000L,0x0000004000000000L});
    public static final BitSet FOLLOW_patternStream_in_patternStream1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_patternStream1707 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_patternItem_in_patternStream1709 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_FOLLOWED_BY_in_patternStream1713 = new BitSet(new long[]{0x0000000000600000L,0x0000004000000000L});
    public static final BitSet FOLLOW_patternStream_in_patternStream1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_patternStream1739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_patternStream1741 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_nonEveryPatternStream_in_patternStream1742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_patternStream1743 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_FOLLOWED_BY_in_patternStream1747 = new BitSet(new long[]{0x0000000000600000L,0x0000004000000000L});
    public static final BitSet FOLLOW_patternStream_in_patternStream1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_patternItem_in_nonEveryPatternStream1778 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_FOLLOWED_BY_in_nonEveryPatternStream1783 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_nonEveryPatternStream_in_nonEveryPatternStream1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceStream_in_sequenceFullStream1807 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_sequenceFullStream1810 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_sequenceFullStream1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceItem_in_sequenceStream1839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_sequenceStream1841 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_sequenceItem_in_sequenceStream1843 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_sequenceStream1847 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_sequenceItem_in_sequenceStream1849 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1883 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_patternItem1885 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1893 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_patternItem1895 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_patternItem1905 = new BitSet(new long[]{0x0000200000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_collect_in_patternItem1906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_patternItem1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_patternItem1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1934 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_sequenceItem1936 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800600L});
    public static final BitSet FOLLOW_regex_in_sequenceItem1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_sequenceItem1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_itemStream1972 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_itemStream1973 = new BitSet(new long[]{0x0000000000600000L,0x0000000000000080L});
    public static final BitSet FOLLOW_rawStream_in_itemStream1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_regex1999 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_regex2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_outputAttributeList_in_outputSelection2020 = new BitSet(new long[]{0x0000000000000002L,0x0000600000000000L});
    public static final BitSet FOLLOW_groupBy_in_outputSelection2022 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_having_in_outputSelection2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_outputAttributeList2053 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_outputAttributeList2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_outputAttributeList2064 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_outputItem_in_outputAttributeList2066 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_outputAttributeList2069 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_outputItem_in_outputAttributeList2071 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_extensionOutFunction_in_outputItem2101 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_outputItem2103 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_outputItem2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_outFunction_in_outputItem2118 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_outputItem2120 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_outputItem2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_outputItem2134 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_outputItem2137 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_outputItem2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeVariable_in_outputItem2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionId_in_extensionOutFunction2164 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_extensionOutFunction2166 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_functionId_in_extensionOutFunction2168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_extensionOutFunction2171 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_extensionOutFunction2173 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_extensionOutFunction2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_outFunction2201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_outFunction2203 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_outFunction2205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_outFunction2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_groupBy2231 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_groupBy2233 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_attributeVariable_in_groupBy2235 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_groupBy2238 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_attributeVariable_in_groupBy2240 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_110_in_having2265 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_having2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_filterHandler2287 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_filterHandler2289 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_filterHandler2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_transformHandler2315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_transform_in_transformHandler2317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_transformHandler2319 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_extensibleId_in_transformHandler2321 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_transformHandler2325 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_transformHandler2327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_transformHandler2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_windowHandler2358 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_window_in_windowHandler2360 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_windowHandler2363 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_extensibleId_in_windowHandler2365 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_windowHandler2369 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_windowHandler2371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_windowHandler2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionId_in_extensibleId2402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_extensibleId2404 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_functionId_in_extensibleId2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_extensibleId2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_parameters2435 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_parameters2438 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameter_in_parameters2440 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_constant_in_time2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_parameter2476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStart_in_collect2487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_collect2489 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_countEnd_in_collect2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStart_in_collect2496 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_collect2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_collect2503 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_countEnd_in_collect2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStartAndEnd_in_collect2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_countStart2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_countEnd2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_countStartAndEnd2533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionExpression_in_condition2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andCondition_in_conditionExpression2566 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_conditionExpression2569 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_conditionExpression2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inCondition_in_andCondition2586 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_andCondition2589 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_andCondition2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compareCondition_in_inCondition2609 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_inCondition2612 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_streamId_in_inCondition2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_compareCondition2628 = new BitSet(new long[]{0x0000000000000000L,0x0004000100760010L});
    public static final BitSet FOLLOW_compareOperation_in_compareCondition2630 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_compareCondition2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolVal_in_compareCondition2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_compareCondition2644 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_compareCondition2645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_compareCondition2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notCondition_in_compareCondition2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionCondition_in_compareCondition2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCondition_in_compareCondition2672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minusExpression_in_expression2685 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_expression2688 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_expression2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplyExpression_in_minusExpression2709 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_minusExpression2712 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_minusExpression_in_minusExpression2715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_divisionExpression_in_multiplyExpression2733 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_multiplyExpression2736 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_multiplyExpression_in_multiplyExpression2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modExpression_in_divisionExpression2757 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_divisionExpression2760 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_divisionExpression_in_divisionExpression2763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueExpression_in_modExpression2781 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_modExpression2784 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_modExpression_in_modExpression2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_valueExpression2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeVariable_in_valueExpression2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_valueExpression2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_valueExpression2830 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_valueExpression2831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_valueExpression2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionExpression_in_valueExpression2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionExpression_in_valueExpression2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_notCondition2866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_notCondition2868 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_notCondition2869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_notCondition2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_notCondition2883 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_notCondition2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionId_in_extensionCondition2907 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_extensionCondition2909 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_functionId_in_extensionCondition2911 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_extensionCondition2915 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_extensionCondition2917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_extensionCondition2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionId_in_functionCondition2955 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_functionCondition2959 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_functionCondition2961 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_functionCondition2964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionId_in_extensionExpression2997 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_extensionExpression2999 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_functionId_in_extensionExpression3001 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_extensionExpression3005 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_extensionExpression3007 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_extensionExpression3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionId_in_functionExpression3045 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_functionExpression3049 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001180L,0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_functionExpression3051 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_functionExpression3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intVal_in_constant3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_longVal_in_constant3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatVal_in_constant3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleVal_in_constant3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolVal_in_constant3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringVal_in_constant3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timeExpr_in_constant3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_partitionId3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_streamId3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamPositionAttributeName_in_attributeVariable3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamAttributeName_in_attributeVariable3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attributeVariable3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamId_in_streamPositionAttributeName3212 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_streamPositionAttributeName3214 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_streamPositionAttributeName3215 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_streamPositionAttributeName3216 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_streamPositionAttributeName3217 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_streamPositionAttributeName3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamId_in_streamPositionAttributeName3239 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_streamPositionAttributeName3241 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_118_in_streamPositionAttributeName3243 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_streamPositionAttributeName3245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_streamPositionAttributeName3246 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_streamPositionAttributeName3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_streamId_in_streamAttributeName3275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_streamAttributeName3277 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_streamAttributeName3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_attributeName3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_join3325 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_join3326 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_join3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_join3346 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_join3348 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_join3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_join3367 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_join3368 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_join3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_join3387 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_join3389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_join3407 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_join3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_join3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_window3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_transform3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yearValue_in_timeExpr3522 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_monthValue_in_timeExpr3527 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_weekValue_in_timeExpr3532 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_dayValue_in_timeExpr3537 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_hourValue_in_timeExpr3542 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_minuteValue_in_timeExpr3547 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_secondValue_in_timeExpr3552 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_milliSecondValue_in_timeExpr3558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_yearValue3604 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_years_in_yearValue3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_year_in_yearValue3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_monthValue3634 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_months_in_monthValue3638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_month_in_monthValue3642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_weekValue3665 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_weeks_in_weekValue3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_week_in_weekValue3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_dayValue3695 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_days_in_dayValue3699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_day_in_dayValue3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_hourValue3726 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_hours_in_hourValue3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hour_in_hourValue3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_minuteValue3759 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_minutes_in_minuteValue3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_min_in_minuteValue3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minute_in_minuteValue3773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_secondValue3797 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_seconds_in_secondValue3800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_second_in_secondValue3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sec_in_secondValue3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_milliSecondValue3833 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_milliseconds_in_milliSecondValue3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_millisecond_in_milliSecondValue3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_intVal3865 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_POSITIVE_INT_VAL_in_intVal3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_longVal3887 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_POSITIVE_LONG_VAL_in_longVal3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_floatVal3909 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_POSITIVE_FLOAT_VAL_in_floatVal3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_doubleVal3931 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_POSITIVE_DOUBLE_VAL_in_doubleVal3934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_VAL_in_boolVal3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_extensionId3960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_functionId3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_tableType3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_databaseName3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_tableName3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_dataSourceName3996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_VAL_in_stringVal4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringVal_in_tableParamName4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringVal_in_tableParamValue4019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_years4227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_year4239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_months4251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_month4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_weeks4275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_week4287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_days4299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_day4311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_hours4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_hour4335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_minutes4347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_min4359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_minute4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_seconds4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_second4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_sec4407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_milliseconds4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_millisecond4431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputStream_in_synpred22_SiddhiQLGrammar780 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_outputSelection_in_synpred22_SiddhiQLGrammar782 = new BitSet(new long[]{0x0000000000000000L,0x2002000800000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_output_in_synpred22_SiddhiQLGrammar784 = new BitSet(new long[]{0x0000000000000000L,0x0002000800000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_outputStream_in_synpred22_SiddhiQLGrammar787 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_partition_in_synpred22_SiddhiQLGrammar789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceFullStream_in_synpred35_SiddhiQLGrammar974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_patternFullStream_in_synpred36_SiddhiQLGrammar988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_joinStream_in_synpred37_SiddhiQLGrammar1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_synpred38_SiddhiQLGrammar1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_synpred61_SiddhiQLGrammar1476 = new BitSet(new long[]{0x0000000000000000L,0x10A1100000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_join_in_synpred61_SiddhiQLGrammar1478 = new BitSet(new long[]{0x0000000000600000L,0x0000000000000080L});
    public static final BitSet FOLLOW_rightStream_in_synpred61_SiddhiQLGrammar1480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_synpred61_SiddhiQLGrammar1482 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_122_in_synpred61_SiddhiQLGrammar1485 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_synpred61_SiddhiQLGrammar1487 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_synpred61_SiddhiQLGrammar1492 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_synpred61_SiddhiQLGrammar1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftStream_in_synpred64_SiddhiQLGrammar1517 = new BitSet(new long[]{0x0000000000000000L,0x10A1100000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_join_in_synpred64_SiddhiQLGrammar1519 = new BitSet(new long[]{0x0000000000600000L,0x0000000000000080L});
    public static final BitSet FOLLOW_rightStream_in_synpred64_SiddhiQLGrammar1521 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_122_in_synpred64_SiddhiQLGrammar1524 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_condition_in_synpred64_SiddhiQLGrammar1526 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_synpred64_SiddhiQLGrammar1531 = new BitSet(new long[]{0x0200780000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_time_in_synpred64_SiddhiQLGrammar1533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_synpred67_SiddhiQLGrammar1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_windowStream_in_synpred68_SiddhiQLGrammar1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_synpred77_SiddhiQLGrammar1883 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_synpred77_SiddhiQLGrammar1885 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_itemStream_in_synpred77_SiddhiQLGrammar1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_synpred78_SiddhiQLGrammar1893 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_synpred78_SiddhiQLGrammar1895 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_itemStream_in_synpred78_SiddhiQLGrammar1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_synpred79_SiddhiQLGrammar1903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_synpred79_SiddhiQLGrammar1905 = new BitSet(new long[]{0x0000200000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_collect_in_synpred79_SiddhiQLGrammar1906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_synpred79_SiddhiQLGrammar1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_synpred80_SiddhiQLGrammar1934 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_synpred80_SiddhiQLGrammar1936 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_itemStream_in_synpred80_SiddhiQLGrammar1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemStream_in_synpred81_SiddhiQLGrammar1944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800600L});
    public static final BitSet FOLLOW_regex_in_synpred81_SiddhiQLGrammar1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionOutFunction_in_synpred90_SiddhiQLGrammar2101 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_synpred90_SiddhiQLGrammar2103 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_synpred90_SiddhiQLGrammar2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_outFunction_in_synpred91_SiddhiQLGrammar2118 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_synpred91_SiddhiQLGrammar2120 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_synpred91_SiddhiQLGrammar2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred92_SiddhiQLGrammar2134 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_synpred92_SiddhiQLGrammar2137 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_id_in_synpred92_SiddhiQLGrammar2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred93_SiddhiQLGrammar2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred94_SiddhiQLGrammar2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred96_SiddhiQLGrammar2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred98_SiddhiQLGrammar2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_synpred105_SiddhiQLGrammar2569 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_synpred105_SiddhiQLGrammar2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_synpred106_SiddhiQLGrammar2589 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_synpred106_SiddhiQLGrammar2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_synpred107_SiddhiQLGrammar2612 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_streamId_in_synpred107_SiddhiQLGrammar2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred108_SiddhiQLGrammar2628 = new BitSet(new long[]{0x0000000000000000L,0x0004000100760010L});
    public static final BitSet FOLLOW_compareOperation_in_synpred108_SiddhiQLGrammar2630 = new BitSet(new long[]{0x0200780000600040L,0x0108021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_synpred108_SiddhiQLGrammar2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolVal_in_synpred109_SiddhiQLGrammar2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_synpred110_SiddhiQLGrammar2644 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_synpred110_SiddhiQLGrammar2645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_synpred110_SiddhiQLGrammar2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extensionCondition_in_synpred112_SiddhiQLGrammar2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeVariable_in_synpred119_SiddhiQLGrammar2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_synpred123_SiddhiQLGrammar2866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_synpred123_SiddhiQLGrammar2868 = new BitSet(new long[]{0x0200780000600040L,0x0308021040001080L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionExpression_in_synpred123_SiddhiQLGrammar2869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_synpred123_SiddhiQLGrammar2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred124_SiddhiQLGrammar2917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred126_SiddhiQLGrammar2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred128_SiddhiQLGrammar3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameters_in_synpred130_SiddhiQLGrammar3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intVal_in_synpred132_SiddhiQLGrammar3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_longVal_in_synpred133_SiddhiQLGrammar3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatVal_in_synpred134_SiddhiQLGrammar3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleVal_in_synpred135_SiddhiQLGrammar3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yearValue_in_synpred154_SiddhiQLGrammar3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_monthValue_in_synpred155_SiddhiQLGrammar3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_weekValue_in_synpred156_SiddhiQLGrammar3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dayValue_in_synpred157_SiddhiQLGrammar3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hourValue_in_synpred158_SiddhiQLGrammar3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minuteValue_in_synpred159_SiddhiQLGrammar3547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_secondValue_in_synpred160_SiddhiQLGrammar3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_years_in_synpred162_SiddhiQLGrammar3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_months_in_synpred163_SiddhiQLGrammar3638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_weeks_in_synpred164_SiddhiQLGrammar3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_days_in_synpred165_SiddhiQLGrammar3699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hours_in_synpred166_SiddhiQLGrammar3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minutes_in_synpred167_SiddhiQLGrammar3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_min_in_synpred168_SiddhiQLGrammar3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seconds_in_synpred169_SiddhiQLGrammar3800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_second_in_synpred170_SiddhiQLGrammar3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_milliseconds_in_synpred171_SiddhiQLGrammar3837 = new BitSet(new long[]{0x0000000000000002L});

}