package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import kakao.localSearch.category.CategoryLocalSearch;
import kakao.localSearch.category.dto.LocalCategoryDocumentDTO;
import kakao.localSearch.category.dto.LocalCategoryRequestDTO;
import kakao.localSearch.category.dto.LocalCategoryResponseDTO;
import kakao.localSearch.keyword.KewordLocalSearch;
import kakao.localSearch.keyword.dto.LocalKeywordDocumentDTO;
import kakao.localSearch.keyword.dto.LocalKeywordRequestDTO;
import kakao.localSearch.keyword.dto.LocalKeywordResponseDTO;

public class MainApp {
	/*
	 * categoryGroupCode.properties,
	 * kakaoAPI.properties
	 * 가 프로젝트 바로 밑 경로에 존재해야하고,
	 * pom.xml에 gson이 추가되어야함.
	 * 
	 */

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//키워드 로컬서치
		KewordLocalSearch kewordLocalSearch = new KewordLocalSearch();
		LocalKeywordResponseDTO responseDTO = kewordLocalSearch.sendKewordQuery(new LocalKeywordRequestDTO("홍대역"));
		
		System.out.println(responseDTO.getMeta());
		for(LocalKeywordDocumentDTO dto : responseDTO.getDocuments()) {
			System.out.println(dto);
		}
		
		//카테고리 로컬 서치
		CategoryLocalSearch categoryLocalSearch = new CategoryLocalSearch();
		LocalCategoryRequestDTO requestDTO = new LocalCategoryRequestDTO();
		requestDTO.setCategory_group_code("음식점");//그룹코드 참조
		LocalCategoryResponseDTO categoryResponseDTO = categoryLocalSearch.sendCategoryQuery(requestDTO);
		System.out.println(categoryResponseDTO.getMeta());
		for(LocalCategoryDocumentDTO dto : categoryResponseDTO.getDocuments()) {
			System.out.println(dto);
		}
	}
}
