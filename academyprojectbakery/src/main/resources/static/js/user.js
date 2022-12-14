let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		/*$("#btn-login").on("click",()=>{
			this.login();
		});*/
		$("#btn-update").on("click", () => {
			this.update();
		});
	},
	save: function() {
		//alert('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};

		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			console.log(data);
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}

}


index.init();
