const checkboxes=document.querySelectorAll(".option>input[name='answer']");
const checkBtn=document.getElementById("checkBtn");

const csrfHeaderName = document.head.querySelector('[name=_csrf_header]').content;
const csrfHeaderValue = document.head.querySelector('[name=_csrf]').content;


checkBtn.addEventListener("click", check)

async function check(ev){
    ev.preventDefault();

    const questionId=document.querySelector(".question").id;

    const checked=[];

    for (const checkbox of checkboxes) {
        if(checkbox.checked){
            checked.push(checkbox.id);
        }
    }

    const options={
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accepts': 'application/json',
            [csrfHeaderName]: csrfHeaderValue
        },
        body: JSON.stringify({
            questionId,
            checked
        })
    };

    await fetch("http://localhost:8080/api/questions/check", options);
    window.location="/"
}