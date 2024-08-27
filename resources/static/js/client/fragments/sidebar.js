// 토글 기능 함수
function toggleBoards(event) {
    event.stopPropagation(); // 클릭 이벤트의 전파를 막음
    const categoryContainer = event.currentTarget.closest('.category-container');
    const boardsElement = categoryContainer.querySelector('.boards');

    if (boardsElement.style.display === 'none' || boardsElement.style.display === '') {
        boardsElement.style.display = 'block';
        event.currentTarget.classList.add('expanded');
    } else {
        boardsElement.style.display = 'none';
        event.currentTarget.classList.remove('expanded');
    }
}

// 페이지가 로드될 때 토글 버튼에 클릭 이벤트를 추가
document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('.toggle-button').forEach(button => {
        button.addEventListener('click', toggleBoards);
    });

    // 페이지 로드 시 모든 게시판을 기본적으로 숨김
    document.querySelectorAll('.boards').forEach(boards => {
        boards.style.display = 'none';
    });
});
