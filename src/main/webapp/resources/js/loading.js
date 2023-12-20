let dt = new Date();
let date =  dt.getFullYear()+'-'+(dt.getMonth()+1)+'-'+dt.getDate();
let setLowHighTemp = () => {
    navigator.geolocation.getCurrentPosition(position => {
        let latitude = position.coords.latitude;
        let longitude = position.coords.longitude;

        const API_KEY = "8d5239160dee3a59639f541c87fc9698";
        fetch(`http://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${API_KEY}&units=metric`)
            .then(response => {
                return response.json();
            })
            .then(json => {
                let currLowTemp = Math.round(json.main.temp_min);
                let currHighTemp = Math.round(json.main.temp_max);

                document.cookie = `pmeTwoLevas=${currLowTemp}; path=/; max-age=86400`;
                document.cookie = `pmeThgiHevas=${currHighTemp}; path=/; max-age=86400`;
                document.cookie = `etaDevas=${date}; path=/; max-age=86400`;
                console.log("API 실행");
                location.replace('/home');
            });
    });
}


let getAndSetCookie = () => {
    let cookie_arr = document.cookie.split(";");
    for(let i = 0; i < cookie_arr.length; i++) {
        let c_arr = cookie_arr[i].split("=");
        if(c_arr[0].trim() === "etaDevas") {
            if(c_arr[1] !== date) {
                // 저장된 날짜와 오늘 날짜가 다를 경우
                // 쿠키에 저장된 날짜와 현재 날짜가 다를 경우 온도, 날짜 재저장
                setLowHighTemp();
                return 0;
            } else {
                // 쿠키에 저장되어 있는 날짜가 오늘 날짜와 같을 경우
                location.replace('/home');
                return 0;
            }
        }
    }
    // 쿠키에 날짜 쿠키 자체가 없을 때
    setLowHighTemp();
};
getAndSetCookie();


