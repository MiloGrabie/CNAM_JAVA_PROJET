package projet;

import java.util.ArrayList;
import java.util.List;

public class PageRank {

    public static void main(String[] args) {
        args = "-C -K 21 -E .001 -K 100".split(" ");
        Configuration configuration = configuration(args);
        System.out.println(configuration.toString());
    }

    public static Configuration configuration(String... args) {
        Configuration config = new Configuration();
        initOptions(config);

        return assignOptions(config, args);
    }

    protected static List<PageRankOption> options = new ArrayList<>();

    private static void initOptions(Configuration config) {
        options.add(new PageRankOption("-K", "Valeur de l'indice à calculer", new K_Action(config, true), config));
        options.add(new PageRankOption("-E", "Valeur de la précision à atteindre", new E_Action(config, true), config));
        options.add(new PageRankOption("-A", "Valeur de alpha", new A_Action(config, true), config));
        options.add(new PageRankOption("-C", "Mode matrice creuse", new C_Action(config), config));
        options.add(new PageRankOption("-P", "Mode matrice pleine", new P_Action(config), config));
    }

    private static class K_Action extends PageRankAction {
        public K_Action(Configuration configuration, boolean needValue) {
            super(configuration, needValue);
        }

        @Override
        public void execute(String input) {
            try {
                configuration.indice = Integer.parseInt((String) input);
            } catch (NumberFormatException e) {
                System.out.println("Le format du paramètre -K n'est pas bon");
            }
        }
    }
    private static class E_Action extends PageRankAction {
        public E_Action(Configuration configuration, boolean needValue) {
            super(configuration, needValue);
        }

        @Override
        public void execute(String input) {
            try {
                configuration.epsilon = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Le format du paramètre -E n'est pas bon");
            }
        }
    }
    private static class A_Action extends PageRankAction {
        public A_Action(Configuration configuration, boolean needValue) {
            super(configuration, needValue);
        }

        @Override
        public void execute(String input) {
            try {
                configuration.alpha = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Le format du paramètre -E n'est pas bon");
            }
        }
    }
    private static class C_Action extends PageRankAction {
        public C_Action(Configuration configuration) {
            super(configuration);
        }

        @Override
        public void execute(String input) {
            configuration.mode = Mode.CREUSE;
        }
    }
    private static class P_Action extends PageRankAction {
        public P_Action(Configuration configuration) {
            super(configuration);
        }

        @Override
        public void execute(String input) {
            configuration.mode = Mode.PLEINE;
        }
    }

    private static Configuration assignOptions(Configuration config, String[] args) {

        boolean finOptions = false;
        int i = 0;
        while (i < args.length && !finOptions) {
            String arg = args[i];

            finOptions = arg.length() == 0 || arg.charAt(0) != '-';

            if (finOptions || !options.stream().anyMatch(a->a.acces.equals(arg))) {
                System.out.println("Option inconnue : " + arg);
                continue;
            }

            for(PageRankOption option : options)
                if (option.acces.equals(arg) && option.needValue())
                    option.action.execute(args[++i]);
                else if (option.acces.equals(arg))
                    option.action.execute();

            i++;
        }
        return config;
    }

    private static void setK_Option(String valeur) {

    }
}

