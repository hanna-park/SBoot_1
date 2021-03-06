<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />

<div class="container"> 
<h1>N O T I C E</h1>

		<div>
			<form action="./noticeList" id="frm">
				<input type="hidden" value="1" name="curPage" id="curPage">
			
				<select name="kind">				
					<option id="kT" value="kT">제목</option>
					<option id="kW" value="kW">작성자</option>
					<option id="kC" value="kC">내용</option>
				</select>
			
				<input type="text" name="search" value="${pager.search}">
				
				<button>검색</button>
			</form>
		</div>
	<table class="table table-hover">
		<tr>
			<td>num</td>
			<td>title</td>
			<td>writer</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		
		<c:forEach items="${list}" var ="vo">
			<tr>
				<td>${vo.num}</td>
				<td><a href="./noticeSelect?num=${vo.num}"> ${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regDate}</td>
				<td>${vo.hit}</td>
			</tr>
		</c:forEach>	
	</table>
	
	<div style="width: 100%; margin: 0 auto; text-align: center; padding-top: 10px;">
				<ul class="pagination" style="margin: 0 auto; text-align: center;">
					
					<c:if test="${pager.curBlock gt 1}">
						<li><span id=${pager.startNum - 1} class="list">이전</span></li>
					</c:if>
					
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
						<li><span id="${i}" class="list">${i}</span></li>
					</c:forEach>

					<c:if test="${pager.curBlock lt pager.totalBlock}">
						<li><span id="${pager.lastNum + 1}" class="list">다음</span></li>
					</c:if>
					
				</ul>
			</div>
			
			<a class="C" href="noticeWrite"> write</a><br>
	
	
	<script type="text/javascript">
		var kind = '${pager.kind}';
		if (kind == '') {
			kind = "kT";
		}
		
		$("#"+kind).prop("selected", true);
	
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	</script>
	
	
</div>
</body>
</html>