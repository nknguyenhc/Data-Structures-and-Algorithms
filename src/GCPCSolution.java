import cs2040s.AVLNode;
import cs2040s.AVLTree;

public class GCPCSolution {
    private static class Team extends AVLNode {
        private int solved = 0;
        private long penalty = 0;

        public Team() {}

        public void update(long penalty) {
            this.solved++;
            this.penalty += penalty;
        }

        @Override
        public int compareTo(AVLNode anotherNode) {
            Team anotherTeam = (Team) anotherNode;
            if (this.solved > anotherTeam.solved) {
                return 1;
            } else if (this.solved < anotherTeam.solved) {
                return -1;
            } else if (this.penalty < anotherTeam.penalty) {
                return 1;
            } else if (this.penalty > anotherTeam.penalty) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private Team[] teams;
    private int favourite;
    private AVLTree tree = new AVLTree();

    public GCPCSolution(int numOfTeams) {
        this(numOfTeams, 1);
    }

    public GCPCSolution(int numOfTeams, int favourite) {
        this.teams = new Team[numOfTeams];
        this.favourite = favourite - 1;
        Team favouriteNode = new Team();
        this.teams[this.favourite] = favouriteNode;
        this.tree.add(favouriteNode);
    }

    public int update(int team, long penalty) {
        Team teamNode = this.teams[team - 1];
        if (teamNode == null) {
            teamNode = new Team();
            this.teams[team - 1] = teamNode;
        }

        teamNode.update(penalty);
        if (this.tree.containsReference(teamNode)) {
            this.tree.resetReference(teamNode);
        } else {
            this.tree.add(teamNode);
        }
        return this.tree.rank(this.teams[this.favourite]);
    }
}
