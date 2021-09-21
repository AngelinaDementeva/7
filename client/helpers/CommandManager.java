// 
// Decompiled by Procyon v0.5.36
// 

package helpers;

import java.util.List;
import java.util.NoSuchElementException;
import commands.Print_unique_official_address;
import commands.Filter_greater_than_annual_turnover;
import commands.Count_by_full_name;
import commands.Remove_greater;
import commands.Add_if_min;
import commands.Remove_first;
import commands.Execute_script;
import commands.Clear;
import commands.CheckerID;
import commands.Add;
import commands.Show;
import commands.Info;
import commands.Help;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommandManager
{
    private String command;
    private String[] commandUser;
    
    public CommandManager(CollectionChecker collectionChecker) {
        this.command = "";
    }
    
    public void cmdMode() {
        try (final Scanner cmdreader = new Scanner(System.in)) {
            while (!this.command.equals("exit")) {
                System.out.println("Enter a command: ");
                this.command = cmdreader.nextLine();
                this.commandUser = this.command.trim().toLowerCase().split(" ", 2);
                final List<String> specialCommands = new ArrayList<String>(Arrays.asList("execute_script", "count_by_full_name"));
                if (!specialCommands.contains(this.commandUser[0]) && this.commandUser.length > 1) {
                    int t1 = -1;
                    try {
                        t1 = Integer.parseInt(this.commandUser[1]);
                    }
                    catch (Exception e2) {
                        System.out.println("Error the argument must be an Integer!");
                        continue;
                    }
                }
                try {
                    System.out.println(this.commandUser[0]);
                    final String s = this.commandUser[0];
                    switch (s) {
                        case "": {
                            continue;
                        }
                        case "help": {
                            final Help help = new Help();
                            help.help();
                            continue;
                        }
                        case "info": {
                            final Info info = new Info();
                            info.info();
                            continue;
                        }
                        case "show": {
                            final Show show = new Show();
                            show.show();
                            continue;
                        }
                        case "add": {
                            final Add add = new Add();
                            add.add();
                            continue;
                        }
                        case "update_id": {
                            final CheckerID checkerID = new CheckerID();
                            checkerID.checker(this.commandUser[1], "update_id");
                            continue;
                        }
                        case "remove_by_id": {
                            final CheckerID checkerID = new CheckerID();
                            checkerID.checker(this.commandUser[1], "remove_by_id");
                            continue;
                        }
                        case "clear": {
                            final Clear clear = new Clear();
                            clear.clear();
                            continue;
                        }
                        case "execute_script": {
                            final Execute_script execute_script = new Execute_script();
                            execute_script.execute_script(this.commandUser[1]);
                            continue;
                        }
                        case "exit": {
                            System.out.println("Thanks for using my program!");
                            System.exit(1);
                            continue;
                        }
                        case "remove_first": {
                            final Remove_first remove_first = new Remove_first();
                            remove_first.remove_first();
                            continue;
                        }
                        case "add_if_min": {
                            final Add_if_min add_if_min = new Add_if_min();
                            add_if_min.add_min(this.commandUser[1]);
                            continue;
                        }
                        case "remove_greater": {
                            final Remove_greater remove_greater = new Remove_greater();
                            remove_greater.remove_annual(this.commandUser[1]);
                            continue;
                        }
                        case "count_by_full_name": {
                            final Count_by_full_name count_by_full_name = new Count_by_full_name();
                            count_by_full_name.count(this.commandUser[1]);
                            continue;
                        }
                        case "filter_greater_than_annual_turnover": {
                            final Filter_greater_than_annual_turnover filter_turnover = new Filter_greater_than_annual_turnover();
                            filter_turnover.filter_annual_turnover(this.commandUser[1]);
                            continue;
                        }
                        case "print_unique_official_address": {
                            final Print_unique_official_address print_unique_official_address = new Print_unique_official_address();
                            print_unique_official_address.print_unique_official_address();
                            continue;
                        }
                        default: {
                            System.out.println("Unknown commmand. Try again! Write 'help' for list of available commands.");
                            continue;
                        }
                    }
                }
                catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Element is not present in the array. Try again! Write 'help' for list of available commands.");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program was stopped!" + noSuchElementException.getMessage());
            System.exit(1);
        }
    }
}
