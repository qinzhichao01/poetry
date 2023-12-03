package stack_and_queue

type SortedStack struct {
	data []int
}

func Constructor_5() SortedStack {

	return SortedStack{}
}

func (this *SortedStack) Push(val int) {
	if len(this.data) == 0 || this.data[len(this.data)-1] <= val {
		this.data = append(this.data, val)
		return
	}
	if this.data[0] > val {
		this.data = append([]int{val}, this.data...)
		return
	}
	var index = len(this.data) - 1
	for index > 0 && this.data[index] > val {
		index--
	}
	this.data = append(this.data[:index+1], append([]int{val}, this.data[index+1:]...)...)
}

func (this *SortedStack) Pop() {
	if this.IsEmpty() {
		return
	}
	this.data = this.data[1:]
}

func (this *SortedStack) Peek() int {
	if this.IsEmpty() {
		return -1
	}
	return this.data[0]
}

func (this *SortedStack) IsEmpty() bool {

	return len(this.data) == 0
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.IsEmpty();
 */
