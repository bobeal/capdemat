package fr.capwebct.capdemat.plugins.paymentproviders.payline.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.AccessController;
import java.util.StringTokenizer;

import sun.security.action.GetPropertyAction;

/** Demande de paiement Payline par API
  *  @author EXPERIAN
  *  @version 1.6
  */
public class PLPASSAPI {

        static String dfltEncName = (String) AccessController.doPrivileged(new GetPropertyAction("file.encoding"));

        /* Valeur de sortie en erreur de la demande */
        static int OK = 0;
        static int MONTANT_ABSENT = 1;
        static int DEVISE_MONTANT_ABSENT = 2;
        static int REFERENCE_ABSENTE = 3;
        static int URLRETOUR_ABSENT = 8;
        static int CODE_FONCTION_PORTEF_ABSENT = 30;
        static int CODE_ACCES_PORTEF_ABSENT = 31;

        static int CONNEXION_PLCO_ECHOUEE = 10;
        static int ECHEC_ENVOI_DEMANDE = 12;
        static int ECHEC_RECEPTION_REPONSE = 13;
        static int ECHEC_TRAITEMENT_DEMANDE = 20;

        static String EOL = new String("\n");

        static String CODE_RESULTAT_FIELD = new String("code_res");
        static String SESSIONID_FIELD = new String("sessionid");
        static String CGIS1URL_FIELD = new String("url_cgis1");

        /* Parametres du constructeur */
        String Adr_PLCO = null;
        int Port_PLCO = 0;

        Socket socket = null;
        static int NB_PARAM_MAX = 20;
        BufferedOutputStream os = null;
        BufferedInputStream is = null;

        /* Parametres de declenchement */
        String montant = null;
        String devise_montant = null;
        String reference = null;
        String urlretour = null;
        String personnalisation = null;
        String langue = null;
        String devise = null;
        String code_fonction_portef = null;
        String code_acces_portef = null;
        String mot_passe_portef = null;
        String card_type = null;
        String trans_type = null;
        String coderef_contratcb_comm = null;
        String liste_parametres_commercant = null;

        /* Parametres de retour */
        int code_result = -1;
        int code_erreur = 0;
        String cgis1url = null;
        String erreur = null;
        String erreurlabel = null;
        String sessionid = null;

        /** Constructeur
         *  @param Adr_PLCO String contenant l'adresse du serveur PLCO
         *  @param Port_PLCO int contenant le numero de port du serveur PLCO
         */
        public PLPASSAPI(String newAdr_PLCO, int newPort_PLCO) {
                Adr_PLCO = newAdr_PLCO;
                Port_PLCO = newPort_PLCO;
        }

        /** Initialisation montant paiement
          *  @param montant String contenant le montant au format montant entier , eventuellement suivi d'un point et suivi des centimes (Exemple : 123.10)
          */
        public void setmontant(String newmontant) {
                montant = newmontant;
        }

        /** Initialisation devise du montant du paiement
          *  @param devise_montant String contenant le code alphanumerique de la devise du montant (Exemple : EUR)
          */
        public void setdevise_montant(String newdevise_montant) {
                devise_montant = newdevise_montant;
        }

        /** Initialisation reference commande
          *  @param reference String contenant la reference commerciale de la commande
          */
        public void setreference(String newreference) {
                reference = newreference;
        }

        /** Initialisation urlretour commercant
          *  @param urlretour String contenant l'URL de retour chez le commercant
          */
        public void seturlretour(String newurlretour) {
                urlretour = newurlretour;
        }

        /** Initialisation code personnalisation
          *  @param personnalisation String contenant le code personnalisation des pages Payline
          */
        public void setpersonnalisation(String newpersonnalisation) {
                personnalisation = newpersonnalisation;
        }

        /** Initialisation code langue
          *  @param langue String contenant le code langue des pages Payline
          */
        public void setlangue(String newlangue) {
                langue = newlangue;
        }

