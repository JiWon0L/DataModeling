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
        String clientId = "";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "";//애플리케이션 클라이언트 시크릿값";
        try 
        {
        	// 검색어
            String text = URLEncoder.encode("선문대학교", "UTF-8");
//            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
            
            // 오픈 API 호출 주소
            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            
            // 오픈 API 호출 준비
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            // 호출 및 결과 받기
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) 
            { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            }
            else 
            {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
            }
            
            // 결과 값 저장: 1줄로 구성된 XML
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            // 결과 값을 XML을 다룰 수 있는 형태로 변환
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = df.newDocumentBuilder();
            Document document =  builder.parse(new InputSource(new StringReader(response.toString())));
            
            // 개행이 반영된 문자열로 변환
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(document), new StreamResult(sw));
            
            // 결과 확인
            System.out.println(sw.toString());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
}
