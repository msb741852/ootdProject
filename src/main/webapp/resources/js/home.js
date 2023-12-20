let swiper = new Swiper(".mySwiper", {
    effect: "cards",
    grabCursor: true,
    loop: true,
});

let toHtml = (result) => {
    let txt = "";
    if(result.length !== 0) {
        result.forEach( content => {
            txt += `<div class="swiper-slide">
                <div class="temp_section">
                  <div class="low_temp">최저 기온: ${content.pastLowTemp}°C</div>
                  <div class="high_temp">최고 기온: ${content.pastHighTemp}°C</div>
                </div>
                <div class="clothes_info_section">
                  <div class="top_info">상의: ${content.cloth_top}</div>
                  <div class="bottom_info">하의: ${content.cloth_bottom}</div>
                  <div class="outer_info">아우터: ${content.cloth_outer}</div>
                </div>
                <div class="feedback_section">
                  ${content.pastFeedback}
                </div>
            </div>
            `
        })
    } else {
        txt += `<div class="swiper-slide">해당 기온에 추천할 데이터가 없습니다.</div>`
    }
    return txt;
}
let get_list = () => {
    $.ajax({
        type: "POST",
        url: "/home/read/recommend",
        success: function (result) {
            $('.swiper-wrapper').html(toHtml(result));
            swiper.update();
        },
        error: function () {
            console.log("옷 추천 리스트 불러오기 실패");
        }
    });
}
get_list();