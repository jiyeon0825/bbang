window.onload = function() {
    var postNo = window.opener.document.getElementById('postNo').value;

    // 히든 필드에 postNo 값을 설정
    document.getElementById('postNo').value = postNo;

    // 폼의 액션을 동적으로 설정
    var form = document.getElementById('reportForm');
    form.action = "/report/add/post/" + postNo;

    form.addEventListener("submit", function() {
        // 폼이 정상적으로 제출된 후 창을 닫기 위해 타이머를 사용
        setTimeout(function() {
            window.close();
        }, 100); // 100ms 대기 후 창 닫기
    });

}

