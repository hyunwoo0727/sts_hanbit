var util = (function() {
	var _page,_directory;
	var setPage = function(page) {this._page = page;}
	var getPage = function() {	return this._page;	}
	var setDirectory = function(directory) {this._directory = directory;}
	var getDirectory = function() {	return this._directory;	}
	return {
		move : function(directory,page) {
			setDirectory(directory);
			setPage(page);
			location.href = sessionStorage.getItem("context") +  '/douglas.do?page='+page;
		},
		isNumber : function isNumber(value) {
			  return typeof value === 'number' && isFinite(value);
		}
	}	
})();
var douglas = (function() {
	var context = sessionStorage.getItem("context");
	return {
		init : function() {
			$('#bt_bom').click(function(){util.move('douglas','bom')});
			$('#bt_dom').click(function(){util.move('douglas','dom')});
			$('#bt_kaup').click(function(){util.move('douglas','kaup')});
			$('#bt_account').click(function(){util.move('douglas','account')});	
		}
	};
})();

var account = (function() {
	var _account_no,_money;
	var setAccountNo = function(account_no){this._account_no = account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){this._money=money;}
	var getMoney = function(){return this._money;}
	return {
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		creator_init : function() {
			$("#bt_spec_show").click(member.spec);
			$("#bt_make_account").click(account.open);
			$("#bt_deposit").click(account.deposit);
			$("#bt_withdraw").click(account.withdraw);
		},
		open : function() {
			setAccountNo(Math.floor((Math.random()*899999)+100001));
			setMoney(0);
			$("#account").innerHTML = getAccountNo();
			$(".databox #money").innerHTML = getMoney();
		},
		deposit : function() {
			if(!util.isNumber(getAccountNo())){
				alert('통장부터 만드셈');
				
			}
			setMoney(getMoney() + Number($("input[id=money]").value));
			$(".databox #money").innerHTML = getMoney();
		},
		withdraw : function() {
			if(!util.isNumber(getAccountNo())){
				alert('통장부터 만드셈');
				return;
			}
			var withdraw_money = Number($("input[id=money]").value);	
			if(getMoney() < withdraw_money){
				alert('출금액이 더 큼');
			}else{
				setMoney(getMoney() - withdraw_money);
				$(".databox #money").innerHTML = getMoney();
			}
		}
	};
})();

var member = (function() {
	var _name = '', _ssn='', _gender='', _age=0;
	var setName = function(name){this._name=name;}
	var getName = function(){return this._name;}
	var setSsn = function(ssn){this._ssn=ssn;}
	var getSsn = function(){return this._ssn;}
	var setGender = function(gender){this._gender=gender;}
	var getGender = function(){return this._gender;}
	var setAge = function(age){this._age=age;}
	var getAge = function(){return this._age;}
	return {
		setName : setName,
		getName : getName,
		setSsn : setSsn,
		getSsn : getSsn,
		setGender : setGender,
		getGender : getGender,
		setAge : setAge,
		getAge : getAge,
		
		spec : function() {
			setName($(".formbox #name").value);
			setSsn($("#ssn").value);
			var scode = Number(getSsn().split("-")[1]);
			var ageYear = Number(getSsn().substring(0,2));
			var gen = (scode+2)%2==0? '여':'남';
			console.log('gender',gen);
			setGender(gen);
			console.log('gender',getGender());			
			var nowYear = new Date().getFullYear();
			switch (scode) {
			case 1:	case 2:	case 5:	case 6:
				setAge(nowYear - (1900 + ageYear) + 1);
				break;
			case 9:	case 0:
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

// ==================


//==================grade==================================



