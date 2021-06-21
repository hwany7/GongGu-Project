<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/setting.jsp" %>

<!DOCTYPE html>
<html>
	<head>	
		<meta charset="UTF-8">
		<title>GongGu</title>
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>	
	</head>
	<body>
		<!-- 컨테이너 -->
		<div class="container-fluid">
		
			<!-- 상단 메뉴바-->
			<div class="row">
				<div class="height-60 pd-top-15 hf login-menu line-a">
					<div class="col-xs-6 col-md-6">
						<div class="mar-left-100"><h4><a href="mainPage.do">GongGu</a></h4></div>
					</div>
					<div class="col-xs-6 col-md-6">
						<div class="text-right mar-right-150">
							<h4>
								<span><a href="loginForm.do">로그인</a></span>
								<span><a href="signUpForm.do">회원가입</a></span>
							</h4>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 회원 가입 -->
			<div class="row">
	 			<div class="col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4">
	 				<div class="div-center max-width-400">
		 				<div class="mar-top-100">
			                <h2>회원가입</h2>
			            </div>	
		            	<!-- 회원가입 폼 -->
		           		<form method="post" name="signUpForm" role="form" action="signUpPro.do" onsubmit="return checkConditionSignUpFrom()"><!-- 맨 마지막에 작성 -->
		           			<input type="hidden" id="checkEmail" value="0">
		           			<input type="hidden" id="checkNickname" value="0">
		           			<input type="hidden" id="emailConfirm" value="0">
		           			<input type="hidden" id="checkTel" value="0">
		           			
		                    <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-8">			                    		
			                       		<input type="text" class="form-control" id ="memberEmail" name="member_email" placeholder="이메일 계정" onkeyup="checkValidationEmail()" >
			                        </div>
			                    	<div class="col-md-4">
			                       		<input type="button" id="mailConfirmForm" class="btn btn-info width-100p" value="인증하기" disabled="disabled" onclick="openMailConfimForm()">
			                        </div>
		                        </div>
		                    </div>	                  
		                    <div class="form-group">
		                    	<h6 id="emailErr" class="help-block">올바른 이메일 형식이 아닙니다. 다시 입력해 주세요.</h6>
		                    	<div id="email_check"></div>
		                    </div>
		                    <div class="form-group">
		                        <input type="text" class="form-control" name="nickname" placeholder="닉네임" onkeyup="checkValidationNickName()">
		                        <h6 id="nicknameErr" class="help-block">올바른 닉네임 형식이 아닙니다. 다시 입력해 주세요.</h6>
		                        <div id="nickname_check"></div>
		                    </div>
		                    <div class="form-group">
		                        <input type="password" class="form-control" name="password" placeholder="비밀번호 입력" onkeyup="checkValidationPassword()">
		                        <h6 id="pwdRegErr" class="help-block">8글자 이상, 특수문자를 조합하여 입력하세요.</h6>
		                    </div>
		                    <div class="form-group">
		                        <input type="password" class="form-control" name="repassword" placeholder="비밀번호 확인" onkeyup="checkValidationRePassword()">
		                        <h6 id="rePwdErr" class="help-block">비밀번호와 일치하지 않습니다. 다시 입력해 주세요.</h6>
		                    </div>
		                    <div class="form-group mar-top-30">
		                    	<div class="row">
			                    	<div class="col-md-5">
			                       		<input type="text" class="form-control" name="zipcode" id="zipcode" placeholder="우편번호" readonly="readonly">
			                        </div>
			                    	<div class="col-md-7">
			                       		<input type="text" class="form-control" name="address1" id="address1" placeholder="도로명주소" readonly="readonly">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-8">
			                       		<input type="text" class="form-control" name="address2" id="address2" placeholder="상세주소">
			                        </div>
			                    	<div class="col-md-4">
			                       		<input type="button" class="btn btn-info width-100p" value="찾기" onclick="sample4_execDaumPostcode();">
			                        </div>
		                        </div>
		                    </div>                    
		                    <div class="form-group mar-bottom-300">
		                        <button type="submit" class="btn btn-info width-100p height-40">가입</button>
		                    </div>
		                </form>        
	                </div>
	            </div>    			
			</div>
		</div>
	</body>
</html>