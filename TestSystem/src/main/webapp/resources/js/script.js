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
            "<input hidden value='" + questionNumber++ + "'/>" +
            "<input hidden name='answers[" + answerNumber + "].questionNumber' value='" + questionNumber + "'>" +
            "<input hidden name='answers[" + answerNumber + "].answerNumber' value='" + answerNumber + "'/>" +
            "<input hidden name='questions[" + questionNumber + "].number' value='" + questionNumber + "'/>" +

            "<div id='question[" + questionNumber + "]' class='question'>" +
                "<h4>Вопрос № " + (questionNumber + 1) +
                    "<input type='button' id='"+questionNumber+"' class='removeQuestion' value='-'/>"+
                "</h4>" +
                    "<div class='answers' id='answers[" + questionNumber + "]'>" +
                        "<textarea placeholder='question' name='questions[" + questionNumber + "].text'/><br>" +
                        "<input hidden name='answers[" + answerNumber + "].questionNumber' value='" + questionNumber + "'>" +
                        "<input hidden name='answers[" + answerNumber + "].answerNumber' value='" + answerNumber + "'/>" +
                        "<input type='checkbox' id='answer_id" + answerNumber + "' name='answers[" + answerNumber + "].right'/>" +
                        "<label id='label_id" + answerNumber + "' for='answer_id" + answerNumber + "'></label>" +
                        "<input type='text' id='text_id" + answerNumber++ + "' placeholder='answer' name='answers[" + answerNumber + "].answerText'/>" +
                        // "<input type='button' id='"+answerNumber++ +"' class='removeAnswer' value='-'><br>" +
                    "</div>" +
                "<input type='button' id='" + questionNumber + "' class='createAnswer' value ='" + document.getElementById("button.addAnswer").value + "'/><br>" +
            "</div>";
        $('.questionBlock').prepend(html2Add);
    })
});

$(function () {
    $(".questionBlock").on("click", ".createAnswer", function () {
        var html2Add =
            "<div id='div_id" + answerNumber + "'>" +
            "<input hidden name='answers[" + answerNumber + "].questionNumber' value='" + questionNumber + "'>" +
            "<input hidden name='answers[" + answerNumber + "].answerNumber' value='" + answerNumber + "'/>" +
            "<input type='checkbox' id='answer_id" + answerNumber + "' name='answers[" + answerNumber + "].right'/>" +
            "<label id='label_id" + answerNumber + "' for='answer_id" + answerNumber + "'></label>" +
            "<input type='text' id='text_id" + answerNumber + "' placeholder='answer' name='answers[" + answerNumber + "].answerText'/>" +
            "<input type='button' id='" + answerNumber++ + "' class='removeAnswer' value='-'><br>" +
            "</div>";
        var questionId = $(this).attr("id");
        var element = document.getElementById("answers[" + questionId + "]");
        $(element).append(html2Add);
    });
});

$(function () {
    $(".questionBlock").on("click", ".removeAnswer", function () {
        var currentAnswerId = $(this).attr("id");
        var div2Delete = document.getElementById("div_id" + currentAnswerId);
        $(div2Delete).remove();
        answerNumber--;
    })
});

$(function () {
    $(".questionBlock").on("click", ".removeQuestion", function () {
        var currentQuestionId = $(this).attr("id");
        var div2Delete = document.getElementById("question[" + currentQuestionId+"]");
        $(div2Delete).remove();
        questionNumber--;
    })
});