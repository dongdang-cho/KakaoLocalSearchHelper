package kakao.localSearch.category.dto;

/**
 * <strong>LocalCategoryList에 요소가 되는 클래스/strong>
 * <pre>카테고리 키와 문서정보를 같이 저장됨</pre>
 * @author dongdang
 *
 */
public class LocalCategoryListElementDTO {
	/*
	 * key = 카테고리 서치를 진행할 때 기준이 된 카테고리 
	 * categoryResponseDTO = 카테고리 서치를 진행하고 응답 받은 데이터
	 */
	private String key;
	private LocalCategoryResponseDTO categoryResponseDTO;
	
	/** 모든 멤버변수 초기화 */
	public LocalCategoryListElementDTO(String key, LocalCategoryResponseDTO categoryResponseDTO) {
		super();
		this.key = key;
		this.categoryResponseDTO = categoryResponseDTO;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the categoryResponseDTO
	 */
	public LocalCategoryResponseDTO getCategoryResponseDTO() {
		return categoryResponseDTO;
	}

	/**
	 * @param categoryResponseDTO the categoryResponseDTO to set
	 */
	public void setCategoryResponseDTO(LocalCategoryResponseDTO categoryResponseDTO) {
		this.categoryResponseDTO = categoryResponseDTO;
	}

	@Override
	public String toString() {
		return "LocalCategoryListElement [key=" + key + ", categoryResponseDTO=" + categoryResponseDTO + "]";
	}
		
	
}
