package stack_and_queue

type StackOfPlates struct {
	cap  int
	nums [][]int
}

func Constructor_3(cap int) StackOfPlates {
	return StackOfPlates{
		cap:  cap,
		nums: [][]int{},
	}
}

func (this *StackOfPlates) Push(val int) {
	if this.cap <= 0 {
		return
	}
	length := len(this.nums)
	if length == 0 || len(this.nums[length-1]) == this.cap {
		this.nums = append(this.nums, []int{val})
		return
	}
	this.nums[length-1] = append(this.nums[length-1], val)
}

func (this *StackOfPlates) Pop() int {
	return this.PopAt(len(this.nums) - 1)
}

func (this *StackOfPlates) PopAt(index int) int {
	if this.cap <= 0 {
		return -1
	}
	if index < 0 || index > len(this.nums)-1 {
		return -1
	}

	ints := this.nums[index]
	length := len(ints)
	res := ints[length-1]

	if len(ints) == 1 {
		if len(this.nums) == index+1 {
			this.nums = this.nums[:index]
		} else {
			this.nums = append(this.nums[:index], this.nums[index+1:]...)
		}
	} else {
		this.nums[index] = ints[:length-1]
	}

	return res
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * obj := Constructor(cap);
 * obj.Push(val);
 * param_2 := obj.Pop();
 * param_3 := obj.PopAt(index);
 */
