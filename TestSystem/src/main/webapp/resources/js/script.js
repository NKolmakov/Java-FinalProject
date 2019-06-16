function adjust_textarea(h) {
    h.style.height = "20px";
    h.style.height = (h.scrollHeight) + "px";
}

//todo: создать поле ввода названия теста
var questionNumber = -1;
var answerNumber = 0;
$(function () {
    $("#createQuestion").click(function () {
        var locale = "<locale:message code='button.createQuestion'/>";
        var html2Add =
            "<input hidden value='"+questionNumber++ +"'/>"+
            "<input hidden name='answers["+answerNumber+"].questionNumber' value='"+questionNumber+"'>"+
            "<input hidden name='answers["+answerNumber+"].answerNumber' value='"+answerNumber+"'/>"+
            "<input hidden name='questions[" + questionNumber + "].number' value='" + questionNumber + "'/>" +
            "<div id='question[" + questionNumber + "]' class='question'>" +
                "<h4>Вопрос № " + (questionNumber + 1) + "</h4>" +
                    "<div class='answers' id='answers["+questionNumber+"]'>"+
                        "<input hidden name='answers["+answerNumber+"].questionNumber' value='"+questionNumber+"'>"+
                        "<input hidden name='answers["+answerNumber+"].answerNumber' value='"+answerNumber+"'/>"+

                        "<textarea placeholder='question' name='questions[" + questionNumber + "].text'/><br>" +
                        "<input type='checkbox' id='answer_id"+answerNumber+"' name='answers[" + answerNumber + "].right'/>" +
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
            "<input hidden name='answers["+answerNumber+"].questionNumber' value='"+questionNumber+"'>"+
            "<input hidden name='answers["+answerNumber+"].answerNumber' value='"+answerNumber+"'/>"+
            "<input type='checkbox' id='answer_id" + answerNumber + "' name='answers[" + answerNumber + "].right'/>" +
            "<label for='answer_id"+answerNumber+"'></label>" +
            "<input type='text' placeholder='answer' name='answers[" + answerNumber++ + "].answerText'/>" +
            "<input type='button' value='-'><br>" ;
        var questionId = $(this).attr("id");
        console.log("questionid: "+questionId);
        var element = document.getElementById("answers["+questionId+"]");
        $(element).append(html2Add);
    });
});