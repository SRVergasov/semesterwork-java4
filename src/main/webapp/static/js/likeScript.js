let url = "http://localhost:8080/api/likes/setLike";
let btns = document.querySelectorAll(".btn-outline-danger");
btns.forEach(btn => {
    btn.addEventListener('click', () => {
        let answerId = btn.id.split("_").at(1);
        let username = document.getElementById("username-label").innerText;
        let likesCounterElement = document.getElementById("like_count_answer_" + answerId);
        let likesBefore = parseInt(likesCounterElement.innerText);
        sendLike(answerId, username).then(result => {
            likesCounterElement.innerText = "Likes: " + result.likes;
        });
    });
});

async function sendLike(answerId, username) {
    let like = {
        answerId: answerId,
        username: username
    }
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(like)
    }).catch(exception => {
        console.error("Error with request", exception);
    });
    return await response.json();
}