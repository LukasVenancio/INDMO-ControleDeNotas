package br.senai.controledenotas

fun situacaoAluno(media: Int): String {

    if (media >= 5) {
        return "APROVADO"
    } else {
        return "REPROVADO"
    }
}

fun calcularMedia(vararg notas: Int): Int {

    var soma = 0

    for (nota in notas) {
        soma = soma + nota
    }

    return soma / notas.size
}