/*
===========META GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 메타
============================ 
*/
var app = (function() { // ( ) 안에서만 살 수 있음.. 밖에선 인식 안됨.
	var init = function(param) {
		session.init(param);
		grade.init();
		user.init();
		member.init();
		nav.init();
		admin.init();
		onCreate();
	}
	var contentBox = function() {
		$('#content').addClass('box').addClass('font_large');
		$('#content > article').css('width','300px').addClass('el_center').addClass('text_left');
	}
	var setContentView = function() {
		// layout & global
		// $('#header').addClass('header');
		contentBox();
		$('ul').addClass('list_style_none');
		$("#public_header_brand,#admin_header_brand,#user_header_brand").addClass('pointer').attr('src',session.getImgPath()+'/default/hanbit.png').attr('alt','hanbit').css('width','80px').css('height','70px').css('padding-bottom','5px');
		$('.container-fluid li a').css('color','white');
		$('.dropdown li a').css('color','black');
		$('#footer').addClass('footer');
		$('#footer').addClass('bottom');
		$('#global_content').addClass('box');
		$('#global_content #member_login').addClass('btn btn-primary').css('margin-bottom','10px');
		$('#global_content #member_signup').addClass('btn btn-primary').css('margin-bottom','10px');
		$('#admin_main').text('ADMIN MODE');
		$('.box a').addClass('pointer');
	}
	var onCreate = function() {
		setContentView();
		$('#public_header_brand').click(function() {controller.home();});
		$('#admin_header_brand').click(function() {controller.move('admin','main');});
		$('#nav a').click(function(e) {if(e.target.getAttribute('id')!=null){controller.move(e.target.getAttribute('id').split("_")[1], "main");}});
		$('li a').click(function(e) {
			if(e.target.getAttribute('id')!=null){
				var aid = e.target.getAttribute('id').split("_");
				if (aid.includes("admin") && !admin.checkAdmin()) {
					return;
				}
				controller.move(aid[0],aid[1]);
			}
		});
		$('#bt_bom').click(function() {controller.move('douglas', 'bom')});
		$('#bt_dom').click(function() {controller.move('douglas', 'dom')});
		$('#bt_kaup').click(function() {controller.move('douglas', 'kaup')});
		$('#bt_account').click(function() {controller.move('douglas', 'account')});
	}
	return {
		init : init,
		contentBox : contentBox
	};
})();
var nav = (function() {
	var init = function() {onCreate();}
	var setContentView = function() {
		$('#nav').css('width', '100%').css('padding', '0px');
		$('#nav').css('border-bottom', '1px solid gray');
	}
	var onCreate = function() {
		setContentView();
	}
	return {
		init : init
	};
})();
var controller = (function() {
	var _page, _directory,_key;
	var setPage = function(page) {this._page = page;}
	var getPage = function() {return this._page;}
	var setDirectory = function(directory) {this._directory = directory;}
	var getDirectory = function() {return this._directory;}
	var setKey = function(key) {this._key = key;}
	var getKey = function() {return this._key;}
	return {
		move : function(directory, page) {
			setDirectory(directory);
			setPage(page);
			location.href = session.getContext()+'/'+getDirectory()+'/'+getPage();
		},
		moveWithKey : function(directory, page, key) {
			setDirectory(directory);
			setPage(page);
			setKey(key);
			location.href = session.getContext()+'/'+getDirectory()+'/'+getPage()+'?key='+getKey();
		},
		home : function() {
			location.href = session.getContext()+"/";
		},
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory,
		setKey : setKey,
		getKey : getKey
	};
})();
var util = (function() {
	return {
		isNumber : function isNumber(value) {
			return typeof value === 'number' && isFinite(value);
		},
		pwChecker : function(value) {
/*			var pw_regex = /^.*(?=.{4,10})(?=.*[a-zA-Z0-9]).*$/;*/
			var pw_regex =  /^[A-za-z0-9_]{4,20}/g;
			return pw_regex.test(value)?"yes":"no";
		}
	};
})();
var session = (function() {
	var _context, _js, _css, _img;
	var setContext = function(context) {this._context = context;}
	var getContext = function() {return this._context;}
	var setJsPath = function(js) {this._js = js;}
	var getJsPath = function() {return this._js;}
	var setCssPath = function(css) {this._css = css;}
	var getCssPath = function() {return this._css;}
	var setImgPath = function(img) {this._img = img;}
	var getImgPath = function() {return this._img;}
	return {
		init : function(param) {
			this.setContext(param);
			this.setJsPath(param+'/resources/js');
			this.setCssPath(param+'/resources/css');
			this.setImgPath(param+'/resources/img');
		},
		setContext : setContext,
		getContext : getContext,
		setJsPath : setJsPath,
		getJsPath : getJsPath,
		setCssPath : setCssPath,
		getCssPath : getCssPath,
		setImgPath : setImgPath,
		getImgPath : getImgPath
	}
})();
/*
===========ADMIN_JS============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 관리자 모드
============================ 
*/
var admin = (function() {
	var _pass;
	var getPass = function() {return this._pass};
	var setPass = function(pass) {this._pass = pass;};
	var init = function() {onCreate();}
	var setContentView = function() {
		$('#admin_content').addClass('text_center');
		$('#admin_content p:first').text('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.');
		$('#admin_content h3:first').text('Member Management');
		$('#admin_content p:nth-child(2)').text('Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.');
		$('#img_admin_account + div > h3').text('Account Management');
		$('#admin_content p:last').text('A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.');
		$('#admin_content h3:last').text('Grade Management');
		$('#img_admin_home').attr('src',session.getImgPath()+'/default/home.png').attr('alt','home').css('width','50').css('height','50');
		$('#img_admin_member').attr('src',session.getImgPath()+'/default/member_mng.png').css('width','100px').css('height','100px');
		$('#img_admin_account').attr('src',session.getImgPath()+'/default/account_mng.png').css('width','100px').css('height','100px');
		$('#img_admin_grade').attr('src',session.getImgPath()+'/default/grade_mng.png').css('width','100px').css('height','100px');
	/*	$('#profile_img').attr('src',session.getImgPath()+'/member/${user.profileImg}');*/
	}
	var onCreate = function() {
		setContentView();
		$('#img_admin_home').click(function() {controller.move('admin','main');})
		
	}
	return {
		setPass : setPass,
		getPass : getPass,
		checkAdmin : function() {
			var isAdmin = confirm('관리자셈?');
			if (!isAdmin) {
				alert('관리자만 접근 가능');
			} else {
				var password = prompt('관리자 비번 입력');
				if (password == 1) {
					return true;
				} else {
					alert('비번이 틀려여');
					return false;
				}
			}
		},
		init : init
	};
})();
/* 
========== MEMBER=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : MEMBER
============================
*/
var LOGIN_FORM = '<div id="content">'
	+'<form id="member_login_form" class="form-signin">'
	+'<h2 class="form-signin-heading">Please sign in</h2>'
	+'<label for="inputEmail" class="sr-only"></label> '
	+'<input type="text" id="userid" name="userid" class="form-control"	placeholder="USER ID" required autofocus>'
	+'<label for="inputPassword" class="sr-only">Password</label>'
	+'<input type="password" name="userpw" id="inputPassword" class="form-control" placeholder="PASSWORD" required>'
	+'<input type="hidden"/>'
	+'<div class="checkbox">'
	+'<label> <input type="checkbox" value="remember-me">'
	+'Remember me'
	+'</label>'				
	+'</div>'
	+'<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>'
	+'</form>'
	+'</div>';