        /** Initialisation devise
          *  @param devise String contenant les codes devises (séparés par des virgules) pour l'affichage du montant converti
          */
        public void setdevise(String newdevise) {
                devise = newdevise;
        }

        /** Initialisation card_type
          *  @param card_type String contenant la marque de carte utilisée pour le paiement
          */
        public void setcard_type(String newcard_type) {
                card_type = newcard_type;
        }

        /** Initialisation trans_type
          *  @param trans_type String contenant le protocole utilise pour le paiement
          */
        public void settrans_type(String newtrans_type) {
                trans_type = newtrans_type;
        }

        /** Initialisation coderef_contratcb_comm
          *  @param coderef_contratcb_comm String contenant le code reference contrat carte commercant a utiliser au paiement (sur 2 chiffres)
          */
        public void setcoderef_contratcb_comm(String newcoderef_contratcb_comm) {
                coderef_contratcb_comm = newcoderef_contratcb_comm;
        }

        /** Initialisation code_fonction_portef
          *  @param code_fonction_portef String contenant le code fonction pour l'utilisation du portefeuille
          */
        public void setcode_fonction_portef(String newcode_fonction_portef) {
                code_fonction_portef = newcode_fonction_portef;
        }

        /** Initialisation code_acces_portef
          *  @param code_acces_portef String contenant le code accès pour l'utilisation du portefeuille
          */
        public void setcode_acces_portef(String newcode_acces_portef) {
                code_acces_portef = newcode_acces_portef;
        }

        /** Initialisation mot_passe_portef
          *  @param mot_passe_portef String contenant le mot de passe pour l'utilisation du portefeuille
          */
        public void setmot_passe_portef(String newmot_passe_portef) {
                mot_passe_portef = newmot_passe_portef;
        }

        /** Initialisation parametres specifiques commercant
          *  @param nom_parametre String contenant le nom du parametre
          *  @param valeur_parametre String contenant la valeur du parametre
          */
        public boolean setparametre_commercant(String nom_parametre, String valeur_parametre) {
                if (estAlphaNum(nom_parametre)) {
                        if (liste_parametres_commercant != null)
                                liste_parametres_commercant += nom_parametre + "=" + encode(valeur_parametre) + "&";
                        else
                                liste_parametres_commercant = new String(nom_parametre + "=" + encode(valeur_parametre) + "&");
                        return (true);
                } else
                        return (false);
        }

