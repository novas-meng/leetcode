import math

'''
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
'''
class ListNode(object):
	def __init__(self, x):
		self.val = x
		self.next = None

def printListNode(l1):
	p=l1
	while(p != None):
		print(p.val)
		p=p.next

def add(l1,l2):
	p1=l1
	p2=l2
	head=ListNode(-1)
	p=head
	jinwei=0
	while (p1 != None and p2 != None):
		sum=int(p1.val+p2.val+jinwei)
		jinwei=math.floor(sum/10)
		v=sum%10
		res=ListNode(v)
		p.next=res
		p=p.next
		p1=p1.next
		p2=p2.next

	while (p1 != None):
		sum=int(p1.val+jinwei)
		jinwei=math.floor(sum/10)
		v=sum%10
		res=ListNode(v)
		p.next=res
		p=p.next
		p1=p1.next
	
	while (p2 != None):
		sum=int(p2.val+jinwei)
		jinwei=math.floor(sum/10)
		v=sum%10
		res=ListNode(v)
		p.next=res
		p=p.next
		p2=p2.next

	if jinwei != 0:
		p.next=ListNode(jinwei)

	return head.next

if __name__=='__main__':
	l1=ListNode(5)
	'''
	l1_1=ListNode(4)
	l1.next=l1_1
	l1_2=ListNode(8)
	l1_1.next=l1_2
	l1_3=ListNode(4)
	l1_2.next=l1_3
	'''

	l2=ListNode(5)
	'''
	l2_1=ListNode(6)
	l2.next=l2_1
	l2_2=ListNode(4)
	l2_1.next=l2_2
	'''

	printListNode(l1)
	print("=======")
	printListNode(l2)
	print("======")
	res=add(l1,l2)
	print("result")
	printListNode(res)
