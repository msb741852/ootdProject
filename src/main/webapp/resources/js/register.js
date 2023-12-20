function isId(asValue) {
    if(asValue.trim().length === 0 || asValue.length !== asValue.replace(/ /gi,"").length) {
        Swal.fire({
            text: "아이디를 입력해주세요. (공백 x)",
            icon: "error"
        });
        return false;
    }
    let regExp = /^[a-z]+[a-z0-9]{3,11}$/g;
    if(!regExp.test(asValue)) {
        Swal.fire({
            text: "아이디는 영문(+숫자) 4~12자로 만들어주세요.",
            icon: "error"
        });
        return false;
    }
    return true;
}

function isPw(asValue) {
    if(asValue.trim().length === 0 || asValue.length !== asValue.replace(/ /gi,"").length) {
        Swal.fire({
            text: "비밀번호를 입력해주세요. (공백 x)",
            icon: "error"
        });
        return false;
    }
    let regExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
    if(!regExp.test(asValue)) {
        Swal.fire({
            text: "비밀번호를 영문+숫자 8~16자로 만들어주세요.",
            icon: "error"
        });
        return false;
    }
    return true;
}
function isPwChk(asValue) {
    if(asValue.trim().length === 0 || asValue.length !== asValue.replace(/ /gi,"").length) {
        Swal.fire({
            text: "비밀번호 확인란을 입력해주세요. (공백 x)",
            icon: "error"
        });
        return false;
    }
    let regExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
    if(!regExp.test(asValue)) {
        Swal.fire({
            text: "비밀번호를 영문+숫자 8~16자로 만들어주세요.",
            icon: "error"
        });
        return false;
    }
    return true;
}
function isNickname(asValue) {
    if(asValue.trim().length === 0 || asValue.length !== asValue.replace(/ /gi,"").length) {
        Swal.fire({
            text: "닉네임을 입력해주세요. (공백 x)",
            icon: "error"
        });
        return false;
    }
    let regExp = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;
    if(!regExp.test(asValue)) {
        Swal.fire({
            text: "닉네임을 영문/숫자/한글 2~16자로 만들어주세요.",
            icon: "error"
        });
        return false;
    }
    return true;
}


let register_pass = false;

$(document).on('blur', '.password, .password_chk', function() {
    // 패스워드 및 패스워드 확인 칸이 비어있지 않고, 둘의 값이 다를 때
    if(($('.password_chk').val().trim() !== "" && $('.password').val().trim() !== "")
        && ($('.password_chk').val() !== $('.password').val())) {
        Swal.fire({
            text: "비밀번호가 일치하지 않습니다.",
            icon: "error"
        });
        register_pass = false;
    } else {
        register_pass = true;
    }
});

$('.btn_register').on('click', function (e) {
    if(!isId($("input[name='memberId']").val())) {
        e.preventDefault();
    } else if(!isPw($("input.password").val())) {
        e.preventDefault();
    } else if(!isPwChk($("input.password_chk").val())) {
        e.preventDefault();
    } else if(!isNickname($("input[name='memberNickname']").val())) {
        e.preventDefault();
    }
})