        /** Demande de paiement Payline
                *  @return resultat de la demande de paiement (0 si OK)
                */
        public int Demande_Paiement() {

                /** Generation de la liste des donnees a envoyer **/
                URLEncoder urlEncoder;
                String donnees = new String();
                String ack = new String();

                String[] param = new String[NB_PARAM_MAX];
                String[] value = new String[NB_PARAM_MAX];

                // On precise le service source mais pas le service dest :
                // Service de paiement par defaut
                donnees = "src_program=PLPASSAPI&";

                if (montant != null)
                        donnees += "montant=" + encode(montant) + "&";
                else
                        return (MONTANT_ABSENT);

                if (devise_montant != null)
                        donnees += "devise_montant=" + encode(devise_montant) + "&";
                else
                        return (DEVISE_MONTANT_ABSENT);

                if (reference != null)
                        donnees += "reference=" + encode(reference) + "&";
                else
                        return (REFERENCE_ABSENTE);

                if (card_type != null)
                        donnees += "card_type=" + encode(card_type) + "&";

                if (trans_type != null)
                        donnees += "trans_type=" + encode(trans_type) + "&";

                if (coderef_contratcb_comm != null)
                        donnees += "coderef_contratcb_comm=" + encode(coderef_contratcb_comm) + "&";

                if (personnalisation != null)
                        donnees += "personnalisation=" + encode(personnalisation) + "&";

                if (devise != null)
                        donnees += "devise=" + encode(devise) + "&";

                if (langue != null)
                        donnees += "langue=" + encode(langue) + "&";

                if (code_fonction_portef != null)
                        donnees += "code_fonction_portef=" + encode(code_fonction_portef) + "&";

                if (code_acces_portef != null)
                        donnees += "code_acces_portef=" + encode(code_acces_portef) + "&";

                if (mot_passe_portef != null)
                        donnees += "mot_passe_portef=" + encode(mot_passe_portef) + "&";

                if (urlretour != null)
                        donnees += "urlretour=" + encode(urlretour) + "&";
                else
                        return (URLRETOUR_ABSENT);

                if (liste_parametres_commercant != null)
                        donnees += liste_parametres_commercant + "&";

                donnees += EOL;

                try {
                        socket = new Socket(Adr_PLCO, Port_PLCO);
                } catch (IOException e) {
                        return (CONNEXION_PLCO_ECHOUEE);
                }

                try {
                        // creation canal de communication en sortie
                        os = new BufferedOutputStream(socket.getOutputStream());
                        // creation canal de communication en entree
                        is = new BufferedInputStream(socket.getInputStream());
                } catch (Exception e) {
                        return (ECHEC_ENVOI_DEMANDE);
                }

                if (send(donnees.getBytes(), os) != 0)
                        return (ECHEC_ENVOI_DEMANDE);

                try {
                        ack = new String(receive(is));
                        if (ack == null) {
                                return (ECHEC_RECEPTION_REPONSE);
                        }
                } catch (Exception e) {
                        return (ECHEC_RECEPTION_REPONSE);
                }

                analyse(param, value, ack);

                String code_result_S = getValue(param, value, CODE_RESULTAT_FIELD);
                if (code_result_S.equals("")) {
                        return (ECHEC_RECEPTION_REPONSE);
                }
                Integer code_result_I = new Integer(code_result_S);
                code_result = code_result_I.intValue();

                String erreur_S = getValue(param, value, "erreur");

                URLDecoder urlDecoder = new URLDecoder();

                if (code_result_S.equals("0")) {
                        /** Recuperation de l'url de Payline **/
                        try {
                                cgis1url = decode(getValue(param, value, CGIS1URL_FIELD));
                        } catch (Exception e) {
                                cgis1url = getValue(param, value, CGIS1URL_FIELD);
                        }
                        /** Extraction du sessionid de Payline de l'URL : *
                          * On le recupere dans les parametres de l'url**/
                        StringTokenizer st = new StringTokenizer(cgis1url, "?");
                        st.nextToken();
                        String params_cgis1url = new String(st.nextToken());
                        analyse(param, value, params_cgis1url);

                        sessionid = getValue(param, value, SESSIONID_FIELD);
                        return (OK);
                } else {
                        try {
                                erreur = decode(getValue(param, value, "erreur"));
                                erreurlabel = decode(getValue(param, value, "erreurlabel"));
                        } catch (Exception e) {
                                erreurlabel = new String("erreur inconnue");
                        }
                        return (ECHEC_TRAITEMENT_DEMANDE);
                }

        }