var SIGN_UP_FORM = '<section id="member_regist_content">'
	+'<form id="member_regist_form" method="post">'
	+'<div>'
	+'<label for="exampleInputEmail1">NAME</label>'
	+'<div><input type="text" id="name" placeholder="NAME"></div>'
	+'</div>'
	+'<div>'
	+'<label for="exampleInputEmail2">ID</label>'
	+'<div><input type="text" id="id" placeholder="ID(4~10자 입력 가능)"><input type="button" id="check_dup" name="check_dup" value="중복체크" /></div>' 
	+'</div>'
	+'<div>'
	+'<label for="exampleInputEmail3">PASSWORD</label>'
	+'<div><input type="password" id="password" placeholder="PASSWORD"></div>'  
	+'</div>' 
	+'<div>'
	+'<label for="exampleInputEmail3">PASSWORD2</label>'
	+'<div><input type="password" id="password2" placeholder="RE-PASSWORD"></div>'  
	+'</div>' 
	+'<div id="div_pw">'
	+'</div>'
	+'<div>'
	+'<label for="exampleInputEmail4">EMAIL</label>'
	+'<div><input type="email" id="email" placeholder="abc@email.com"></div>'   
	+'</div>'   
	+'<div>'
	+'<label for="exampleInputEmail5">SSN</label>'
	+'<div><input type="text" id="ssn" placeholder="ex)000000-1"></div>' 
	+'</div>' 
	+'<div>'
	+'<label for="exampleInputEmail6">PHONE</label>'
	+' <div><input type="text" id="phone" placeholder="ex)010-0000-0000"></div>'
	+'</div>'
	+'<div>'
	+'<label for="exampleInputEmail7">MAJOR</label>'
	+'<div>'
	+'<label><input type="radio" name="major" id="inlineRadio1" value="computer" checked>컴공학부</label>'
	+'<label><input type="radio" name="major" id="inlineRadio2" value="mgmt">경영학부</label>'
	+'<label><input type="radio" name="major" id="inlineRadio3" value="math">수학부</label>'
	+'<label><input type="radio" name="major" id="inlineRadio3" value="eng">영문학부</label>'
	+'</div>'
	+'</div>'
	+'<div>'
	+'<label for="exampleInputEmail5">SUBJECT</label>'
	+'<div>'
	+'<div>'
	+'<label><input type="checkbox" id="inlineCheckbox1" name="subject" value="java">Java</label>'
	+'<label><input type="checkbox" id="inlineCheckbox2" name="subject" value="SQL">SQL</label>'
	+'<label><input type="checkbox" id="inlineCheckbox3" name="subject" value="cpp">C++</label>'
	+'<label><input type="checkbox" id="inlineCheckbox4" name="subject" value="python">파이썬</label>'
	+'<label><input type="checkbox" id="inlineCheckbox5" name="subject" value="delphi">델파이</label>'
	+'<label><input type="checkbox" id="inlineCheckbox6" name="subject" value="HTML">HTML</label>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'<input id="bt_join" type="submit" value="회원가입" />'
	+'<input id="bt_cancel" type="reset" value="취 소"/>'
	+'</form> '
	+'</section>';
