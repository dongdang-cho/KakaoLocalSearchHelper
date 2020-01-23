# KakaoLocalSearchHelper
Gson 라이브러리를 활용하여, 카카오 로컬 검색 API를 사용할 준비를 해주는 소스입니다.  
카카오 로컬 서치 URL : https://developers.kakao.com/docs/restapi/local 
    
### 1. 카테고리로 장소 검색 
- API 요청 시 필요 파라미터 값(LocalCategoryRequestDTO로 대응됨)  
<img width="400" src = "https://user-images.githubusercontent.com/60133320/73011921-99681200-3e58-11ea-8481-ce8f46eb86b0.png"/>  

- API 응답 시 받는 JSON 객체
LocalCategoryResponseDTO : 응답 받는 종합 객체
  - LocalCategoryMetaDTO: 응답받은 문서의 메타 정보가 담김
     - LocalCategoryMetaSameNameDTO : 질의어에 인식한 결과값과 비슷한 정보들이 담김
  - LocalCategoryDocumentDTO : 장소의 정보들이 담김  
  
<img width="400" src = "https://user-images.githubusercontent.com/60133320/73012406-9e799100-3e59-11ea-9c82-4d01b27926a8.png"/>

### 2. 키워드로 장소 검색
- API 요청 시 필요 파라미터 값(LocalKeywordRequestDTO로 대응됨)
<img width="400" src = "https://user-images.githubusercontent.com/60133320/72920289-56d90380-3d8c-11ea-8800-34fe5c70f6c5.png"/>

- API 응답 시 받는 JSON 객체
LocalKeywordResponseDTO : 응답 받는 종합 객체
  - LocalKeywordMetaDTO : 응답받은 문서의 메타 정보가 담김
     - LocalKeywordMetaSameNameDTO : 질의어에 인식한 결과값과 비슷한 정보들이 담김
  - LocalKeywordDocumentDTO : 장소의 정보들이 담김  

<img width="400" src ="https://user-images.githubusercontent.com/60133320/72920914-9bb16a00-3d8d-11ea-9211-bcf8ea72092f.png"/>

### 3. 카테고리 그룹 코드
- 업종별로 코드명을 부여한 리스트
<img width="400" src = "https://user-images.githubusercontent.com/60133320/72920579-f1394700-3d8c-11ea-8724-2fe4c9119942.png"/>

### 4. 쿼리 요청 및 응답
현재 구현된 Search 클래스는 KakaoAPIService.java를 상속 받고 있다.  
KakaoAPIService는 키와 URL을 로드하고 관리하는 역할을 하며, 쿼리를 보내고 받는 urlGetSend 메소드를 가지고 있다.  
매개변수는 쿼리를 보낼 urlString 변수와 응답 받은 객체를 저장할 a변수가 있다.   
<pre>
<code>
protected Object urlGetSend(String urlString,Class a) throws IOException {

		     /*
        * 쿼리 진행 순서
        * 1. 메소드 형식 및  요구 사항 설정
        * 2. JSON 요청 및 응답
        * 3. 응답 내용 읽기
        * 4. GSON을 통하여 DTO 객체와 매칭
        */
		//1
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json; ");
        con.setRequestProperty("Authorization","KakaoAK "+restKey.trim());
        
        //2
        con.setDoInput(true);
        int responseCode=con.getResponseCode();
        
        //3
        BufferedReader br;
        if(responseCode==200)  // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        else throw new IOException(responseCode+" : "+con.getResponseMessage());

        //4
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = br.readLine()) != null) response.append(inputLine);
        br.close();
        return new Gson().fromJson(response.toString(),a);
	}
</code>
 </pre>

### 5. 결과

- 키워드 검색 결과
<img width="600" src="https://user-images.githubusercontent.com/60133320/72922617-b0dbc800-3d90-11ea-934f-e39412d5c377.png"/>

# 설치 방법
cloneURL : https://github.com/dongdang-cho/KakaoLocalSearchHelper.git  
ZIP 파일을 다운 받아, 이클립스에 프로젝트를 import 하거나, cloneURL을 이용하여 git import 기능을 사용한다.

# 사용 예제

### 1. 카테고리로 장소 검색 
MainApp.java의 main 메소드가 시작점이 된다.  
1) LocalCategoryRequestDTO에 값을 저장하여 api 요청을 준비한다.  
2) CategoryLocalSearch..sendCategoryQuery 메소드로 api 요청하고, LocalCategoryResponseDTO를 반환 받는다.  

<pre>
<code>
	//카테고리 로컬 서치
	CategoryLocalSearch categoryLocalSearch = new CategoryLocalSearch();
	LocalCategoryRequestDTO requestDTO = new LocalCategoryRequestDTO();
	requestDTO.setCategory_group_code("음식점");//그룹코드 참조
	LocalCategoryResponseDTO categoryResponseDTO = categoryLocalSearch.sendCategoryQuery(requestDTO);
	System.out.println(categoryResponseDTO.getMeta());
	for(LocalCategoryDocumentDTO dto : categoryResponseDTO.getDocuments()) {
		System.out.println(dto);
	}
</code>
</pre>

### 2. 키워드로 장소 검색
MainApp.java의 main 메소드가 시작점이 된다.  
1) LocalKeywordRequestDTO에 값을 저장하여 api 요청을 준비한다.
2) KewordLocalSearch의 sendKewordQuery 메소드로 api 요청하고, LocalKeywordResponseDTO를 반환 받는다.

<pre>
 <code>
  KewordLocalSearch kewordLocalSearch = new KewordLocalSearch();
  LocalKeywordResponseDTO responseDTO = kewordLocalSearch.sendKewordQuery(new LocalKeywordRequestDTO("홍대역"));

  System.out.println(responseDTO.getMeta());
  for(LocalKeywordDocumentDTO dto : responseDTO.getDocuments()) {
   System.out.println(dto);
  }
 </code>
</pre>
# 개발 환경 설정 방법

### 1. pom.xml 확인  
 본 프로젝트는 MavenProject로 구성되어 있으며, API 통신을 위하여, GSON 라이브러리를 사용하고 있다.
깃 허브에 pom.xml까지 업로드하였으나, GSON이 추가되어 있는 지 확인하기 바란다.

    <dependencies>
      <dependency> 
        <groupId>com.google.code.gson</groupId> 
        <artifactId>gson</artifactId> 
        <version>2.8.6</version> 
       </dependency>
    </dependencies>

### 2. kakaoAPI.properties에 키 입력.
 kakaoAPI.properties는 카카오에서 발급받은 앱키와 API URL 정보를 저장하는 파일이다.
 해당 파일의 자신의 어플리케이션의 앱키를 입력해야 한다.(restKey만 입력해도 무방하다.) 

    nativeKey=
    restKey=
    javaScriptKey=
    adminKey=

    localKewordSearchUrl=https://dapi.kakao.com/v2/local/search/keyword.json?
    localCategorySearchUrl=https://dapi.kakao.com/v2/local/search/category.json?

# 라이센스
   GNU LESSER GENERAL PUBLIC LICENSE version 3


