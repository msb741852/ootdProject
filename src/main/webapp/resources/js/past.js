let month = "";

let toHtml = (rs) => {
    let html_txt = "";


    rs.forEach(content => {
        html_txt +=`<li class="past_ootd_item" data-idx="${content.pastIdx}">
                <div class="temp_box">
                  <div class="low_temp">최저 기온: ${content.pastLowTemp}°C</div>
                  <div class="high_temp">최고 기온: ${content.pastHighTemp}°C</div>
                </div>
                <div class="ootd_info_box">
                  <div class="top_info">상의: ${content.cloth_top}</div>
                  <div class="bottom_info">하의: ${content.cloth_bottom}</div>
                  <div class="outer_info">아우터: ${content.cloth_outer}</div>
                  <div class="feedback_info">피드백: <span class="feedback_text">${content.pastFeedback}</span></div>
                </div>
                <div class="dateAndBtn_box">
                    <span class="date_box">${new Date(content.pastDate).getFullYear() + "-" + ((new Date(content.pastDate).getMonth() + 1) < 10 ? "0"+(new Date(content.pastDate).getMonth() + 1) : (new Date(content.pastDate).getMonth() + 1)) + "-" + (new Date(content.pastDate).getDate() < 10 ? "0" + new Date(content.pastDate).getDate() : new Date(content.pastDate).getDate())}</span>
                    <div class="btn_box">
                      <i class="fa-solid fa-pen-to-square btn_edit"></i>
                      <i class="fa-solid fa-trash btn_delete"></i>
                    </div>
                </div>
              </li>`
    });
    return html_txt;
}

let get_list = () => {
    $.ajax({
        type: "POST",
        url: "/past/read/list",
        headers: {"content-type": "application/json"},
        data: JSON.stringify({pastDate: month}),
        success: function (result) {
            if(result.length !== 0) {
                $('.past_ootd_list').html(toHtml(result));
            } else {
                if($('.introduce_text').length) {
                    // introduce_text 클래스를 가진 요소가 존재할 경우
                    $('.introduce_text').text("해당 데이터가 없습니다.");
                } else {
                    $('.past_ootd_list').html(`<li class="introduce_text">해당 데이터가 없습니다.</li>`);
                }
            }
        },
        error: function () {
            console.log("실패");
        }
    })
}

$(".month_select").on('change', function () {
    month = $('.month_select').val();
    get_list();
});

$(document).on('click', '.btn_delete', function() {
    let idx = $(this).parent().parent().parent().data("idx");
    $.ajax({
        type: "POST",
        url: "/past/delete/item",
        data: {pastIdx: idx},
        success: function (result) {
            get_list();
            Swal.fire({
                text: `${result}`,
                icon: "success"
            }).then( () => {
                get_list();
            });
        },
        error: function () {
            console.log("실패");
        }
    })
});

$(document).on('click', '.btn_edit', function () {
    let idx = $(this).parent().parent().parent().data("idx");
    let topName = $(this).parent().parent().prev().children(".top_info").text();
    let bottomName = $(this).parent().parent().prev().children(".bottom_info").text();
    let outerName = $(this).parent().parent().prev().children(".outer_info").text();
    let feedback = $(this).parent().parent().prev().children(".feedback_info").children(".feedback_text").text();

    $.ajax({
        type: "POST",
        url: "/past/read/clothes",
        success: async function (result) {
            let cloth_top_txt = "";
            for(let i = 0; i < result.cloth_top.length; i++) {
                if(topName.includes(result.cloth_top[i].clothName)) {
                    cloth_top_txt += `<option value="${result.cloth_top[i].idx}" selected>${result.cloth_top[i].clothName}</option>`
                } else {
                    cloth_top_txt += `<option value="${result.cloth_top[i].idx}">${result.cloth_top[i].clothName}</option>`;
                }
            }
            let cloth_bottom_txt = "";
            for(let i = 0; i < result.cloth_bottom.length; i++) {
                if(bottomName.includes(result.cloth_bottom[i].clothName)) {
                    cloth_bottom_txt += `<option value="${result.cloth_bottom[i].idx}" selected>${result.cloth_bottom[i].clothName}</option>`
                } else {
                    cloth_bottom_txt += `<option value="${result.cloth_bottom[i].idx}">${result.cloth_bottom[i].clothName}</option>`;
                }
            }
            let cloth_outer_txt = "";
            for(let i = 0; i < result.cloth_outer.length; i++) {
                if(outerName.includes(result.cloth_outer[i].clothName)) {
                    cloth_outer_txt += `<option value="${result.cloth_outer[i].idx}" selected>${result.cloth_outer[i].clothName}</option>`
                } else {
                    cloth_outer_txt += `<option value="${result.cloth_outer[i].idx}">${result.cloth_outer[i].clothName}</option>`;
                }
            }

            const { value: formValues } = await Swal.fire({
                title: "지난 착장 수정",
                html: `
                    <div class="input_box">
                        <select name="topIdx" id="input_top" required>
                            <option value="" class="cloth_top_item" disabled selected>상의를 선택해주세요.</option>
                            ${cloth_top_txt}
                        </select>
                    </div>
                    <div class="input_box">
                        <select name="bottomIdx" id="input_bottom" required >
                            <option value="" class="cloth_bottom_item" disabled selected>하의를 선택해주세요.</option>
                            ${cloth_bottom_txt}
                        </select>
                    </div>
                    <div class="input_box">
                        <select name="outerIdx" id="input_outer">
                            <option value="" class="cloth_outer_item" disabled selected>외투를 선택해주세요.</option>
                            ${cloth_outer_txt}
                        </select>
                    </div>
                    <div class="input_box">
                        <input type="text" name="pastFeedback" id="input_feedback" placeholder="피드백을 작성해주세요." value='${feedback}' required>
                    </div>
                  `,
                showCancelButton: true,
                confirmButtonText: "수정하기",
                cancelButtonText:"취소",
                preConfirm: () => {
                    topName = $('#input_top').val();
                    bottomName = $('#input_bottom').val();
                    outerName = $('#input_outer').val();
                    feedback = $('#input_feedback').val();
                }
            });
            if (formValues) {
                $.ajax({
                    type: "POST",
                    url: "/past/update",
                    data: {pastIdx: idx, topIdx: topName, bottomIdx: bottomName, outerIdx: outerName, pastFeedback: feedback},
                    success: function (result) {
                        Swal.fire({
                            text: `${result}`,
                            icon: "success"
                        }).then( () => {
                            get_list();
                        });
                    },
                    error: function () {
                        console.log("실패");
                    }
                })
            }
        },
        error: function () {
            console.log("실패");
        }
    })

});

let dt = new Date();
$('.month_select').val(dt.getMonth() + 1).ready(() => {
    month = dt.getMonth() + 1;
    get_list();
});