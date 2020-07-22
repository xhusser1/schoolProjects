	.file	"switch.c"
	.section	.rodata
.LC0:
	.string	"Monday\n"
.LC1:
	.string	"Tuesday\n"
.LC2:
	.string	"Wednesday\n"
.LC3:
	.string	"Thursday\n"
.LC4:
	.string	"Friday\n"
.LC5:
	.string	"Saturday\n"
.LC6:
	.string	"Sunday\n"
.LC7:
	.string	"No such day exists\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movl	$3, -4(%rbp)
	cmpl	$7, -4(%rbp)
	ja	.L2
	movl	-4(%rbp), %eax
	movq	.L4(,%rax,8), %rax
	jmp	*%rax
	.section	.rodata
	.align 8
	.align 4
.L4:
	.quad	.L2
	.quad	.L3
	.quad	.L5
	.quad	.L6
	.quad	.L7
	.quad	.L8
	.quad	.L9
	.quad	.L10
	.text
.L3:
	movl	$.LC0, %edi
	movl	$0, %eax
	call	printf
	jmp	.L11
.L5:
	movl	$.LC1, %edi
	movl	$0, %eax
	call	printf
	jmp	.L11
.L6:
	movl	$.LC2, %edi
	movl	$0, %eax
	call	printf
	jmp	.L11
.L7:
	movl	$.LC3, %edi
	movl	$0, %eax
	call	printf
	jmp	.L11
.L8:
	movl	$.LC4, %edi
	movl	$0, %eax
	call	printf
	jmp	.L11
.L9:
	movl	$.LC5, %edi
	movl	$0, %eax
	call	printf
	jmp	.L11
.L10:
	movl	$.LC6, %edi
	movl	$0, %eax
	call	printf
	jmp	.L11
.L2:
	movl	$.LC7, %edi
	movl	$0, %eax
	call	printf
	nop
.L11:
	movl	$0, %eax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (GNU) 4.8.5 20150623 (Red Hat 4.8.5-39)"
	.section	.note.GNU-stack,"",@progbits
