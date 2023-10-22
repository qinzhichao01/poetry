package string_array

func isFlipedString(s1 string, s2 string) bool {
	// 如果长度不等，一定不符合条件
	if len(s1) != len(s2) {
		return false
	}
	// 如果存在一个字段，那么第二个字符串的某个位置开始循环访问的时候必然和第一个 string 每个字符串都相同

	if s2 == s1 {
		return true
	}
	for i := 0; i < len(s2); i++ {
		if s2[i] != s1[0] {
			continue
		}
		var idx2, count = i, 0
		for idx1 := 0; idx1 < len(s1); idx1++ {
			if idx2 == len(s2) {
				idx2 = 0
			}
			if s2[idx2] != s1[idx1] {
				break
			}
			idx2++
			count++
		}
		if count == len(s1) {
			return true
		}
	}
	return false
}
