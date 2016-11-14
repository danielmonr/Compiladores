/* Generated By:JavaCC: Do not edit this line. parser_robot.java */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class parser_robot implements parser_robotConstants {

  public static String s = "";

  public static void main(String args[]) throws ParseException {
    try {
      parser_robot parser = new parser_robot(new java.io.FileInputStream(args[0]));
      parser.Program();
    }
    catch(java.io.FileNotFoundException e)
    {
      System.out.println("El archivo no esta...");
    }
  }

  static final public void Program() throws ParseException {
  System.out.println("Iniciando revision del programa");
  s = "#include <iostream>\u005cn#include \u005c"Robot.h\u005c"\u005cnint main(){\u005cn Robot r1();\u005cn r1.connect();\u005cn";
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GIR:
      case RET:
      case AV:
        FUNC();
        break;
      case SI:
        COND();
        break;
      case REP:
        LOOP();
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SI:
      case REP:
      case GIR:
      case RET:
      case AV:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
  s+= "r1.exit(); \u005cn }";

  try {

      File file = new File("res.txt");

      // if file doesnt exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(s);
      bw.close();

      System.out.println("Done");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static final public void FUNC() throws ParseException {
  System.out.println("Una funci\u00f3n");
  Token n, g = null;
  int num;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AV:
      jj_consume_token(AV);
      jj_consume_token(AP);
      n = jj_consume_token(ENTERO);
      jj_consume_token(CP);
    num = Integer.parseInt(n.image);
    if (num > 500)
      System.out.println("Warning: Distance should be under 500.\u005cn");
    s += "r1.lock();\u005cnr1.move(" + num*10 + ");\u005cnunlock();\u005cn";
      break;
    case RET:
      jj_consume_token(RET);
      jj_consume_token(AP);
      n = jj_consume_token(ENTERO);
      jj_consume_token(CP);
    num = Integer.parseInt(n.image);
    if (num > 500)
      System.out.println("Warning: Distance should be under 500.\u005cn");
    s += "r1.lock();\u005cnr1.move(-" + num*10 + ");\u005cnunlock();\u005cn";
      break;
    case GIR:
      jj_consume_token(GIR);
      jj_consume_token(AP);
      n = jj_consume_token(ENTERO);
      jj_consume_token(CO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IZQ:
        g = jj_consume_token(IZQ);
        break;
      case DER:
        g = jj_consume_token(DER);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(CP);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    num = Integer.parseInt(n.image);
    if (num > 180 || num < 0){
      System.out.println("Error: Angle should be between 0 and 180 degrees.\u005cn");
      System.exit(0);
      }
      if(g.image == "izquierda")
        s += "r1.lock();\u005cnr1.setDeltaHeading(-" + n.image + ");\u005cnunlock();\u005cn";
      else
        s += "r1.lock();\u005cnr1.setDeltaHeading(" + n.image + ");\u005cnunlock();\u005cn";
  }

  static final public void COND() throws ParseException {
  System.out.println("Una funci\u00f3n");
  Token se, val, c;
    jj_consume_token(SI);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case V1:
      se = jj_consume_token(V1);
      break;
    case V2:
      se = jj_consume_token(V2);
      break;
    case V3:
      se = jj_consume_token(V3);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAQ:
      c = jj_consume_token(MAQ);
      break;
    case MEQ:
      c = jj_consume_token(MEQ);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    val = jj_consume_token(ENTERO);
    jj_consume_token(ENT);
    int num = Integer.parseInt(val.image);
    if(num < 30 || num > 500){
      System.out.println("Error: Cant compare a sensor value with values less than 30 or greater than 500.\u005cn");
      System.exit(0);
    }
    s+= "int " + se.image + " = r1.read(sonar";
    switch(se.image){
    case "s1":
      s+= "1";
      break;
    case "s2":
      s+= "2";
      break;
    case "s3":
      s+= "3";
      break;
    }
    s+= "if (" + se.image + c.image + "){\u005cn";
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GIR:
      case RET:
      case AV:
        FUNC();
        break;
      case SI:
        COND();
        break;
      case REP:
        LOOP();
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SI:
      case REP:
      case GIR:
      case RET:
      case AV:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_2;
      }
    }
    jj_consume_token(FIN);
    s+= "}\u005cn";
  }

  static final public void LOOP() throws ParseException {
  System.out.println("Una funci\u00f3n");
Token i;
    jj_consume_token(REP);
    i = jj_consume_token(ENTERO);
    jj_consume_token(VEC);
    jj_consume_token(DP);
    s+= "for(int i = 0; i < " + i.image + "; i++){\u005cn";
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GIR:
      case RET:
      case AV:
        FUNC();
        break;
      case SI:
        COND();
        break;
      case REP:
        LOOP();
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SI:
      case REP:
      case GIR:
      case RET:
      case AV:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_3;
      }
    }
    jj_consume_token(FIN);
    s+= "}\u005cn";
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public parser_robotTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[10];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x38820,0x38820,0x6000,0x38000,0x1c0,0x180000,0x38820,0x38820,0x38820,0x38820,};
   }

  /** Constructor with InputStream. */
  public parser_robot(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public parser_robot(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new parser_robotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public parser_robot(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new parser_robotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public parser_robot(parser_robotTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(parser_robotTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[25];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 10; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 25; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}