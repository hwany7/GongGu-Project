<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div class="max-width-1500 div-center">
			<c:if test="${postListDto[0].post_id eq null }">
				<div class="container-fluid">
					<!-- 내역이 없을경우 -->
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">	
							<div class="col-md-12">
								<h4 class="font-DH mar-top-50 text-color-g2">제품이 없습니다.</h4>
							</div>
						</div>
					</div>
				</div>
			</c:if>		
			<c:if test="${postListDto[0].post_id ne null }">
				<!-- 리스트 박스 -->
				<div class="container-fluid">
					<c:forEach var="postListDto" items="${postListDto}">
						<div class="row">
							<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
								<div class="postListBox">
									<div class="col-md-4 col-xs-4">
										<div class="div-center">
											<a href="/gonggu/post?post_id=${postListDto.post_id}">
												<img class="postListImage" src="${postListDto.thumbnail}">
											</a>
										</div>
										<input class="postList-amount-absolute" type="button" value="${postListDto.current_amount}명 신청" onclick="location='/gonggu/post?post_id=${postListDto.post_id}'">
									</div>
									<div class="col-md-8 col-xs-8">
										<div class="postListInfo">
											<h6 class="text-main-color">[${postListDto.product_name}]</h6>
											<h4>${postListDto.post_title}</h4>			
											<div class="etc text-color-g2">${postListDto.content}</div>  
											<c:if test="${info.post_status eq 'P'}">   
												<input type="button" value="결제" class="btn btn-default" onclick="location='/gonggu/mypage/posts/payable/pay?total_price=${postListDto.total_price}&application_id=${postListDto.application_id}'">					
											</c:if>										
										</div>							
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					
					<!-- 페이지 넘버 -->
					<div class="row">
						<div class="col-md-2 col-md-offset-5 hf font-DH text-center mar-top-20">
							<div class="row">
							<c:if test="${info.cnt gt 0}">
								<div class="col-md-2 text-center">
								<c:if test="${info.startPage gt info.pageBlock}"> 
									<a href="/gonggu/mypage/posts/payable?pageNum=${info.startPage-info.pageBlock}">◀</a>
								</c:if>
								</div>
								<div class="col-md-8">
								<c:forEach var="i" begin="${info.startPage}" end="${info.endPage}">
									<c:if test="${i eq info.currentPage}">
										<span style="color: #5BC0DE;">[${i}]</span>
									</c:if>
									<c:if test="${i ne info.currentPage}">
										<a href="/gonggu/mypage/posts/payable?pageNum=${i}">[${i}]</a>
									</c:if>
								</c:forEach>
								</div>
								<div class="col-md-2">
								<c:if test="${info.pageCount gt info.endPage}">	
									<a href="/gonggu/mypage/posts/payable?pageNum=${info.startPage+info.pageBlock}">▶</a>
								</c:if>
								</div>
							</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
