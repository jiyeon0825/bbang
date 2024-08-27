//현재 url 변수로 가져오기
let nowUrl = window.location.href;

function copyUrl(){
    //nowUrl 변수에 담긴 주소를
    navigator.clipboard.writeText(nowUrl).then(res=>{
        alert("주소가 복사되었습니다.");
    })
}

function postReportPopup() {
    var url = "/report/add/post";
    var options = "width=300, height=400, left=300, top=50";
    var popup = window.open(url, "ReportPopup", options);

}

// function openEditPopup() {
//     var url = "/post/edit/check";
//     var popup = window.open(url, "EditPopup");
// }

// function openDeletePopup() {
//     var url = "/post/delete/check";
//     var popup = window.open(url, "DeletePopup");
// }

// popup.onload = function() {
//     popup.document.getElementById('postNo').value = postNo;
//     // popup.document.getElementById('postPassword').value = postPassword;
// };

function editPostCheck() {
    var postNo = document.getElementById('postNo').value;
    localStorage.setItem('postNo', postNo);

    var url = "/post/edit/check";
    window.location.href = url;
}

function deletePostCheck() {
    var postNo = document.getElementById('postNo').value;
    localStorage.setItem('postNo', postNo);

    var url = "/post/delete/check";
    window.location.href = url;
}