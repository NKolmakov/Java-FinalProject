function adjust_textarea(h) {
    h.style.height = "20px";
    h.style.height = (h.scrollHeight) + "px";
}

var questionNumber = -1;
var answerNumber = 0;
$(function () {
    $("#createQuestion").click(function () {
        var locale = "<locale:message code='button.createQuestion'/>";
        var html2Add =
            "<input hidden value='"+questionNumber++ +"'/>"+
            "<input hidden name='questions[" + questionNumber + "].number' value='" + questionNumber + "'/>" +
            "<input hidden name='answers["+answerNumber+"].questionNumber' value='"+questionNumber+"'>"+
            "<div id='question[" + questionNumber + "]' class='question'>" +
            "<h4>Вопрос № " + (questionNumber + 1) + "</h4>" +
            "<div class='answers' id='answers["+questionNumber+"]'>"+
            "<textarea placeholder='question' name='questions[" + questionNumber + "].text'/><br>" +
            "<input type='checkbox' id='answer_id"+answerNumber+"' name='answers[" + answerNumber + "].status'/>" +
            "<label for='answer_id"+answerNumber+"'></label>" +
            "<input type='text' placeholder='answer' name='answers[" + answerNumber++ + "].answerText'/>" +
            "<input type='button' value='-'><br>" +
            "</div>"+
            "<input type='button' id='"+questionNumber+"' class='createAnswer' value ='" + document.getElementById("button.addAnswer").value + "'/><br>" +
            "</div>";
        $('.questionBlock').prepend(html2Add);
    })
});

$(function () {
    $(".questionBlock").on("click", ".createAnswer", function () {
        var html2Add =
            "<input type='checkbox' id='answer_id" + answerNumber + "' name='answers[" + answerNumber + "].status'/>" +
            "<label for='answer_id"+answerNumber+"'></label>" +
            "<input type='text' placeholder='answer' name='answers[" + answerNumber++ + "].answerText'/>" +
            "<input type='button' value='-'><br>" ;
        var questionId = $(this).attr("id");
        console.log("questionid: "+questionId);
        var element = document.getElementById("answers["+questionId+"]");
        $(element).append(html2Add);
    });
});