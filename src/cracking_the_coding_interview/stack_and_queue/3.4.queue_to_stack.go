package stack_and_queue

// 先进先出 ==> 后进后出

type MyQueue struct {
	instack, outstack []int
}

/** Initialize your data structure here. */
func Constructor_4() MyQueue {
	return MyQueue{}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	this.instack = append(this.instack, x)
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	if len(this.outstack) == 0 {
		this.in2out()
	}
	i := this.outstack[len(this.outstack)-1]
	this.outstack = this.outstack[:len(this.outstack)-1]
	return i
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	if len(this.outstack) == 0 {
		this.in2out()
	}
	return this.outstack[len(this.outstack)-1]
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return len(this.instack) == 0 && len(this.outstack) == 0

}

func (this *MyQueue) in2out() {
	if len(this.instack) == 0 {
		return
	}
	this.outstack = append(this.outstack, this.instack[0])
	this.instack = this.instack[1:len(this.instack)]
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
