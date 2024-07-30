package gui;

import game.competition.Competition;
import game.competition.SkiCompetition;
import game.arena.IArena;
import game.arena.WinterArena;
import game.enums.WeatherCondition;
import game.enums.SnowSurface;
import model.CompetitorImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitionGUI extends JFrame {
    private Competition competition;
    private JPanel arenaPanel;
    private JTextArea infoTextArea;

    public CompetitionGUI(Competition competition) {
        this.competition = competition;
        setTitle("Competition Simulator");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());

        // Arena Panel
        arenaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }

        };
    }
}