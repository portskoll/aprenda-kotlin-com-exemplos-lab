
enum class NivelFormacao {BASICO, INTERMEDIARIO, AVANCADO}
enum class NivelUsuarioIngles {BASICO, INTERMEDIARIO, AVANCADO}
data class Usuario(val nome: String, val idade: Int, val ingles: NivelUsuarioIngles, val xp: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivelFormacao: NivelFormacao)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val aluno1 = Usuario("João", 22, NivelUsuarioIngles.BASICO, 3000)
    val aluno2 = Usuario("Maria", 45, NivelUsuarioIngles.AVANCADO, 5000)
    val aluno3 = Usuario("Henrique Portella", 52, NivelUsuarioIngles.AVANCADO, 20000)
    val aluno4 = Usuario("Fabio Portella", 52, NivelUsuarioIngles.BASICO, 15000)


    val conteudo1 = ConteudoEducacional("Programação em Kotlin", 120, NivelFormacao.AVANCADO )
    val conteudo2 = ConteudoEducacional("Desenvolvimento Android", 180, NivelFormacao.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Flask", 20, NivelFormacao.BASICO)
    val conteudo4 = ConteudoEducacional("Desenvolvimento Python", 30, NivelFormacao.INTERMEDIARIO)



    val formacao1 = Formacao("Desenvolvimento Mobile", listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Python Backend", listOf(conteudo3, conteudo4))

    formacao1.matricular(aluno1)
    formacao1.matricular(aluno2)

    formacao2.matricular(aluno3)
    formacao2.matricular(aluno4)
    println("Nossos Cursos:")
    println()
    println("Formação: ${formacao1.nome}")
    println("Conteúdos: ${formacao1.conteudos.joinToString { it.nome + " ("+ it.nivelFormacao + ")"}}")
    println("Alunos matriculados: ${formacao1.inscritos.joinToString { it.nome  + " " + it.idade + " anos - XP: " + it.xp}}")
    println()
    println("Formação: ${formacao2.nome}")
    println("Conteúdos: ${formacao2.conteudos.joinToString { it.nome + " ("+ it.nivelFormacao + ")"}}")
    println("Alunos matriculados: ${formacao2.inscritos.joinToString { it.nome  + " " + it.idade + " anos - XP: " + it.xp}}")
}