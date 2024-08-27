//현재 url 주소 복사
let nowUrl = window.location.href;

function copyUrl(){
    //nowUrl 변수에 담긴 주소를
    navigator.clipboard.writeText(nowUrl).then(res=>{
        alert("주소가 복사되었습니다!");
    })
}

function deleteInquiryCheck() {
    var inquiryNo = document.getElementById('inquiryNo').value;
    localStorage.setItem('inquiryNo', inquiryNo);

    var url = "/inquiry/delete/check";
    window.location.href = url;
}