        /** Demande de modification ou suppression d'un portefeuille
                *  @return resultat de la demande (0 si OK)
                */
        public int Demande_Gestion_Portefeuille() {

                /** Generation de la liste des donnees a envoyer **/
                URLEncoder urlEncoder;
                String donnees = new String();
                String ack = new String();

                String[] param = new String[NB_PARAM_MAX];
                String[] value = new String[NB_PARAM_MAX];

                // On precise le service source mais pas le service dest :
                // Service de paiement par defaut
                donnees = "src_program=PLPASSAPI&service=PL_GESTION_PORTEF_SERVICE&";

                if (personnalisation != null)
                        donnees += "personnalisation=" + encode(personnalisation) + "&";

                if (langue != null)
                        donnees += "langue=" + encode(langue) + "&";

                if (code_fonction_portef != null)
                        donnees += "code_fonction_portef=" + encode(code_fonction_portef) + "&";
                else
                        return (CODE_FONCTION_PORTEF_ABSENT);

                if (code_acces_portef != null)
                        donnees += "code_acces_portef=" + encode(code_acces_portef) + "&";
                else
                        return (CODE_ACCES_PORTEF_ABSENT);

                if (mot_passe_portef != null)
                        donnees += "mot_passe_portef=" + encode(mot_passe_portef) + "&";

                if (urlretour != null)
                        donnees += "urlretour=" + encode(urlretour) + "&";
                else
                        return (URLRETOUR_ABSENT);

                if (liste_parametres_commercant != null)
                        donnees += liste_parametres_commercant + "&";

                donnees += EOL;

                try {
                        socket = new Socket(Adr_PLCO, Port_PLCO);
                } catch (IOException e) {
                        return (CONNEXION_PLCO_ECHOUEE);
                }

                try {
                        // creation canal de communication en sortie
                        os = new BufferedOutputStream(socket.getOutputStream());
                        // creation canal de communication en entree
                        is = new BufferedInputStream(socket.getInputStream());
                } catch (Exception e) {
                        return (ECHEC_ENVOI_DEMANDE);
                }

                if (send(donnees.getBytes(), os) != 0)
                        return (ECHEC_ENVOI_DEMANDE);

                try {
                        ack = new String(receive(is));
                        if (ack == null) {
                                return (ECHEC_RECEPTION_REPONSE);
                        }
                } catch (Exception e) {
                        return (ECHEC_RECEPTION_REPONSE);
                }

                analyse(param, value, ack);

                String code_result_S = getValue(param, value, CODE_RESULTAT_FIELD);
                if (code_result_S.equals("")) {
                        return (ECHEC_RECEPTION_REPONSE);
                }
                Integer code_result_I = new Integer(code_result_S);
                code_result = code_result_I.intValue();

                String erreur_S = getValue(param, value, "erreur");

                URLDecoder urlDecoder = new URLDecoder();

                if (code_result_S.equals("0")) {
                        /** Recuperation de l'url de Payline **/
                        try {
                                cgis1url = decode(getValue(param, value, CGIS1URL_FIELD));
                        } catch (Exception e) {
                                cgis1url = getValue(param, value, CGIS1URL_FIELD);
                        }
                        /** Extraction du sessionid de Payline de l'URL : *
                                 * On le recupere dans les parametres de l'url**/
                        StringTokenizer st = new StringTokenizer(cgis1url, "?");
                        st.nextToken();
                        String params_cgis1url = new String(st.nextToken());
                        analyse(param, value, params_cgis1url);

                        sessionid = getValue(param, value, SESSIONID_FIELD);
                        return (OK);
                } else {
                        try {
                                erreur = decode(getValue(param, value, "erreur"));
                                erreurlabel = decode(getValue(param, value, "erreurlabel"));
                        } catch (Exception e) {
                                erreurlabel = new String("erreur inconnue");
                        }
                        return (ECHEC_TRAITEMENT_DEMANDE);
                }

        }

        /** Recuperation code resultat
                *  @return resultat de la demande de paiement (0 si OK, sinon -1)
          */
        public int getcode_result() {
                return (code_result);
        }

        /** Recuperation URL de paiement
                *  @return URL de paiement Payline
          */
        public String geturlPayline() {
                return (cgis1url);
        }

        /** Recuperation sessionid
                *  @return identifiant session Payline
          */
        public String getsessionid() {
                return (sessionid);
        }

        /** Recuperation code erreur
                *  @return code erreur
          */
        public String geterreur() {
                return (erreur);
        }

        /** Recuperation libelle erreur
                *  @return libelle erreur
          */
        public String geterreurlabel() {
                return (erreurlabel);
        }

