package kakao.localSearch.category.dto;

import java.lang.reflect.Field;
/**
 * 카카오 API - 카테고리를 이용한 지역검색 요청 DTO 
 * @author dongdang
 *
 */
public class LocalCategoryRequestDTO {
	/*
	 * category_group_code = 카테고리 그룹 코드 
	 * x = 중심 좌표의 x값
	 * y = 중심 좌표의 y값
	 * radius = 중심 좌표로부터의 반경거리
	 * rect = 사각형 범위 내에서 제한 검색을 위한 좌표
	 * page = 결과 페이지 번호
	 * size = 한 페이지에 보여질 문서의 개수
	 * sort = 결과 정렬 순서
	 *
	 */
	private String category_group_code;
	private String x;
	private String y;
	private Integer radius;
	private String rect;
	private Integer page;
	private Integer size;
	private String sort;
	
	
	public LocalCategoryRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the category_group_code
	 */
	public String getCategory_group_code() {
		return category_group_code;
	}


	/**
	 * @param category_group_code the category_group_code to set
	 */
	public void setCategory_group_code(String category_group_code) {
		this.category_group_code = category_group_code;
	}


	/**
	 * @return the x
	 */
	public String getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(String x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	public String getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(String y) {
		this.y = y;
	}


	/**
	 * @return the radius
	 */
	public Integer getRadius() {
		return radius;
	}


	/**
	 * @param radius the radius to set
	 */
	public void setRadius(Integer radius) {
		this.radius = radius;
	}


	/**
	 * @return the rect
	 */
	public String getRect() {
		return rect;
	}


	/**
	 * @param rect the rect to set
	 */
	public void setRect(String rect) {
		this.rect = rect;
	}


	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}


	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}


	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}


	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}


	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/** toString : 값이 존재하는 멤버 변수만 반환, 멤버 변수를 수정해도 변경 필요 없음(category_group_code 제외) */
	@Override
	public String toString() {
		StringBuilder toStringBuilder = new StringBuilder();
		toStringBuilder.append("category_group_code="+category_group_code);
		try {
			for(Field field : this.getClass().getDeclaredFields()) {
				if(field.get(this)!=null && !field.getName().equals("category_group_code")) toStringBuilder.append("&"+field.getName()+"="+field.get(this));
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toStringBuilder.append("");
		return toStringBuilder.toString();
	}
	
	
}