/* 
========== MAJOR_JS=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : 전공
============================
 */

/* 
========== STUDENT_JS=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : 학생
============================
*/




var member = (function() {
	var _name = '', _ssn = '', _gender = '', _age = 0;
	var setName = function(name) {this._name = name;}
	var getName = function() {return this._name;}
	var setSsn = function(ssn) {this._ssn = ssn;}
	var getSsn = function() {return this._ssn;}
	var setGender = function(gender) {this._gender = gender;}
	var getGender = function() {return this._gender;}
	var setAge = function(age) {this._age = age;}
	var getAge = function() {return this._age;}
	var init = function() {onCreate();}
	var setContentView = function() {
		$('#member_content').siblings("h1").text('MEMBER MANAGEMENT');
		$('#member_content_ol > li:first > a').text('SIGN UP').addClass('remove_underline');
		$('#member_content_ol > li:nth-child(2) > a').text('LIST').addClass('remove_underline');
		$('#member_content_ol > li:nth-child(3) > a').text('DETAIL').addClass('remove_underline');
		$('#member_content_ol > li:nth-child(4) > a').text('UPDATE').addClass('remove_underline');
		$('#member_content_ol > li:nth-child(5) > a').text('DELETE').addClass('remove_underline');
		$('#member_content_ol > li:nth-child(6) > a').text('SEARCH').addClass('remove_underline');
		$('#member_content_ol > li:nth-child(7) > a').text('COUNT').addClass('remove_underline');
		$('article #member_signup').text('SIGNUP');
		$('article #member_login').text('LOGIN');
		$('#member_regist_content').addClass('box').css('width', '50%');
		$('#member_regist_content span').addClass('float_left').addClass('text_left').addClass('font_bold').css('width', '200px');
		$('#member_regist_content #bt_join').addClass('btn').addClass('btn-primary');
		$('#member_regist_content #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div:nth-child(8) > div > div').addClass('checkbox');
		$('#member_regist_form > div').addClass('form-group');
		$('#member_regist_form div:nth-child(7) label:gt(0)').addClass('radio-inline');
		$('#member_regist_form div:nth-child(8) label:gt(0)').addClass('checkbox-inline');
		$('.form-group > div').addClass('col-sm-10');
		$('.form-group > label').addClass('col-sm-2').addClass('control-label');
		$('.col-sm-10 > input').addClass('form-control');
		$('#member_details').addClass('el_center').addClass('border_collapse')
				.css('border', '3px solid gray').css('width', '70%').css('height', '300px');
		$('#member_details tr').css('border', '1px solid gray').css('height','15%');
		$('#member_details tr td').addClass('font_xlarge').css('border','1px solid gray');
		$('#member_details tr > td:odd').addClass('bg_gray');
		$('#member_list').addClass('border_collapse').css('witdh', '100%').css('font-family', 'arial, sans-serif');
		$('#member_list td, th').addClass('text_left').css('border','1px solid #dddddd').css('padding', '8px');
		$('#member_list tr:nth-child(even)').css('background-color', '#dddddd');
	}
	var onCreate = function() {
		setContentView();
	/*	$('#member_find_form input[type=hidden').attr('name','context').attr('value',session.getContext());*/
		$('#btn_search').attr('formaction',session.getContext()+'/member/find');
	//	$('#member_login_form').attr('method','post').attr('action',session.getContext()+'/member/login');
		$('#member_login_form input[type=hidden]').attr('name','context').attr('value',session.getContext());
	/*	$('#member_login_form > button').click(function() {
		//	$('#member_login_form').submit();
		});*/
		$('#ul_grade li:eq(0)').click(function name() {controller.move('grade','detail');})
		$('#ul_grade li:eq(1)').click(function name() {controller.move('grade','search');})
		$('#ul_account li:eq(0)').click(function name() {controller.move('account','detail');})
		$('#ul_account li:eq(1)').click(function name() {controller.move('account','open');})
		$('#ul_account li:eq(2)').click(function name() {controller.move('account','transaction');})
		$('#ul_account li:eq(3)').click(function name() {controller.move('account','delete');})
		$("#table_member_list .id").click(function() {controller.moveWithKey('member','a_detail',$(this).text());})
		$("#table_member_list .regist,.update").click(function() {controller.moveWithKey('grade',$(this).attr('class').split(" ")[0],$(this).parent().siblings('td:first').text());})
		$("#member_login").click(function() {
			member.pub_login_form();
		});
		$("#member_signup").click(function() {
			member.pub_sign_up_form();
		});
		$('#kaup').addClass('pointer').click(function(){controller.move('member','kaup')});
		$('#rsp').addClass('pointer').click(function(){controller.move('member','rsp')});
		$('#lotto').addClass('pointer').click(function(){controller.move('member','lotto')});
		$('#team .col-md-4 button').click(function() {
			controller.moveWithKey('subject','detail',$(this).siblings('input[type=hidden]').attr('value'));
		});
	}
	return {
		setName : setName,
		getName : getName,
		setSsn : setSsn,
		getSsn : getSsn,
		setGender : setGender,
		getGender : getGender,
		setAge : setAge,
		getAge : getAge,
		init : init,
		spec : function() {
			setName($(".formbox #name").value);
			setSsn($("#ssn").value);
			var scode = Number(getSsn().split("-")[1]);
			var ageYear = Number(getSsn().substring(0, 2));
			var gen = (scode + 2) % 2 == 0 ? '여' : '남';
			setGender(gen);
			var nowYear = new Date().getFullYear();
			switch (scode) {
			case 1:case 2:case 5:case 6:
				setAge(nowYear - (1900 + ageYear) + 1);
				break;
			case 9:case 0:
				setAge(nowYear - (1800 + ageYear) + 1);
				break;
			default:
				setAge(nowYear - (2000 + ageYear) + 1);
				break;
			}
			$('.databox #name').innerHTML = getName();
			$('#age').innerHTML = getAge();
			$('#gender').innerHTML = getGender();
		},
		pub_login_form : function() {
			$('#pub_article').empty().html(LOGIN_FORM);
			app.contentBox();
			$('#member_login_form > button').click(function(e) {
				e.preventDefault();
				$.ajax({
					url : session.getContext()+'/member/login',
					type : 'POST',
					data : {'context':session.getContext(),'userid':$('#userid').val(),'userpw':$('#inputPassword').val()},
					dataType : 'json',
					success : function(data){
						if(data.name==null){
							alert('아이디나 비밀번호를 확인해 주세요');
						}else{
							$('#pub_header').empty().load(session.getContext()+'/member/logined/header');	
							$("#pub_header").on('click','#btn_logout',function(){
								controller.move('member','logout');
							});
							$('#pub_article').html(STUDENT_MAIN);
						}		
					},
					/*error:function(request,status,error){
					    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}*/
					error : function(xhr,status,msg){
						alert('로그인 실패 이유 '	+msg);
					}
				});
			});
			
		},
		pub_sign_up_form : function() {
			
			$('#pub_article').empty().append(SIGN_UP_FORM);
			$('#bt_join').prop('disabled',true);
			$('#password,#password2').attr('maxlength','20');
			member.init();
			$('#pub_article').on('click','#check_dup',function(){
				var id_val = $('#id').val();
				if(id_val.length < 4 || id_val.length > 20){
					alert('아이디는 4~20자 까지 가능합니당');
					return;
				}	
				if(util.pwChecker(id_val)==='yes'){
					
					$.ajax({
			               url : session.getContext()+'/member/check_dup/'+id_val,
			               dataType : 'json',		             
			               success : function(data){
			            	   if(data.flag=="TRUE"){
			            		   $('#id').val('').prop('placeholder',data.message).focus();
			            	   }else{
			            		   alert('해당 아이디는 사용가능합니다');
			            	   }
			               },
			               error : function(x,s,m){
			                  alert('id 중복체크시 발생한 에러 : ' + m);
			               }
			         });
				}else{
					alert('정규표현식 아님');
				}
			});
			$("#password2").keyup(function(){
				$('#bt_join').prop('disabled',true);
				var pw1 = $('#password').val();
				var pw2 = $(this).val();
				if(pw1.length==pw2.length){
					if(pw1!==pw2){
						$('#div_pw').text('비밀 번호가 다릅니다').css('color','red');
					}else{
						$('#div_pw').text('비밀 번호가 일치합니다').css('color','green');
						$('#bt_join').prop('disabled',false);
						$('#email').focus();
					}
				}	
			})
			$('#pub_article').on('click','#bt_join',function(e){
				e.preventDefault();
				var subjects = '';
				$('input[name=subject]:checked').each(function() {
					subjects += $(this).val()+':';		
				})
				subjects = subjects.substring(0,subjects.length-1);	
				var join_info = {
						'memId' : $('#id').val(),
						'pw' : $('#password').val(),
						'name' : $('#name').val(),
						'email' : $('#email').val(),
						'ssn' : $('#ssn').val(),
						'phone' : $('#phone').val(),
						'major' : $('input[name=major]:checked').val(),
						'subjects' : subjects
				}
				$.ajax({
					url : session.getContext()+'/member/signup',
					type : 'POST',
					data : JSON.stringify(join_info),
					contentType : 'application/json',
					dataType : 'json',
					asynch : false,
					success : function(data) {
						if(data.message==="success"){
							member.pub_login_form();
						}else{
							alert('회원가입 중 에러가 발생했습니다');
						}
					},
					error : function(xhr,status,msg) {
						alert(msg);
					}
				})
			})
		}
	};
})();
/* 
========== PROFESSOR_JS=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : 교수
============================
*/
var user = (function() {
	var init = function() {onCreate();}
	var setContentView = function() {
		$('#img_home').attr('src', session.getImgPath() + '/default/home.png').attr('alt', 'home').css('width', '50').css('height', '50');
		$('#user_menu>li>a').css('padding','0px');
		$('#user_menu>li>a').css('padding','0px');
		$('#user_menu > li').css('margin-top','10px').css('margin-right','5px');
	}
	var onCreate = function() {
		setContentView();
		$('#user_header_brand').click(function() {controller.move('member','main');});
		$('#img_home').click(function() {controller.home();})
	};
	return {
		init : init
	};
})();
/* 
========== GRADE_JS=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : 성적
============================
*/
var grade = (function() {
	var init = function() {
		onCreate();
	}
	var setContentView = function() {
		// grade style
		$('#grade_content').siblings("h1").text('GRADE MANAGEMENT');
		$('#grade_content_ol > li:first > a').text('REGIST').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(2) > a').text('UPDATE').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(3) > a').text('DELETE').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(4) > a').text('LIST').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(5) > a').text('COUNT').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(6) > a').text('SEARCH').addClass('remove_underline');
		$('#grade_regist_content').addClass('box').css('width', '50%');
		$('#grade_regist_content span').addClass('float_left').addClass('text_left').addClass('font_bold').css('width', '200px');
		$('#grade_regist_content #bt_send').addClass('btn').addClass('btn-primary');
		$('#grade_regist_content #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#grade_regist_form').addClass('form-horizontal');
		$('#grade_regist_form > div:nth-child(8) > div > div').addClass('checkbox');
		$('#grade_regist_form > div').addClass('form-group');
		$('.form-group > label').addClass('col-sm-2').addClass('control-label');
	}
	var onCreate = function() {
		setContentView();
	};
	return {
		init : init
	};
})();	
/* 
========== BOARD_JS=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : 게시판
============================
*/
/* 
========== SUBJECT_JS=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : 과목
============================
*/
/* 
========== EXAM_JS=========
@AUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-08-01
@UPDATE DATE : 2016-09-20
@DESC : 시험
============================
*/












