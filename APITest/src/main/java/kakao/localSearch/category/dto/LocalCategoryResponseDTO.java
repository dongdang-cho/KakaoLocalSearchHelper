package kakao.localSearch.category.dto;

import java.util.List;
/**
 * 카카오 API - 카테고리를 이용한 지역검색 응답 DTO 
 * @author dongdang
 *
 */
public class LocalCategoryResponseDTO {
	/*
	 * meta = 응답정보
	 * documents = 장소 정보들이 담긴 리스트
	 */
	private LocalCategoryMetaDTO meta;
	private List<LocalCategoryDocumentDTO> documents;
	
	/** 기본 생성자 */
	public LocalCategoryResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** 멤버 변수 전체 초기화 */
	public LocalCategoryResponseDTO(LocalCategoryMetaDTO meta, List<LocalCategoryDocumentDTO> documents) {
		super();
		this.meta = meta;
		this.documents = documents;
	}

	
	//getters, setters
	/**
	 * @return the meta
	 */
	public LocalCategoryMetaDTO getMeta() {
		return meta;
	}

	/**
	 * @param meta the meta to set
	 */
	public void setMeta(LocalCategoryMetaDTO meta) {
		this.meta = meta;
	}

	/**
	 * @return the documents
	 */
	public List<LocalCategoryDocumentDTO> getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<LocalCategoryDocumentDTO> documents) {
		this.documents = documents;
	}
	
	//toString 
	@Override
	public String toString() {
		return "LocalCategoryResponseDTO [meta=" + meta + ", documents=" + documents + "]";
	}
		
}
