// Modify this file for your assignment
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <string.h>
#include <unistd.h>
#define MAXCOM 80 // max number of letters to be supported
#define MAXLIST 100 // max number of commands to be supported

// Clearing the shell using escape sequences
#define clear() printf("\033[H\033[J")

// Greeting shell during startup
void init_shell(){
        clear();
        printf("\n\n\n\n******************"
                "************************");
        printf("\n\n\n\t****Xavier's Shell****");
        printf("\n\n\t-USE AT YOUR OWN RISK-");
        printf("\n\n\n\n*******************"
                "***********************");
        char* username = getenv("USER");
        printf("\n\n\nUSER is: @%s", username);
        printf("\n");
        sleep(3);
        clear();
}

// Function to take input
int takeInput(char* str) {
	printf("mini-shill >>>>>");

	fgets(str, MAXCOM, stdin);

	if (strlen(str) > 0){
		size_t len = strlen(str);
		if (len > 0 && str[len-1] == '\n'){
			str[--len] = '\0';
		}
		return 0;
	} else {
		return 1;
	}
}
// Function to print Current Directory.
void printDir(){
        char pwd[1024];
        getcwd(pwd, sizeof(pwd));
        printf("\nDirectory: %s", pwd);
}

// create signal handler
void signal_handler(int sig){
	write(1, "Xavier's shell is terminating", 35);
	exit(0);
}

int guessingGame() {
        srand(time(0));
        int gameRounds[5];
        int randomNum = rand() % 10 + 1;
        int guess;
        int i = 0;
        int j = 0;
        //main game for loop for the rounds
        for (; i < 5; i++) {
                printf("==========================\n");
                printf("CPU Says: Pick a number 1-10\n");
                printf("==========================\n");
                gameRounds[i] = 0;
                //gameRounds[i] stores the guesses and increments the while loop
                while (gameRounds[i] < 10) {
                        printf("Make a guess between 1-10: ");
                        scanf("%d", &guess);
                        gameRounds[i]++;
                        if (guess == randomNum) {
                                printf("You won!\n");
                                break;
                        }else if (guess < randomNum) {
                                printf("number is too low guess higher\n");
                                continue;
                        }else if (guess > randomNum) {
                                printf("Number is too high guess lower\n");
                        }else {
                                printf("Sorry. Please choose valid number");
                                continue;
                        }
                }
        }
        printf("Here are the results of your guessing abilities\n");
        //iterate for game history and access the value of gameRounds at j index
        for (; j < 5; j++) {
                printf("Game %d took you %d guesses\n", j, gameRounds[j]);
        }
	return 0;
}

// Function where the system command is executed
void execArgs(char** parsed){
        // Forking a child
        pid_t pid = fork();

        if (pid == -1) {
                printf("\nFailed forking child..");
                return;
        } else if (pid == 0) {
                if (execvp(parsed[0], parsed) < 0) {
                        printf("\nCould not execute command..");
                }
                exit(0);
        } else {
                // waiting for child to terminate
                wait(NULL);
                return;
        }
}

// Function where the piped system commands is executed
void execArgsPiped(char** parsed, char** parsedpipe){
        // 0 is read end, 1 is write end
        int pipefd[2];
        pid_t p1, p2;

        if (pipe(pipefd) < 0) {
                printf("\nPipe could not be initialized");
                return;
        }
        p1 = fork();
        if (p1 < 0) {
                printf("\nCould not fork");
                return;
        }

        if (p1 == 0) {
                // Child 1 executing..
                // It only needs to write at the write end
                close(pipefd[0]);
                dup2(pipefd[1], STDOUT_FILENO);
                close(pipefd[1]);

                if (execvp(parsed[0], parsed) < 0) {
                        printf("\nCould not execute command 1..");
                        exit(0);
                }
        } else {
                // Parent executing
                p2 = fork();

                if (p2 < 0) {
                        printf("\nCould not fork");
                        return;
                }

                // Child 2 executing..
                // It only needs to read at the read end
                if (p2 == 0) {
                        close(pipefd[1]);
                        dup2(pipefd[0], STDIN_FILENO);
                        close(pipefd[0]);
                        if (execvp(parsedpipe[0], parsedpipe) < 0) {
                                printf("\nCould not execute command 2..");
                                exit(0);
                      	}
                } else {
                        // parent executing, waiting for two children 
                        wait(NULL);
                        wait(NULL);
                }
        }
}


// Help command builtin
void openHelp(){
        puts("\n***WELCOME TO Xavier's Help***"
                "\n-Use the shell at your own risk..."
                "\nList of Commands supported:"
                "\n>cd"
                "\n>guessingGame"
                "\n>exit"
                "\n>all other general commands available in UNIX shell"
                "\n>pipe handling"
                "\n>improper space handling");

        return;
}

// Function to execute builtin commands
int commandHandler(char** parsed){
        int NotCommand = 4, i, switchOwnArg = 0;
        char* ListOfCommands[NotCommand];
        char* username;

        ListOfCommands[0] = "exit";
        ListOfCommands[1] = "cd";
        ListOfCommands[2] = "guessingGame";
        ListOfCommands[3] = "help";

        for (i = 0; i < NotCommand; i++) {
                if (strcmp(parsed[0], ListOfCommands[i]) == 0) {
                        switchOwnArg = i + 1;
                        break;
                }
        }
	
//	if (switchOwnArg == " "){
//		printDir();
//	}

        if (switchOwnArg == 1){
                printf("\nGoodbye\n");
                exit(0);
	}
	//add if statements
        if (switchOwnArg == 2){
                chdir(parsed[1]);
                return 1;
	}
        if (switchOwnArg == 3){
                guessingGame();
                return 1;
	}
        if (switchOwnArg == 4){
               openHelp();
                return 1;
	} else{
		printf("Command not found--Did you mean something else?");
		return 1;

	}
        return 0;
}


// function for finding pipe 
int parsePipe(char* str, char** strpiped){
        int i;
        for (i = 0; i < 2; i++) {
                strpiped[i] = strsep(&str, "|");
                if (strpiped[i] == NULL)
                        break;
        }

        if (strpiped[1] == NULL)
                return 0; // returns zero if no pipe is found. 
        else {
                return 1;
        }
}

// function for parsing command words 
void parseSpace(char* str, char** parsed){
        int i;

        for (i = 0; i < MAXLIST; i++) {
                parsed[i] = strsep(&str, " ");

                if (parsed[i] == NULL)
                        break;
                if (strlen(parsed[i]) == 0)
                        i--;
        }
}

int processString(char* str, char** parsed, char** parsedpipe){

        char* strpiped[2];
        int piped = 0;

        piped = parsePipe(str, strpiped);

        if (piped) {
                parseSpace(strpiped[0], parsed);
                parseSpace(strpiped[1], parsedpipe);

        } else {

                parseSpace(str, parsed);
        }

        if (commandHandler(parsed))
                return 0;
        else
                return 1 + piped;
}

int main(){

	char inputString[MAXCOM], *parsedArgs[MAXLIST];
        char* parsedArgsPiped[MAXLIST];
        int execFlag = 0;
        init_shell();
        signal(SIGINT, signal_handler);

        printf("You can terminate by using Ctrl + C");

        while (1){

                if (takeInput(inputString))
                        continue;
                execFlag = processString(inputString,
                parsedArgs, parsedArgsPiped);
                if (execFlag == 1)
                        execArgs(parsedArgs);

                if (execFlag == 2)
                        execArgsPiped(parsedArgs, parsedArgsPiped);
        }
        return 0;
}
