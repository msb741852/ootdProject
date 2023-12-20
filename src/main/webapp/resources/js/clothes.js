checked_tab = $("input[type='radio']:checked + label").text();
clothType = "cloth_top";

let toHtml = (rs) => {
    let html_txt = "";
    rs.forEach(content => {
        html_txt +=`<li class="clothes_item" data-idx="${content.idx}">
            <span>${content.clothName}</span>
            <div class="btn_box">
                <i class="fa-solid fa-pen-to-square btn_edit"></i>
                <i class="fa-solid fa-trash btn_delete"></i>
            </div>
        </li>`
    });
    return html_txt;
}

let request_list = (clothType) => $.ajax({
    type: "POST",
    url: "/clothes/read/list",
    data: {clothType: clothType},
    success: function(result) {
            $('.clothes_list').html(toHtml(result));
    },
    error: function () {
        console.log("옷 리스트 불러오기 실패");
    }
});
// 처음에 한 번 실행
request_list(clothType);

// 탭 버튼 변경될 때마다 실행
$(document).on('change', 'input[type="radio"]', function() {
    checked_tab = $("input[type='radio']:checked + label").text();
    clothType = "";
    switch (checked_tab) {
        case '상의' :
            clothType = "cloth_top";
            break;
        case '하의' :
            clothType = "cloth_bottom";
            break;
        case '아우터' :
            clothType = "cloth_outer";
            break;
    }
    // 탭 변경시 실행
    request_list(clothType);
})

$(".btn_clothesAdd").on('click', function () {
    Swal.fire({
        title: `${checked_tab} 추가하기`,
        input: "text",
        inputAttributes: {
            autocapitalize: "off"
        },
        showCancelButton: true,
        confirmButtonText: "추가하기",
        cancelButtonText:"취소",
        showLoaderOnConfirm: true,
        preConfirm: (clothName) => $.ajax({
            type: "POST",
            url: "/clothes/add",
            dataType: "text",
            data: {clothName: clothName, clothType: clothType},
            success: function(result) {
                Swal.fire({
                    title: `${result}`
                }).then(() => {
                    request_list(clothType);
                })
            },
            error: function () {
                console.log("옷 추가 통신 실패");
            }
        })
    });
});

// 삭제 버튼 클릭 시
$(document).on('click', '.btn_delete', function () {
    let idx = $(this).parent().parent().data('idx');
    Swal.fire({
        title: "정말로 삭제하시겠습니까?",
        text: "삭제시 되돌릴 수 없습니다.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: "삭제하기",
        cancelButtonText: "취소",
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                type: "POST",
                url: "/clothes/del",
                dataType: "text",
                data: {idx: idx, clothType: clothType},
                success: function(result) {
                    Swal.fire({
                        title: `${result}`
                    }).then(() => {
                        request_list(clothType);
                    })
                },
                error: function () {
                    console.log("옷 삭제 통신 실패");
                }
            })
        }
    });
})

// 수정 버튼 클릭 시
$(document).on('click', '.btn_edit', function () {
    let idx = ($(this).parent().parent().data('idx'));
    Swal.fire({
        title: `별칭 수정하기`,
        input: "text",
        inputValue: `${$(this).parent().prev().text()}`,
        inputAttributes: {
            autocapitalize: "off"
        },
        showCancelButton: true,
        confirmButtonText: "수정하기",
        cancelButtonText:"취소",
        showLoaderOnConfirm: true,
        preConfirm: (clothName) => $.ajax({
            type: "POST",
            url: "/clothes/edit",
            dataType: "text",
            data: {idx: idx, clothName: clothName, clothType: clothType},
            success: function(result_text) {
                Swal.fire({
                    title: `${result_text}`
                }).then(() => {
                    request_list(clothType);
                })
            },
            error: function () {
                console.log("옷 수정 통신 실패");
            }
        })
    });
});


