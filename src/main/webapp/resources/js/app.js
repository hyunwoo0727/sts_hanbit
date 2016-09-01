var app = (function() { // ( ) 안에서만 살 수 있음.. 밖에선 인식 안됨.
	var init = function(param) {
		session.init(param);
		user.init();
		account.init();
		member.init();
		grade.init();
		nav.init();
		admin.init();
		onCreate();
	}
	var setContentView = function() {
		// layout & global
		// $('#header').addClass('header');
		$('ul').addClass('list_style_none');
		$("#header_brand").addClass('pointer').attr('src',
				session.getImgPath() + '/default/hanbit.png').attr('alt', 'hanbit')
				.css('width','80px').css('height','70px').css(
						'padding-bottom', '5px');
		$('#user_menu>li>a').css('padding','0px');
		$('#user_menu>li>a').css('padding','0px');
		$('#user_menu > li').css('margin-top','10px').css('margin-right','5px');
		$('.container-fluid li a').css('color','white');
		$('.dropdown li a').css('color','black');
		$('#footer').addClass('footer');
		$('#footer').addClass('bottom');
		$('#content').addClass('box').addClass('font_large');
		$('#content > article').css('width', '300px').addClass('el_center')
				.addClass('text_left');
		$('#global_content').addClass('box');
		$('#global_content h2').append(
				'<small>서비스를 이용하시려면</small> 회원가입<small>을 하셔야 합니다</small>');
		$('#global_content #member_login').addClass('btn btn-primary').css(
				'margin-bottom', '10px');
		$('#global_content #member_regist').addClass('btn btn-primary').css(
				'margin-bottom', '10px');
		$('#admin_main').text('ADMIN MODE');
		$('.box a').addClass('pointer');
		
	}
	var onCreate = function() {
		setContentView();
		$('#header_brand').click(function() {
			controller.home();
		});
		$('#nav a').click(function(e) {
			controller.move(e.target.getAttribute('id').split("_")[1], "main");
		});
		$('li a').click(function(e) {
			var aid = e.target.getAttribute('id').split("_");
			if (aid.includes("admin") && !admin.checkAdmin()) {
				return;
			}
			controller.move(aid[0], aid[1]);
		});
		$('#bt_bom').click(function() {
			controller.move('douglas', 'bom')
		});
		$('#bt_dom').click(function() {
			controller.move('douglas', 'dom')
		});
		$('#bt_kaup').click(function() {
			controller.move('douglas', 'kaup')
		});
		$('#bt_account').click(function() {
			controller.move('douglas', 'account')
		});
	}
	return {
		init : init
	};
})();

