package fr.cg95.cvq.fo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** PLPASS n'est qu'une passerelle entre Payline et PLCO.
 *  Elle permet la transmission du Parametre Code Service.
 *  Elle recupere les parametres POST ou GET
 *       ouvre la socket vers PLCO
 *       envoi les parametres recus
 *       attends la reponse de PLCO
 *       envoi la reponse au client
 */
public class plpass extends HttpServlet {

   /** version de la classe */
   static String version= new String("1.d");

	static String ADR_IP_PLCO= "127.0.0.1";
	static int NUM_PORT_PLCO= 4444;

  static String EOL= new String("\n");

  // Timeout socket en ms
  static int TIMEOUT = 45000;

   static int NB_PARAM_MAX=20;


 /** initialise la servlet PLPASS
  */
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
      String [] param= new String [NB_PARAM_MAX];
      String [] value= new String [NB_PARAM_MAX];
      /** socket entre client serveur */
      Socket socket = null;
      /** canal de connexion en sortie */
      BufferedOutputStream os = null;
      /** canal de connexion en entree */
      BufferedInputStream is = null;
    try {

      //DEBUG
      // Thread th = Thread.currentThread();
      // int thname = th.hashCode();
      // FileOutputStream log= new FileOutputStream("/tmp/"+thname+".log");

      // Création du canal de lecture inData de type DataInputStream
      DataInputStream inData = new DataInputStream(requete.getInputStream());
      reponse.setContentType("application/octet-stream");

      // Création du canal d'ecriture outData de type DataOutputStream
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      DataOutputStream outData = new DataOutputStream(byteOut);
      URLEncoder urlEncoder;
      String donnees = new String();

      // Lecture sur le canal de lecture de la fonction à exécuter
      for (Enumeration e = requete.getParameterNames();e.hasMoreElements();) {
        String tmp = new String ((String)e.nextElement());
        donnees = donnees+tmp+"="+URLEncoder.encode (requete.getParameter(tmp))+"&";
      }
      // Marquage appel par PLPASS pour rendre impossible l'accès à certaines fonctions
      String selection = "src_program=PLPASS&"+donnees+"\n";

      //DEBUG
      // log.write(("Tentative de connexion a PLCO\n").getBytes());
      // connexion a PLCO
      String host = new String(ADR_IP_PLCO);
      // creation socket sur port
      try{
          socket = new Socket(host, NUM_PORT_PLCO);
          socket.setSoTimeout(TIMEOUT);
       } catch  (IOException e) {
         throw new Exception("Connexion a PLCO echouee");
       }


      // creation canal de communication en sortie
      os = new BufferedOutputStream (socket.getOutputStream());
      // creation canal de communication en entree
      is = new BufferedInputStream (socket.getInputStream());


      //DEBUG
      // log.write(("Envoi de la demande a PLCO\n").getBytes());
      // envoi de la demande de payline
      send(selection.getBytes(), os);

      //DEBUG
      // log.write(("Attente acquitement de PLCO\n").getBytes());
      // reception ACK
      String ack = new String(receive(is));

      //DEBUG
      // log.write(("Acquitement recu de PLCO : "+ack+"\n").getBytes());
      //DEBUG
      // log.close();

      analyse(param,value,ack);

      String code_res = getValue( param, value,"code_res");
      if (code_res.equals ("")) {
        throw new Exception("Echec reception reponse");
      }

      if (code_res.equals ("0")) {
   		 String url_cgis1 = getValue( param, value,"url_cgis1");
		 if ( url_cgis1.equals("") ) {
			 // Pas de reroutage http => envoie reponse "ok"
             reponse.setContentType("text/html");
             PrintWriter out = new PrintWriter (reponse.getOutputStream());
             out.println("ok");
             out.close();
	     } else {
			 // Reroutage http
			 URLDecoder urlDecoder;
		     String url_cgis1_dec= URLDecoder.decode (url_cgis1);
             reponse.sendRedirect(url_cgis1_dec);
	     }
      } else {
         String erreurlabel = getValue(param, value,"erreurlabel");
   	     URLDecoder urlDecoder;
   	     String erreurlabel_dec = URLDecoder.decode (erreurlabel);
         reponse.setContentType("text/html");
         PrintWriter out = new PrintWriter (reponse.getOutputStream());
         out.println(erreurlabel_dec);
         out.close();
       }
     } catch  (Exception e) {
         PrintWriter out = new PrintWriter (reponse.getOutputStream());
         out.println("<html>");
         out.println("<head><title>PLPASS </title></head>");
         out.println("<body><CENTER><H3>Erreur PLPASS</H3>");
         out.println("<BR><BR>"+e);
         out.println("</CENTER></body></html>");
         out.close();

     }
  }

 /** recupere la requete HTTP POST
  *  @param requete requete du client
  *  @param reponse reponse au client
  */
  public void doPost(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
      String [] param= new String [NB_PARAM_MAX];
      String [] value= new String [NB_PARAM_MAX];

    doGet(requete, reponse);
  }

 /** envoi un tableau de byte sur la socket
  *  @param data tableau de byte envoye
  */
  void send (byte [] data, BufferedOutputStream os) throws Exception {
      try {
          os.write (data);
          os.flush();
      } catch (IOException ex) {
          throw new Exception("Echec envoi donnees");
      }
  }


 /** recoit un tableau de byte de la socket
  *  @return tableau de byte recu
  */

  public byte [] receive (BufferedInputStream is) throws Exception   {
     int bread = 0;
     int count = 0;
     byte [] buftmp = null;
     byte message;
     byte [] trameRecu = null;
     try {
          while ( ( (bread=is.read()) != -1) && ( EOL.getBytes()[0] != (byte)bread ) ) {
            message = (byte)bread;
            count++;
            buftmp = new byte[count];

            for (int i = 0; i<count-1; i++)
              buftmp[i] = trameRecu[i];

            buftmp[count-1] = message;

            trameRecu = new byte[count];

            for (int i = 0; i<buftmp.length; i++)
              trameRecu[i] = buftmp[i];
          }

     } catch (IOException e){
       return trameRecu;
     }
     return trameRecu;
  }


  static  public void analyse (String[] param, String[] value,String service) {
    boolean b=true;
    try {

      StringTokenizer st = new StringTokenizer(service, "&");
      int i = 0;

      while (b) {
        String tok = new String();
        // recupere le code service
        tok = st.nextToken();
        System.out.println(i+":"+tok);
        token ( param, value,tok, i);
        i++;
      }
    }
    catch(java.util.NoSuchElementException e) {
      b=false;
    }
  }


  static public String getValue (String[] param, String[] value,String _param) {
    int i =0;
    while ( ( i < NB_PARAM_MAX ) && ( param[i] != null ) ) {
        if (param[i].equals(_param)) {
          return value [i];
        }
        i++;
    }
    return "";
  }


 static void token (String[] param, String[] value,String ligne, int i) {
    try {
      StringTokenizer st = new StringTokenizer(ligne,"=");
      String tok = new String();
      param [i]= new String(st.nextToken());
      value [i]= new String(st.nextToken());
    }
    catch(java.util.NoSuchElementException e) {
      value [i] = new String();
    }
  }


}