var STUDENT_MAIN = '<section id="services" class="box section-padded">'
	+'<div>'
	+'<div class="row text-center title">'
	+'<h2>Services</h2>'
	+'<h4 class="light muted">Achieve the best results with our wide'
	+'variety of training options!</h4>'
	+'</div>'
	+'<div class="row services">'
	+'<div class="col-md-4">'
	+'<div id="kaup" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+session.getImgPath()+'/icons/kaup.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">KAUP</h4>'
	+'<p class="description">A elementum ligula lacus ac quam'
	+'ultrices a scelerisque praesent vel suspendisse scelerisque a'
	+'aenean hac montes.</p>'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div id="rsp" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+session.getImgPath()+'/icons/rsp.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">ROCK SISSOR PAPER</h4>'
	+'<p class="description">A elementum ligula lacus ac quam'
	+'ultrices a scelerisque praesent vel suspendisse scelerisque a'
	+'aenean hac montes.</p>'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div id="lotto" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+session.getImgPath()+'/icons/lotto.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">LOTTO DRAWING</h4>'
	+'<p class="description">A elementum ligula lacus ac quam'
	+'ultrices a scelerisque praesent vel suspendisse scelerisque a'
	+'aenean hac montes.</p>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'<div class="cut cut-bottom"></div>'
	+'</section>'
	+'<section id="team" class="section gray-bg">'
	+'<div class="container">'
	+'<div class="row title text-center">'
	+'<h2 class="margin-top">Major Subject</h2>'
	+'<h4 class="light muted">We re a dream team!</h4>'
	+'</div>'
	+'<div class="row">'
	+'<div class="col-md-4">'
	+'<div class="team text-center">'
	+'<div class="cover"'
	+'style="background:url('+session.getImgPath()+'/team/team-cover1.jpg"); background-size:cover;">'
	+'<div class="overlay text-center">'
	+'<h3 class="white">$69.00</h3>'
	+'<h5 class="light light-white">1 - 5 sessions / month</h5>'
	+'</div>'
	+'</div>'
	+'<img src="'+session.getImgPath()+'/team/team1.jpg" alt="Team Image" class="avatar">'
	+'<div class="title">'
	+'<h4>Java</h4>'
	+'<h5 class="muted regular">Server Program Language</h5>'
	+'</div>'
	+'<button id="major_subject_1" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill">과목 정보 보기</button>'
	+'<input type="hidden" value="java">'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div class="team text-center">'
	+'<div class="cover" style="background:url('+session.getImgPath()+'/team/team-cover2.jpg"); background-size:cover;">'
	+'<div class="overlay text-center">'
	+'<h3 class="white">$69.00</h3>'
	+'<h5 class="light light-white">1 - 5 sessions / month</h5>'
	+'</div>'
	+'</div>'
	+'<img src="'+session.getImgPath()+'/team/team2.jpg" alt="Team Image" class="avatar">'
	+'<div class="title">'
	+'<h4>Javascript</h4>'
	+'<h5 class="muted regular">UI Programming language</h5>'
	+'</div>'
	+'<button id="major_subject_2" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill ripple">과목 정보 보기</button>'
	+'<input type="hidden" value="javascript">'	
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div class="team text-center">'
	+'<div class="cover" style="background:url('+session.getImgPath()+'/team/team-cover3.jpg"); background-size:cover;">'
	+'<div class="overlay text-center">'
	+'<h3 class="white">$69.00</h3>'
	+'<h5 class="light light-white">1 - 5 sessions / month</h5>'
	+'</div>'
	+'</div>'
	+'<img src="'+session.getImgPath()+'/team/team3.jpg" alt="Team Image" class="avatar">'
	+'<div class="title">'
	+'<h4>SQL</h4>'
	+'<h5 class="muted regular">Database Language</h5>'
	+'</div>'
	+'<button id="major_subject_3" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill ripple">과목 정보 보기</button>'
	+'<input type="hidden" value="sql">'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</section>'
	+'<section id="pricing" class="section">'
	+'<div class="container">'
	+'<div class="row title text-center">'
	+'<h2 class="margin-top white">Pricing</h2>'
	+'<h4 class="light white">Choose your favorite pricing plan and sign up today!</h4>'
	+'</div>'
	+'<div class="row no-margin">'
	+'<div class="col-md-7 no-padding col-md-offset-5 pricings text-center">'
	+'<div class="pricing">'
	+'<div class="box-main active" data-img="img/contentbg.jpg">'
	+'<h4 class="white">Yoga Pilates</h4>'
	+'<h4 class="white regular light">$850.00 <span class="small-font">/ year</span>'
	+'</h4><a href="#" data-toggle="modal" data-target="#modal1" class="btn btn-white-fill">Sign Up Now</a>' 
	+'<i class="info-icon icon_question"></i>'
	+'</div>'
	+'<div class="box-second active">'
	+'<ul class="white-list text-left">'
	+'<li>One Personal Trainer</li>'
	+'<li>Big gym space for training</li>'
	+'<li>Free tools &amp; props</li>'
	+'<li>Free locker</li>'
	+'<li>Free before / after shower</li>'
	+'</ul>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</section>'
	+'<section class="section section-padded blue-bg">'
	+'<div class="container">'
	+'<div class="row">'
	+'<div class="col-md-8 col-md-offset-2">'
	+'<div class="owl-twitter owl-carousel">'
	+'<div class="item text-center">'
	+'<i class="icon fa fa-twitter"></i>'
	+'<h4 class="white light">To enjoy the glow of good health, you must exercise.</h4>'
	+'<h4 class="light-white light">#health #training #exercise</h4>'
	+'</div>'
	+'<div class="item text-center">'
	+'<i class="icon fa fa-twitter"></i>'
	+'<h4 class="white light">To enjoy the glow of good health, you must exercise.</h4>'
	+'<h4 class="light-white light">#health #training #exercise</h4>'
	+'</div>'
	+'<div class="item text-center">'
	+'<i class="icon fa fa-twitter"></i>'
	+'<h4 class="white light">To enjoy the glow of good health, you must exercise.</h4>'
	+'<h4 class="light-white light">#health #training #exercise</h4>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</div>';
	+'</section>'