var admin = (function() {
	var _pass;
	var getPass = function() {
		return this._pass
	};
	var setPass = function(pass) {
		this._pass = pass;
	};
	var init = function() {
		onCreate();
	}
	var setContentView = function() {
		$('#admin_content').addClass('text_center');
		$('#admin_content p:first')
				.text(
						'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.');
		$('#admin_content h3:first').text('Member Management');
		$('#admin_content p:nth-child(2)')
				.text(
						'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.');
		$('#img_admin_account + div > h3').text('Account Management');
		$('#admin_content p:last')
				.text(
						'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.');
		$('#admin_content h3:last').text('Grade Management');
		$('#img_admin_home').attr('src', session.getImgPath() + '/default/home.png')
				.attr('alt', 'home').css('width', '50').css('height', '50');
	}
	var onCreate = function() {
		setContentView();
		$('#img_admin_home').click(function() {
			controller.move('admin','main');
		})
		$('#btn_exit').click(function() {
			controller.move('member','logout');
		})
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
var user = (function() {
	var init = function() {
		onCreate();
	}
	var setContentView = function() {
		$('#img_home').attr('src', session.getImgPath() + '/default/home.png').attr(
				'alt', 'home').css('width', '50').css('height', '50');
		$('#img_logout').attr('src', session.getImgPath() + '/default/logout.png')
				.attr('alt', 'logout').css('width', '50').css('height', '50');
	}
	var onCreate = function() {
		setContentView();
		$('#img_logout').click(function() {
			controller.move('member', 'logout');
		})
		$('#img_home').click(function() {
			controller.home();
		})
	};
	return {
		init : init
	};
})();
var account = (function() {
	var _account_no, _money;
	var setAccountNo = function(account_no) {
		this._account_no = account_no;
	}
	var getAccountNo = function() {
		return this._account_no;
	}
	var setMoney = function(money) {
		this._money = money;
	}
	var getMoney = function() {
		return this._money;
	}
	var init = function() {
		onCreate();
	}
	var setContentView = function() {
		$('#account_content').siblings("h1").text('ACCOUNT MANAGEMENT');
	}
	var onCreate = function() {
		setContentView();
		$('#account_option').change(function() {
			var option = $('#account_option option:selected').val();
			switch (option) {
			case "open":
				$('#input_open_account').show();
				$('#input_delete_account').hide();
				break;
			default:
				$('#input_open_account').hide();
				$('#input_delete_account').show();
				break;
			}
		})
	};
	return {
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : init,
		open : function() {
			setAccountNo(Math.floor((Math.random() * 899999) + 100001));
			setMoney(0);
			$("#account").innerHTML = getAccountNo();
			$(".databox #money").innerHTML = getMoney();
		},
		deposit : function() {
			if (!util.isNumber(getAccountNo())) {
				alert('통장부터 만드셈');
			}
			setMoney(getMoney() + Number($("input[id=money]").value));
			$(".databox #money").innerHTML = getMoney();
		},
		withdraw : function() {
			if (!util.isNumber(getAccountNo())) {
				alert('통장부터 만드셈');
				return;
			}
			var withdraw_money = Number($("input[id=money]").value);
			if (getMoney() < withdraw_money) {
				alert('출금액이 더 큼');
			} else {
				setMoney(getMoney() - withdraw_money);
				$(".databox #money").innerHTML = getMoney();
			}
		}
	};
})();

var member = (function() {
	var _name = '', _ssn = '', _gender = '', _age = 0;
	var setName = function(name) {
		this._name = name;
	}
	var getName = function() {
		return this._name;
	}
	var setSsn = function(ssn) {
		this._ssn = ssn;
	}
	var getSsn = function() {
		return this._ssn;
	}
	var setGender = function(gender) {
		this._gender = gender;
	}
	var getGender = function() {
		return this._gender;
	}
	var setAge = function(age) {
		this._age = age;
	}
	var getAge = function() {
		return this._age;
	}
	var init = function() {
		onCreate();
	}
	var setContentView = function() {
		$('#member_content').siblings("h1").text('MEMBER MANAGEMENT');
		$('#member_content_ol > li:first > a').text('SIGN UP').addClass(
				'remove_underline');
		$('#member_content_ol > li:nth-child(2) > a').text('LIST').addClass(
				'remove_underline');
		$('#member_content_ol > li:nth-child(3) > a').text('DETAIL').addClass(
				'remove_underline');
		$('#member_content_ol > li:nth-child(4) > a').text('UPDATE').addClass(
				'remove_underline');
		$('#member_content_ol > li:nth-child(5) > a').text('DELETE').addClass(
				'remove_underline');
		$('#member_content_ol > li:nth-child(6) > a').text('SEARCH').addClass(
				'remove_underline');
		$('#member_content_ol > li:nth-child(7) > a').text('COUNT').addClass(
				'remove_underline');
		$('article #member_regist').text('REGIST');
		$('article #member_login').text('LOGIN');
		$('#member_regist_content').addClass('box').css('width', '50%');
		$('#member_regist_content span').addClass('float_left').addClass(
				'text_left').addClass('font_bold').css('width', '200px');
		$('#member_regist_content #bt_join').addClass('btn').addClass(
				'btn-primary');
		$('#member_regist_content #bt_cancel').addClass('btn').addClass(
				'btn-danger');
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div:nth-child(8) > div > div').addClass(
				'checkbox');
		$('#member_regist_form > div').addClass('form-group');
		$('#member_regist_form div:nth-child(7) label:gt(0)').addClass(
				'radio-inline');
		$('#member_regist_form div:nth-child(8) label:gt(0)').addClass(
				'checkbox-inline');
		$('.form-group > div').addClass('col-sm-10');
		$('.form-group > label').addClass('col-sm-2').addClass('control-label');
		$('.col-sm-10 > input').addClass('form-control');
		$('#member_details').addClass('el_center').addClass('border_collapse')
				.css('border', '3px solid gray').css('width', '70%').css(
						'height', '300px');
		$('#member_details tr').css('border', '1px solid gray').css('height',
				'15%');
		$('#member_details tr td').addClass('font_xlarge').css('border',
				'1px solid gray');
		$('#member_details tr > td:odd').addClass('bg_gray');
		$('#member_list').addClass('border_collapse').css('witdh', '100%').css(
				'font-family', 'arial, sans-serif');
		$('#member_list td, th').addClass('text_left').css('border',
				'1px solid #dddddd').css('padding', '8px');
		$('#member_list tr:nth-child(even)').css('background-color', '#dddddd');
	}
	var onCreate = function() {
		setContentView();
	/*	$('#member_find_form input[type=hidden').attr('name','context').attr('value',session.getContext());*/
		$('#btn_search').attr('formaction',session.getContext()+'/member/find');
		$('#member_login_form').attr('method','post').attr('action',session.getContext()+'/member/login');
		$('#member_login_form input[type=hidden]').attr('name','context').attr('value',session.getContext());
		$('#member_login_form > button').click(function() {
			$('#member_login_form').submit();
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
			case 1:
			case 2:
			case 5:
			case 6:
				setAge(nowYear - (1900 + ageYear) + 1);
				break;
			case 9:
			case 0:
				setAge(nowYear - (1800 + ageYear) + 1);
				break;
			default:
				setAge(nowYear - (2000 + ageYear) + 1);
				break;
			}
			$('.databox #name').innerHTML = getName();
			$('#age').innerHTML = getAge();
			$('#gender').innerHTML = getGender();
		}
	};
})();
var grade = (function() {
	var init = function() {
		onCreate();
	}
	var setContentView = function() {
		// grade style
		$('#grade_content').siblings("h1").text('GRADE MANAGEMENT');
		$('#grade_content_ol > li:first > a').text('REGIST').addClass(
				'remove_underline');
		$('#grade_content_ol > li:nth-child(2) > a').text('UPDATE').addClass(
				'remove_underline');
		$('#grade_content_ol > li:nth-child(3) > a').text('DELETE').addClass(
				'remove_underline');
		$('#grade_content_ol > li:nth-child(4) > a').text('LIST').addClass(
				'remove_underline');
		$('#grade_content_ol > li:nth-child(5) > a').text('COUNT').addClass(
				'remove_underline');
		$('#grade_content_ol > li:nth-child(6) > a').text('SEARCH').addClass(
				'remove_underline');
	}
	var onCreate = function() {
		setContentView();
	};

	return {
		init : init
	};
})();
var nav = (function() {
	var init = function() {
		onCreate();
	}
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
	var _page, _directory;
	var setPage = function(page) {
		this._page = page;
	}
	var getPage = function() {
		return this._page;
	}
	var setDirectory = function(directory) {
		this._directory = directory;
	}
	var getDirectory = function() {
		return this._directory;
	}
	return {
		move : function(directory, page) {
			setDirectory(directory);
			setPage(page);
			location.href = session.getContext() + '/' + getDirectory() + '/'
					+ getPage();
		},
		home : function() {
			location.href = session.getContext() + "/";
		},
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory
	};
})();
var util = (function() {
	return {
		isNumber : function isNumber(value) {
			return typeof value === 'number' && isFinite(value);
		}
	};
})();
var session = (function() {
	var _context, _js, _css, _img;
	var setContext = function(context) {
		this._context = context;
	}
	var getContext = function() {
		return this._context;
	}
	var setJsPath = function(js) {
		this._js = js;
	}
	var getJsPath = function() {
		return this._js;
	}
	var setCssPath = function(css) {
		this._css = css;
	}
	var getCssPath = function() {
		return this._css;
	}
	var setImgPath = function(img) {
		this._img = img;
	}
	var getImgPath = function() {
		return this._img;
	}
	return {
		init : function(param) {
			this.setContext(param);
			this.setJsPath(param + '/resources/js');
			this.setCssPath(param + '/resources/css');
			this.setImgPath(param + '/resources/img');
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