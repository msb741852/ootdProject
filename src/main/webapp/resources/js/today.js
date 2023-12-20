$(document).ready(function () {
    $('input[name=pastLowTemp]').val($('.low_temp_text').text());
    $('input[name=pastHighTemp]').val($('.high_temp_text').text());
})

$(".btn_ootdAdd").click(function () {
    let input_top = $("#input_top").val();
    let input_bottom = $("#input_bottom").val();
    let input_outer = $("#input_outer").val();
    let input_feedback = $("#input_feedback").val();
    let input_highTemp = $("input[name='pastHighTemp']").val();
    let input_lowTemp = $("input[name='pastLowTemp']").val();

    if(input_top === null) {
        Swal.fire({
            title: "상의를 선택해주세요!"
        });
    } else if(input_bottom === null) {
        Swal.fire({
            title: "하의를 선택해주세요!"
        });
    } else if(input_feedback.trim() === null || input_feedback.trim() === "") {
        Swal.fire({
            title: "피드백을 작성해주세요!"
        });
    } else {
        $.ajax({
            type: "POST",
            headers: {"content-type": "application/json"},
            url: "/today/add",
            data: JSON.stringify({topIdx: input_top, bottomIdx: input_bottom, outerIdx: input_outer, pastFeedback: input_feedback, pastLowTemp: input_lowTemp, pastHighTemp: input_highTemp}),
            success: function(result) {
                Swal.fire({
                    title: `${result}`
                }).then(() => {
                    location.reload();
                })
            },
            error: function () {
                console.log("오늘의 착장 추가 통신 실패");
            }
        })
    }
})
