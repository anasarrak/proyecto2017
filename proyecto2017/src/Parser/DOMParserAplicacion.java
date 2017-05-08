/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;


import UML.Parte;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
/**
 *
 * @author Aroa
 */
public class DOMParserAplicacion {
    //No generics
    
    private List partes;
    
    private Document dom;
      Element rootElement;
    public DOMParserAplicacion() {
        //create a list to hold the notice objects
        partes = new ArrayList();    
    }
    
    public void runExample() throws ParseException {
//Coger datos SQL mySQL 
        
        
        //parse the xml file and get the dom object
        creardocxml();

        //get each notice element and create a Noticia object
        parseDocument();

        //Iterate through the list and print the data
        printData();
    }

    private void creardocxml() {
        try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                dom = docBuilder.newDocument();
		rootElement= dom.createElement("listapartes");
		dom.appendChild(rootElement);
            } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
            }
    }
     private void createDOMTree() {   
        Iterator it = partes.iterator();
        while (it.hasNext()) {
            Parte p = (Parte) it.next();
            //For each Contact object  create <contacto> element and attach it to root
           
            rootElement.appendChild(createParteElement(p));
        }
    }
     private Element createParteElement(Parte p) {
        String textoAuxiliar;
        Text nombreText;
        Element Parte = dom.createElement("parte");
        
        //create nombre element and nombre text node and attach it to contactElement
        Element idParte = dom.createElement("idparte");
        textoAuxiliar= String.valueOf(p.getIdParte());
        nombreText = dom.createTextNode(textoAuxiliar);
        idParte.appendChild(nombreText);
        Parte.appendChild(idParte);

        //create apellidos element and apellidos text node and attach it to contactElement
        Element kmInicio = dom.createElement("kminicio");
        textoAuxiliar= String.valueOf(p.getKmInicio());
        nombreText = dom.createTextNode(textoAuxiliar);
        kmInicio.appendChild(nombreText);
        Parte.appendChild(kmInicio);
        
        //create nombre element and nombre text node and attach it to contactElement
        Element kmFin = dom.createElement("kmfin");
        textoAuxiliar= String.valueOf(p.getIdParte());
        nombreText = dom.createTextNode(textoAuxiliar);
        kmFin.appendChild(nombreText);
        Parte.appendChild(kmFin);
        
        //create nombre element and nombre text node and attach it to contactElement
        Element gasto = dom.createElement("gasto");
        textoAuxiliar= String.valueOf(p.getIdParte());
        nombreText = dom.createTextNode(textoAuxiliar);
        gasto.appendChild(nombreText);
        Parte.appendChild(gasto);
        
        //create nombre element and nombre text node and attach it to contactElement
        Element incidencia = dom.createElement("incidencia");
        textoAuxiliar= String.valueOf(p.getIdParte());
        nombreText = dom.createTextNode(textoAuxiliar);
        incidencia.appendChild(nombreText);
        Parte.appendChild(incidencia);
        
        //create nombre element and nombre text node and attach it to contactElement
        Element estado = dom.createElement("estado");
        textoAuxiliar= String.valueOf(p.getEstado());
        nombreText = dom.createTextNode(textoAuxiliar);
        estado.appendChild(nombreText);
        Parte.appendChild(estado);
      
        return Parte;
    }

    private void parseDocument() throws ParseException {
        //get the root elememt
        Element docEle = dom.getDocumentElement();

        //get a nodelist of <noticia> elements
        NodeList nl = docEle.getElementsByTagName("partes");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {

                //get the libro element
                Element el = (Element) nl.item(i);

                //get the parte object
                Parte p = getParte (el);

                //add it to list 
                partes.add (p); 
            }
        }
    }

    /**
     * I take an notice element and read the values in, create an Noticia
     * object and return it
     *
     * @param notEl
     * @return
     */
   
   private Parte getParte(Element notEl) throws ParseException {       
           int idParte = Integer.parseInt(notEl.getAttribute("id"));        
           int kmIni = Integer.parseInt(getTextValue(notEl, "km Inicio"));
           int kmFin = Integer.parseInt(getTextValue(notEl, "km Fin"));
           int gasto = Integer.parseInt(getTextValue(notEl, "gasto"));
           String incidencia = getTextValue(notEl, "incidencias");
           String estado = getTextValue(notEl, "estado");
           
           
           Parte p = new Parte (idParte,null, kmIni, kmFin, estado, gasto, gasto, gasto, gasto, kmIni, gasto, null, null);
           return p;
    }

    
    /**
     * I take a xml element and the tag name, look for the tag and get the text
     * content i.e for <item><title>John....</title><item> xml snippet if the
     * Element points to notice node and tagName is title I will return John
     *
     * @param ele
     * @param tagName
     * @return
     */
    private String getTextValue(Element ele, String tagName) {
        String textVal = null;

        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
           
        }
        return textVal;
    }

    /**
     * Iterate through the list and print the content to console
     */
    private void printData() {
       
        System.out.println("Número de partes " + partes.size());        
        System.out.println("\nDetalles del parte\n");        
        System.out.println("\n------------------------------------------------");
        Iterator it = partes.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        } 
        }
    }
    

      

