package kakao.localSearch.category;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;

import kakao.KakaoAPIService;
import kakao.localSearch.category.dto.LocalCategoryRequestDTO;
import kakao.localSearch.category.dto.LocalCategoryResponseDTO;

/**
 * <strong>지역 검색 클래스</strong>
 * <pre>키워드 검색과 카테고리 검색 제공</pre>
 * <pre>categoryGroupCode.properties 파일 필요</pre>
 * 
 * @author dongdang
 * 
 */
public class CategoryLocalSearch extends KakaoAPIService {
	private final String categoryGroupCodes = "categoryGroupCode.properties"; //지도 카테고리 정보가 담긴 파일명
	private Properties codeFile; //카데고리 정보가 담긴 객체

	/** <strong>기본 생성자</strong><pre> 카테고리 코드가 담긴 파일을 읽음</pre> */
	public CategoryLocalSearch() throws FileNotFoundException, IOException {
		super();
		codeFile = new Properties();
		codeFile.load(new FileInputStream(categoryGroupCodes));
	}
	

	/** 카테고리를 이용한 지역 검색  */
	public LocalCategoryResponseDTO sendCategoryQuery(LocalCategoryRequestDTO requestDTO) throws IOException {	
		/*
		 * 1. KakaoAPIService에서 CategoryURL 가져오기
		 * 2. URL 세팅
		 * 3. urlGetSend 메소드에 파라미터로 전달.
		 */
		//1
		String url = getURL("localCategorySearchUrl");
		//2
		url += requestDTO.toString();		
		//3
		return (LocalCategoryResponseDTO)urlGetSend(url, LocalCategoryResponseDTO.class);
	}	
}
