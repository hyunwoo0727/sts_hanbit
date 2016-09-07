<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<section class="box" style="width: 90%;">
	<article style='padding-top: 0'>
		<ul class="list-group">
			<li class="list-group-item">총학생수 : 120명</li>
		</ul>
		<div class="panel panel-primary">
			<div class="panel-heading">학생 리스트</div>
			<div class="panel-body"></div>
			<table id="table_member_list">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>REGDATE</th>
					<th>BIRTH</th>
					<th>EMAIL</th>
					<th>PHONE</th>
					<th>GRADE</th>
				</tr>
				<tr>
					<td><a class="id">hong</a></td>
					<td>홍길동</td>
					<td>regDate</td>
					<td>birth</td>
					<td>email</td>
					<td>phone</td>
					<td><a class="regist">등록</a> / <a class="update">수정</a></td>
				</tr>
				<tr>
					<td><a class="id">hong2</a></td>
					<td>홍길동2</td>
					<td>regDate</td>
					<td>birth</td>
					<td>email</td>
					<td>phone</td>
					<td><a class="regist">등록</a> / <a class="update">수정</a></td>
				</tr>
			</table>
			<nav aria-label="Page navigation" style="height: 20%;">
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</article>
	<a href="#"><img id="img_admin_home" /></a> 
</section>