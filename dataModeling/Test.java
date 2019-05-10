package kr.ac.sunmoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Test 
{
	public static void main(String[] args) {
        String clientId = "";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
        String clientSecret = "";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
        try 
        {
        	// �˻���
            String text = URLEncoder.encode("�������б�", "UTF-8");
//            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json ���
            
            // ���� API ȣ�� �ּ�
            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml ���
            URL url = new URL(apiURL);
            
            // ���� API ȣ�� �غ�
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            // ȣ�� �� ��� �ޱ�
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) 
            { // ���� ȣ��
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            }
            else 
            {  // ���� �߻�
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
            }
            
            // ��� �� ����: 1�ٷ� ������ XML
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            // ��� ���� XML�� �ٷ� �� �ִ� ���·� ��ȯ
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = df.newDocumentBuilder();
            Document document =  builder.parse(new InputSource(new StringReader(response.toString())));
            
            // ������ �ݿ��� ���ڿ��� ��ȯ
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(document), new StreamResult(sw));
            
            // ��� Ȯ��
            System.out.println(sw.toString());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
}
