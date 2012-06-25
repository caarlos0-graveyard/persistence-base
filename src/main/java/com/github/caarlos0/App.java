package com.github.caarlos0;

import com.github.caarlos0.dao.AlunoDao;
import com.github.caarlos0.dao.CursoDao;
import com.github.caarlos0.helper.PersistenceHelper;
import com.github.caarlos0.model.Aluno;
import com.github.caarlos0.model.Curso;
import com.google.inject.Injector;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Injector i = PersistenceHelper.getInjector();
        CursoDao dao = i.getInstance(CursoDao.class);
        AlunoDao adao = i.getInstance(AlunoDao.class);

        Curso c = new Curso("foo", 300, new ArrayList<Aluno>());
        dao.save(c);
        c.setDescricao("bar");

        c.adicionaAlunos(new Aluno("Carlos", 20), new Aluno("regis", 23), new Aluno("maoe", 12));

        dao.save(c);

        Curso cc = new Curso("CC", 100, new ArrayList<Aluno>());
        cc.adicionaAlunos(new Aluno("Carlos", 23), new Aluno("josé", 40), new Aluno("Joao da silva", 43));

        dao.save(cc);

        Curso c1 = new Curso("mestrado", 10340, new ArrayList<Aluno>());
        c1.adicionaAlunos(new Aluno("Carlos", 20), new Aluno("maria", 32), new Aluno("lol", 12), new Aluno("regis", 23));

        dao.save(c1);

        System.out.println("\n\n\n");
        System.out.println("TODOS");
        for(Curso cs : dao.findAll()){
            System.out.println(cs);
//            dao.remove(cs);
        }

        System.out.println("\n\nBY ALUNO NAME");
        for(Curso cs : dao.findAllByAlunoName("silva")) {
            System.out.println(cs);
        }

        System.out.println("\n\nBY CARGA HORARIA BETWEEN");
        for(Curso cs : dao.findAllByCargaHorariaBetween(10000, 324000)) {
            System.out.println(cs);
        }

        System.out.println("\n\nBY NAME");
        for(Curso cs : dao.findAllByName("tra")) {
            System.out.println(cs);
        }

        System.out.println("\n\nBY FRIENDS");
        List<String> friends = new ArrayList<String>(){{
            add("Carlos");
            add("regis");
        }};
        for(Curso cs : dao.findAllFriendsCourse(friends)) {
            System.out.println(cs);
        }


        System.out.println("\n\nBY IDADE");
        for(Aluno a : adao.findAllByIdade(18, 25)) {
            System.out.println(a);
        }
    }
}
