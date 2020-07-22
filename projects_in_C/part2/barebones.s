# Build an executable using the following:
#
# clang barebones.s -o barebones  # clang is another compiler like gcc
#
.text
_barebones:

.data
	
.globl main

main:
					# (1) What are we setting up here?
					# Ans:
	pushq %rbp			# using base pointer 
	movq  %rsp, %rbp		# saving address of previous stack frame.

					# (2) What is going on here
					# Ans:
	movq $1, %rax			# moving 1 to %rax
	movq $1, %rdi			# write to stdout
	leaq .hello.str,%rsi		# set register address of the string


					# (3) What is syscall? We did not talk about this
					# in class.
					# Ans: transfers control to operating system
					# to perform requested service 
	syscall				# Which syscall is being run?
					# Ans: write to the file handle (stdout)

					# (4) What would another option be instead of 
					# using a syscall to achieve this?
					# Ans: doing a function call.

	movq	$60, %rax		# (5) We are again setting up another syscall
	movq	$0, %rdi		# What command is it?
					# Ans: exit syscall 1 and return 0.	
	syscall

	popq %rbp			# (Note we do not really need
					# this command here after the syscall)

.hello.str:
	.string "Hello World!\n"
	.size	.hello.str,13		# (6) Why is there a 13 here?
					# Ans: to print first 12 characters.	