        public String geterreurlabel(int code) {
                if (code == OK)
                        return "";
                if (code == MONTANT_ABSENT)
                        return "Missing amount";
                if (code == DEVISE_MONTANT_ABSENT)
                        return "Missing currency";
                if (code == REFERENCE_ABSENTE)
                        return "Missing reference";
                if (code == URLRETOUR_ABSENT)
                        return "Missing return Url";
                if (code == CODE_FONCTION_PORTEF_ABSENT)
                        return "Missing fonction code";
                if (code == CODE_ACCES_PORTEF_ABSENT)
                        return "Missing access code";
                if (code == CONNEXION_PLCO_ECHOUEE)
                        return "Failed to connect to PLCO";
                if (code == ECHEC_ENVOI_DEMANDE)
                        return "Failed to send request";
                if (code == ECHEC_RECEPTION_REPONSE)
                        return "Failed to receive response";
                if (code == ECHEC_TRAITEMENT_DEMANDE)
                        return erreurlabel;

                return "";

        }

        /** envoi un tableau de byte sur la socket
         *  @param data tableau de byte envoye
         */
        int send(byte[] data, BufferedOutputStream os) {
                try {
                        os.write(data);
                        os.flush();
                        return (0);
                } catch (IOException ex) {
                        return (-1);
                }
        }

        /** recoit un tableau de byte de la socket
         *  @return tableau de byte recu
         */

        private byte[] receive(BufferedInputStream is) throws Exception {
                int bread = 0;
                int count = 0;
                byte[] buftmp = null;
                byte message;
                byte[] trameRecu = null;
                try {
                        while (((bread = is.read()) != -1) && (EOL.getBytes()[0] != (byte) bread)) {
                                message = (byte) bread;
                                count++;
                                buftmp = new byte[count];

                                for (int i = 0; i < count - 1; i++)
                                        buftmp[i] = trameRecu[i];

                                buftmp[count - 1] = message;

                                trameRecu = new byte[count];

                                for (int i = 0; i < buftmp.length; i++)
                                        trameRecu[i] = buftmp[i];
                        }

                } catch (IOException e) {
                        return trameRecu;
                }
                return trameRecu;
        }

        static private void analyse(String[] param, String[] value, String service) {
                boolean b = true;
                try {

                        StringTokenizer st = new StringTokenizer(service, "&");
                        int i = 0;

                        while (b) {
                                String tok = new String();
                                // recupere le code service
                                tok = st.nextToken();
                                token(param, value, tok, i);
                                i++;
                        }
                } catch (java.util.NoSuchElementException e) {
                        b = false;
                }
        }

        private String getValue(String[] param, String[] value, String _param) {
                int i = 0;
                while ((i < NB_PARAM_MAX) && (param[i] != null)) {
                        if (param[i].equals(_param)) {
                                return value[i];
                        }
                        i++;
                }
                return "";
        }

        private static void token(String[] param, String[] value, String ligne, int i) {
                try {
                        StringTokenizer st = new StringTokenizer(ligne, "=");
                        String tok = new String();
                        param[i] = new String(st.nextToken());
                        value[i] = new String(st.nextToken());
                } catch (java.util.NoSuchElementException e) {
                        value[i] = new String();
                }
        }

        private boolean estAlphaNum(String data) {

                boolean b = true;
                int i = 0;
                while (b) {
                        try {
                                b = Character.isLetterOrDigit(data.charAt(i));
                                if (data.charAt(i) == '_')
                                        b = true;
                                i++;
                        } catch (StringIndexOutOfBoundsException e) {
                                b = false;
                        }

                }
                if (i == data.length()) {
                        return (true);
                } else
                        return (false);
        }

        private String encode(String value) {
                try {
                        return URLEncoder.encode(value, dfltEncName);
                } catch (UnsupportedEncodingException e) {
                }
                return value;
        }

        private String decode(String value) {
                try {
                        return URLDecoder.decode(value, dfltEncName);
                } catch (UnsupportedEncodingException e) {
                }
                return value;
        }

}
