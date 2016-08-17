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
			document.querySelector('#bt_bom').addEventListener('click',function(){util.move('douglas','bom')},false);
			document.querySelector('#bt_dom').addEventListener('click',function(){util.move('douglas','dom')},false);
			document.querySelector('#bt_kaup').addEventListener('click',function(){util.move('douglas','kaup')},false);
			document.querySelector('#bt_account').addEventListener('click',function(){util.move('douglas','account')},false);	
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
			document.querySelector("#bt_spec_show").addEventListener('click',member.spec,false);
			document.querySelector("#bt_make_account").addEventListener('click',this.open,false);
			document.querySelector("#bt_deposit").addEventListener('click',this.deposit,false);
			document.querySelector("#bt_withdraw").addEventListener('click',this.withdraw,false);
		},
		open : function() {
			setAccountNo(Math.floor((Math.random()*899999)+100001));
			setMoney(0);
			document.querySelector("#account").innerHTML = getAccountNo();
			document.querySelector(".databox #money").innerHTML = getMoney();
		},
		deposit : function() {
			if(!util.isNumber(getAccountNo())){
				alert('통장부터 만드셈');
				
			}
			setMoney(getMoney() + Number(document.querySelector("input[id=money]").value));
			document.querySelector(".databox #money").innerHTML = getMoney();
		},
		withdraw : function() {
			if(!util.isNumber(getAccountNo())){
				alert('통장부터 만드셈');
				return;
			}
			var withdraw_money = Number(document.querySelector("input[id=money]").value);	
			if(getMoney() < withdraw_money){
				alert('출금액이 더 큼');
			}else{
				setMoney(getMoney() - withdraw_money);
				document.querySelector(".databox #money").innerHTML = getMoney();
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
			setName(document.querySelector(".formbox #name").value);
			setSsn(document.querySelector("#ssn").value);
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
			
			document.querySelector('.databox #name').innerHTML = getName();
			document.querySelector('#age').innerHTML = getAge();
			document.querySelector('#gender').innerHTML = getGender();
		}
	};
})();

// ==================

var kaup = (function() {
	return {
		init : function() {
			document.querySelector("#bt_kaup_calc").addEventListener('click',this.calc,false)
		},
		calc : function() {
			var names = document.querySelector('#name').value;
			var height = document.getElementById('height').value;
			var weight = document.getElementById('weight').value;
			var result = '';
			var kaup = weight / ( height / 100) / (height / 100);
			if (kaup < 18.5) {
		         result = "저체중";
		    } else if (kaup >= 18.5 && kaup < 23) {
		         result = "정상체중" ;
		    } else if (kaup >= 23 && kaup < 25) {
		         result = "위험체중" ;
		    } else if (kaup >= 25 && kaup < 30) {
		         result = "비만 1단계" ;
		    } else if (kaup >= 30 && kaup < 40) {
		         result = "비만 2단계" ;
		    }
		     if (kaup >= 40) {
		         result = "비만 3단계" ;
		    }
		     document.querySelector("#result").innerHTML=names +"은 BMI지수는 "+kaup+"이고," +result +"이다.";
		}
	};
})();

//==================grade==================================



